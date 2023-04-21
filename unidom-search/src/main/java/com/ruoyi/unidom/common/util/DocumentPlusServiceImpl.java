package com.ruoyi.unidom.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.model.IdEntity;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.main.MainResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class DocumentPlusServiceImpl implements DocumentPlusService {

    public static final String ES_INDEX = "_index";
    public static final String ES_TYPE = "_type";
    public static final String ES_ID = "_id";
    public static final String ES_SCORE = "_score";
    public static final String GEO_DISTANCE = "geoDistance";
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private BulkProcessor bulkProcessor;

    private static final int MAX_SIZE = 1000;

    private static final int BUFFER_SIZE = 200 * 1024 * 1024;

    // 重试3次
    @Value("${es_update_retry_on_conflict:3}")
    private int retryOnConflict = 3;

    /**
     * es查询的最大数量
     */
    @Value("${es_search_maxSize:10000}")
    protected Integer esSearchMaxSize;


    @Override
    public <T> String add(String index, String type,
                          T entity) {
        return  add(index,type,entity,null);
    }

    @Override
    public <T> String add(String index, String type,
                          T entity,String pipeline) {
        try {
            boolean hasId = hasId(entity);
            IndexRequest indexRequest = null;
            if (hasId) {
                String id="";
                if(entity instanceof IdEntity){
                    id=((IdEntity) entity).getId();
                }
                indexRequest = new IndexRequest(index, type, id);
            } else {
                indexRequest = new IndexRequest(index, type);
            }
            if(!StringUtil.isBlank(pipeline)){
                indexRequest.setPipeline(pipeline);
            }
            indexRequest.source(JacksonPlusUtil.toJson(entity), XContentType.JSON);

            IndexResponse indexResponse = restHighLevelClient
                    .index(indexRequest, RequestOptions.DEFAULT);
            return indexResponse.getId();
        } catch (Exception e) {
            log.error("add document exception,index:{},type:{}", index, type, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T extends IdEntity> int update(String index, String type, T entity) {
        return 0;
    }

//    @Override
//    public <T extends IdEntity> int update(String index, String type, T entity) {
//        return 0;
//    }
//
//    @Override
//    public <T extends IdEntity> int update(String index, String type,
//                                           T entity) {
//        try {
//            UpdateRequest request = new UpdateRequest(index, type, entity.getId());
//            request.doc(JacksonPlusUtil.toJson(entity), XContentType.JSON);
//            UpdateResponse response = restHighLevelClient
//                    .update(request, RequestOptions.DEFAULT);
//
//            log.debug("update doc index:{},type:{},id:{},result:{},getResult:{}", index, type,
//                    entity.getId(),
//                    response.getResult(), response.getGetResult());
//            if (response.getResult() == Result.NOOP || response.getResult() == Result.NOT_FOUND) {
//                return 0;
//            }
//            return 1;
//        } catch (Exception e) {
//            log.error("update doc exception ", e);
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public <T extends IdEntity> int upsert(String index, String type, T entity) {
        try {
            UpdateRequest request = new UpdateRequest(index, type, entity.getId())
                    .upsert(JacksonPlusUtil.toJson(entity), XContentType.JSON)
                    .retryOnConflict(retryOnConflict);
            request.doc(JacksonPlusUtil.toJson(entity), XContentType.JSON);
            UpdateResponse response = restHighLevelClient
                    .update(request, RequestOptions.DEFAULT);

            log.debug("upsert doc index:{},type:{},id:{},result:{},getResult:{}", index, type,
                    entity.getId(),
                    response.getResult(), response.getGetResult());
            if (response.getResult() == Result.NOOP || response.getResult() == Result.NOT_FOUND) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            log.error("upsert doc exception ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(String index, String type, String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return false;
            }
            GetRequest request = new GetRequest(index, type, id);
            request.fetchSourceContext(new FetchSourceContext(false));
            request.storedFields("_none_");
            return restHighLevelClient
                    .exists(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.error("doc exists exception", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getById(String index, String type,
                         Class<T> clazz, String id) {
        try {
            GetRequest request = new GetRequest(index, type, id);
            GetResponse response = restHighLevelClient
                    .get(request, RequestOptions.DEFAULT);
            if (response.isExists()) {
                String sourceAsString = response.getSourceAsString();
                return JacksonPlusUtil.fromJson(sourceAsString, clazz);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("get doc By Id exception,index:{},type:{},id:{}", index, type, id, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getByIds(String index, String type,
                                Class<T> clazz,
                                List<String> ids) {
        try {
            if (ids == null || ids.isEmpty()) {
                return new ArrayList<>();
            }
            MultiGetRequest multiGetRequest = new MultiGetRequest();
            ids.forEach(id -> {
                multiGetRequest.add(index, type, id);
            });
            MultiGetResponse multiGetResponses = restHighLevelClient
                    .mget(multiGetRequest, RequestOptions.DEFAULT);
            MultiGetItemResponse[] multiGetItemResponses = multiGetResponses.getResponses();
            List<T> dataList = new ArrayList<>();
            for (MultiGetItemResponse multiGetItemResponse : multiGetItemResponses) {
                GetResponse getResponse = multiGetItemResponse.getResponse();
                if (getResponse.isExists()) {
                    String sourceAsString = getResponse.getSourceAsString();
                    dataList.add(JacksonPlusUtil.fromJson(sourceAsString, clazz));
                } else {
//          log.error("index:{},type:{},id:{} not exist", index, type, getResponse.getId());
                }
            }
            return dataList;
        } catch (Exception e) {
            log.error("get doc By Id exception,index:{},type:{},ids:{}", index, type, ids, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateScriptById(String index, String type, String id,
                                Script script) {
        try {
            UpdateRequest request = new UpdateRequest(index, type, id);
            request.script(script);
            UpdateResponse response = restHighLevelClient
                    .update(request, RequestOptions.DEFAULT);
            log.debug("update doc index:{},type:{},id:{},result:{},getResult:{}", index, type,
                    id,
                    response.getResult(), response.getGetResult());
            if (response.getResult() == Result.NOOP || response.getResult() == Result.NOT_FOUND) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            log.error("update doc exception ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public long updateScriptByQuery(String index, String type,
                                    QueryBuilder queryBuilder,
                                    Script script) {
        try {
            log.info("index:{},type:{},queryBuilder:{},script:{}", index, type,
                    JacksonPlusUtil.toJson(queryBuilder), JacksonPlusUtil.toJson(script));
            UpdateByQueryRequest request = new UpdateByQueryRequest(index);
            request.setDocTypes(type);
            request.setQuery(queryBuilder);
            request.setScript(script);
            request.setConflicts("proceed");
            BulkByScrollResponse response = restHighLevelClient
                    .updateByQuery(request, RequestOptions.DEFAULT);

            log.info("update by query,response:{}", response);

            return response.getUpdated();
        } catch (Exception e) {
            log.error("update doc exception ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(String index, String type, String id) {
        try {
            DeleteRequest request = new DeleteRequest(index, type, id);
            DeleteResponse response = restHighLevelClient
                    .delete(request, RequestOptions.DEFAULT);
            if (response.getResult() == Result.NOOP || response.getResult() == Result.NOT_FOUND) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            log.error("delete doc exception,index:{},type:{},id:{}", index, type, id, e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public <T> PageResult<T> search(String index, String type, Class<T> clazz, QueryBuilder queryBuilder, CollapseBuilder collapseBuilder,int from, int size, List<String> includeFields, List<String> excludeFields, List<String> highlightFields, List<SortBuilder> sortBuilders) {
        List<String> indexList = Stream.of(index).collect(Collectors.toList());
        List<String> typeList =new ArrayList<>();
        if(!StringUtil.isBlank(type)){
            typeList = Stream.of(type).collect(Collectors.toList());
        }
        return search(indexList,typeList,clazz,queryBuilder,collapseBuilder,from,size,includeFields,excludeFields,highlightFields,sortBuilders);
    }

    @Override
    public <T> PageResult<T> search(List<String> index, List<String> type, Class<T> clazz, QueryBuilder queryBuilder, CollapseBuilder collapseBuilder,int from, int size, List<String> includeFields, List<String> excludeFields, List<String> highlightFields, List<SortBuilder> sortBuilders) {
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            //查询条件
            if (queryBuilder != null) {
                sourceBuilder.query(queryBuilder);
            }

            //折叠查询条件
            if(collapseBuilder!=null){
                sourceBuilder.collapse(collapseBuilder);
            }

            String[] includes = null;
            String[] excludes = null;

            if (includeFields != null && !includeFields.isEmpty()) {
                includes = includeFields.toArray(new String[includeFields.size()]);
            }
            if (excludeFields != null && !excludeFields.isEmpty()) {
                excludes = excludeFields.toArray(new String[excludeFields.size()]);
            }

            sourceBuilder.fetchSource(includes, excludes);
            //高亮显示条件设置
            if (highlightFields != null && !highlightFields.isEmpty()) {
                HighlightBuilder highlightBuilder = new HighlightBuilder();
                for (String highlightFileld:highlightFields) {
                    highlightBuilder.field(highlightFileld, 1000)
                            .preTags("<font color='red'>")
                            .postTags("</font>");
                    sourceBuilder.highlighter(highlightBuilder);

                };
            }
            SearchResponse searchResponse = this.search(index, type, from, size, sourceBuilder);
            RestStatus status = searchResponse.status();

            if (status != RestStatus.OK) {
                throw new RuntimeException("search index exception");
            }
            //处理查询结果
            SearchHits hits = searchResponse.getHits();
            SearchHit[] searchHits = hits.getHits();
            // long total = hits.getTotalHits();
            long total = hits.getHits().length;
            //查询结果为空
            if (searchHits == null || searchHits.length == 0) {
                return new PageResult(Collections.emptyList(), total);
            }
            //处理查询结果
            List<T> entityList = new ArrayList<>();


            for (SearchHit searchHit : searchHits) {
                Map<String, HighlightField> highlights = searchHit.getHighlightFields();
                String indexName=searchHit.getIndex();
                String typeName=searchHit.getType();
                String id=searchHit.getId();
                float score=searchHit.getScore();

                if (highlights.isEmpty()) {
                    String sourceAsString = searchHit.getSourceAsString();
                    ObjectNode obj=JacksonPlusUtil.fromJson(sourceAsString,ObjectNode.class);
                    obj.put(ES_INDEX,indexName);
                    obj.put(ES_TYPE,typeName);
                    obj.put(ES_ID,id);
                    obj.put(ES_SCORE,score);

                    T entity = JacksonPlusUtil.fromJson(JacksonPlusUtil.toJson(obj),clazz);
                    entityList.add(entity);

                } else {
                    // 含义高亮显示
                    Map<String, Object> source = searchHit.getSourceAsMap();
                    source.put(ES_INDEX,indexName);
                    source.put(ES_TYPE,typeName);
                    source.put(ES_ID,typeName);
                    source.put(ES_SCORE,score);


                    entityList.add(fromMap(source, highlights, clazz, null));
                }

            }
            return new PageResult(entityList, total);
        } catch (Exception e) {
            log.error("query exception ", e);
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public <T> List<CollapseResult<T>> collapseSearch(List<String> index, List<String> type, Class<T> clazz, QueryBuilder queryBuilder, CollapseBuilder collapseBuilder, List<String> includeFields, List<String> excludeFields,int from, int size, List<SortBuilder<?>> sortBuilders) {
//        List<CollapseResult<T>> result=new ArrayList<>();
//        try {
//            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//            //查询条件
//            if (queryBuilder != null) {
//                sourceBuilder.query(queryBuilder);
//            }
//
//            int innerSortGeoDistanceIndex=-1;
//            //折叠查询条件
//            if(collapseBuilder!=null){
//
//                List<InnerHitBuilder> innerHits = collapseBuilder.getInnerHits();
//                if(!CollectionUtil.isEmpty(innerHits)){
//                    //默认判断第一个innerHit中是否有距离排序条件
//                    InnerHitBuilder innerHitBuilder=innerHits.get(0);
//                    List<SortBuilder<?>> innerSorts = innerHitBuilder.getSorts();
//                    if(!CollectionUtil.isEmpty(innerSorts)){
//                        for (int i=0;i<innerSorts.size();i++) {
//                            SortBuilder innerSortBuilder=innerSorts.get(i);
//                            if(innerSortBuilder instanceof GeoDistanceSortBuilder){
//                                innerSortGeoDistanceIndex=i;
//                                break;
//                            }
//                        }
//                    }
//
//                }
//                sourceBuilder.collapse(collapseBuilder);
//            }
//
//            // 自行设置排序条件
//            //经纬度的排序条件的index，-1：无，大于-1 代表有
//            int outSortGeoDistanceIndex=-1;
//            if (!CollectionUtil.isEmpty(sortBuilders)) {
//                for (int i=0;i<sortBuilders.size();i++) {
//                    SortBuilder sortBuilder=sortBuilders.get(i);
//                    sourceBuilder.sort(sortBuilder);
//
//                    if(sortBuilder instanceof GeoDistanceSortBuilder){
//                        outSortGeoDistanceIndex=i;
//                    }
//                }
//            }
//
//            String[] includes = null;
//            String[] excludes = null;
//
//            if (includeFields != null && !includeFields.isEmpty()) {
//                includes = includeFields.toArray(new String[includeFields.size()]);
//            }
//            if (excludeFields != null && !excludeFields.isEmpty()) {
//                excludes = excludeFields.toArray(new String[excludeFields.size()]);
//            }
//
//            sourceBuilder.fetchSource(includes, excludes);
//
//            SearchResponse searchResponse = this.search(index, type, from, size, sourceBuilder);
//            RestStatus status = searchResponse.status();
//
//            if (status != RestStatus.OK) {
//                throw new RuntimeException("search index exception");
//            }
//            //处理查询结果
//            SearchHits hits = searchResponse.getHits();
//            SearchHit[] searchHits = hits.getHits();
//            long total = hits.getTotalHits();
//            //查询结果为空
//            if (searchHits == null || searchHits.length == 0) {
//                return result;
//            }
//
//
//            //最外层的for循环 for1
//            for (SearchHit searchHit : searchHits) {
//                CollapseResult<T> collapseResult=new CollapseResult<>();
//
//                Map<String, HighlightField> highlights = searchHit.getHighlightFields();
//
//                //折叠的字段信息
//                Map<String, DocumentField> mapCollapseFields= searchHit.getFields();
//
//                if(mapCollapseFields.size()==0){
//                    continue;
//                }
//
//                //获取折叠字段名称
//                String collapseFiledName=ESMapUtil.getDocumentFieldFirstKey(mapCollapseFields);
//                DocumentField collapseFiled=mapCollapseFields.get(collapseFiledName);
//                //获取折叠字段值
//                Object collapseFiledValue= collapseFiled.getValue();
//                collapseResult.setCollpaseFieldName(collapseFiled.getName());
//                collapseResult.setCollpaseFieldValue(String.valueOf(collapseFiledValue));
//
//                Map<String, SearchHits> mapTopInnerHits=searchHit.getInnerHits();
//                if(mapTopInnerHits!=null){
//                    //获取折叠查询的名称，如调用方传入的 inner_top_hits
//                    String collapseInnerHitsName=ESMapUtil.getSearchHitsFirstKey(mapTopInnerHits);
//                    //获取折叠的hits map 对应的SearchHits对象
//                    SearchHits collapseInnerHits=mapTopInnerHits.get(collapseInnerHitsName);
//                    //折叠字段对应的总命中数
//                    long totalHits = collapseInnerHits.getTotalHits();
//                    collapseResult.setCollapseTotalCount(totalHits);
//                    float maxScore = collapseInnerHits.getMaxScore();
//                    collapseResult.setCollapseMaxScore(maxScore);
//
//
//                    //处理查询结果
//                    List<T> entityList = new ArrayList<>();
//                    //for2 里层inner_hit for循环
//                    for (SearchHit innerHit : collapseInnerHits) {
//                        String indexName=innerHit.getIndex();
//                        String typeName=innerHit.getType();
//                        String id=innerHit.getId();
//                        float score=innerHit.getScore();
//
//                        String sourceAsString = innerHit.getSourceAsString();
//                        ObjectNode obj=JacksonPlusUtil.fromJson(sourceAsString,ObjectNode.class);
//                        obj.put(ES_INDEX,indexName);
//                        obj.put(ES_TYPE,typeName);
//                        obj.put(ES_ID,id);
//                        obj.put(ES_SCORE,score);
//
//
//                        if(innerSortGeoDistanceIndex>-1){
//                            double sortDistance = (double) innerHit.getSortValues()[innerSortGeoDistanceIndex];
//                            BigDecimal geoDis = new BigDecimal(sortDistance);
//                            obj.put(GEO_DISTANCE, geoDis.setScale(2, BigDecimal.ROUND_HALF_DOWN));
//                        }
//
//
//                        T entity = JacksonPlusUtil.fromJson(JacksonPlusUtil.toJson(obj),clazz);
//                        entityList.add(entity);
//                    }//end for2 里层inner_hit for循环
//                    collapseResult.setCollapseData(entityList);
//
//                }// end if
//                result.add(collapseResult);
//
//            }//end for1 最外层的for循环
//            return result;
//        } catch (Exception e) {
//            log.error("query exception ", e);
//            throw new RuntimeException(e);
//        }
//    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    private <T> T fromJson(String source, Class clazz, TypeReference<T> typeReference) {
        T t = null;
        if (null != clazz && !clazz.isAssignableFrom(String.class)) {
            try {
                t = (T) JacksonPlusUtil.fromJson(source, clazz);
            } catch (Exception e) {
                log.error("error:{}",e.getMessage(),e);
            }
        } else if (null != typeReference) {
            TypeReference<T> valueTypeRef =new TypeReference<T>() {
            };

            try {
                t = JacksonPlusUtil.fromJson(source, valueTypeRef);
            } catch (Exception e) {
                log.error("error:{}",e.getMessage(),e);
            }
        } else {
            t = (T) source;
        }
        return t;

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private <T> T fromMap(Map<String, Object> source, Map<String, HighlightField> highlights, Class clazz,
                          TypeReference<T> typeReference) {
        Map<String, Object> target = new HashMap(source.size());
        target.putAll(source);
        // 先进行字段内容替换，循环highlights，它应该比较小
        highlights.forEach((field, highlight) ->
        {
            if (target.containsKey(field.replaceAll(".pinyin",""))) {
                Text[] texts = highlight.getFragments();
                StringBuilder sb = new StringBuilder();
                for (Text text : texts) {
                    sb.append(text);
                }
                target.put(field.replaceAll(".pinyin",""), sb.toString());
            }
        });
        // 开始组装
        return fromJson(JacksonPlusUtil.toJson(target), clazz, typeReference);

    }

    @Override
    public <T> PageResult<T> search(String index, String type,
                                    Class<T> clazz,
                                    QueryBuilder queryBuilder,
                                    CollapseBuilder collapseBuilder,
                                    int from, int size, List<SortBuilder> sortBuilders) {
        return this.search(index, type, clazz, queryBuilder,collapseBuilder, from, size, null, null,null,
                sortBuilders);
    }

    @Override
    public long deleteByQuery(String index, String type,
                              QueryBuilder queryBuilder) {
        try {
            DeleteByQueryRequest request =
                    new DeleteByQueryRequest(index);
            request.setDocTypes(type);
            request.setQuery(queryBuilder);
            request.setConflicts("proceed");
            BulkByScrollResponse bulkResponse =
                    restHighLevelClient
                            .deleteByQuery(request, RequestOptions.DEFAULT);

            log.info("delete by query,response:{}", bulkResponse);

            return bulkResponse.getDeleted();

        } catch (Exception e) {
            log.error("delete by query exception", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public long count(String index, QueryBuilder queryBuilder) {
        try {
            CountRequest countRequest = new CountRequest(index);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(queryBuilder);
            countRequest.source(searchSourceBuilder);
            CountResponse response =
                    restHighLevelClient
                            .count(countRequest, RequestOptions.DEFAULT);
            return response.getCount();
        } catch (Exception e) {
            log.error("count exception ", e);
            throw new RuntimeException(e);
        }
    }

    private SearchResponse search(List<String> index, List<String> type, int from,
                                  int size,
                                  SearchSourceBuilder sourceBuilder)
            throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(index.toArray(new String[index.size()]));
        //type非空时，才传入
        if(!CollectionUtil.isEmpty(type)){
            searchRequest.types(type.toArray(new String[type.size()]));
        }
        searchRequest.source(sourceBuilder);

        // 返回数量
        sourceBuilder.from(0);
        if (size > esSearchMaxSize) {
            log.info("elasticSearch 最多返回{}条记录", esSearchMaxSize);
            sourceBuilder.size(esSearchMaxSize);
        } else {
            sourceBuilder.size(size);
        }
        sourceBuilder.from(from);

        log.info("--ES searchquery search index:{},type:{}, sourceBuilder:\r\n{}", JacksonPlusUtil.toJson(index),JacksonPlusUtil.toJson(type), Strings.toString(sourceBuilder));

        HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory consumerFactory =
                new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(BUFFER_SIZE);
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        builder.setHttpAsyncResponseConsumerFactory(consumerFactory);
        RequestOptions requestOptions1 = builder.build();
        SearchResponse searchResponse = restHighLevelClient
                .search(searchRequest, requestOptions1);
        log.info("--ES searchresult search index:{},type:{}, searchResponse:\r\n{}", JacksonPlusUtil.toJson(index),JacksonPlusUtil.toJson(type), Strings.toString(searchResponse));



        return searchResponse;
    }

    private <T> boolean hasId(T entity) {
        if (IdEntity.class.isAssignableFrom(entity.getClass())) {
            if(entity instanceof  IdEntity){
                return !StringUtils.isEmpty(((IdEntity) entity).getId());
            }
        }
        return false;
    }

    @Override
    public <T> List<T> suggest(String indexName, QueryBuilder queryBuilder, String[] fields, String value, int count, Class<T> clazz) {

        List<T> suggests = new ArrayList<>();
        if ( fields == null || fields.length <= 0 || StringUtil.isBlank(value)
                || count <= 0) {
            return suggests;
        }

        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 先拼装加上查询条件
        if(null!=queryBuilder){
            searchSourceBuilder.query(queryBuilder);
        }
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        @SuppressWarnings("rawtypes")
        SuggestionBuilder suggestionBuilder = null;
        // 拼装每个字段的suggest
        for (String field : fields) {
            suggestionBuilder = SuggestBuilders.completionSuggestion(field)
                    .prefix(value)
                    .text(value)
                    .size(count)
                    .skipDuplicates(true);
            suggestBuilder.addSuggestion(field + "-suggest", suggestionBuilder);
        }
        searchSourceBuilder.suggest(suggestBuilder);
        searchRequest.source(searchSourceBuilder);
        log.info("es suggestion:\r\n{}", Strings.toString(searchRequest.source()));
        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException("suggest error!", e);
        }
        if (null == response) {
            return suggests;
        }
        suggests = new ArrayList<>(60);
        String source = null;
        T t = null;
        // 这里循环获取结果
        for (String field : fields) {
            if(response!=null&&response.getSuggest()!=null){
                CompletionSuggestion suggestion = response.getSuggest().getSuggestion(field + "-suggest");
                if (null == suggestion || null == suggestion.getOptions()) {
                    continue;
                }
                List<CompletionSuggestion.Entry.Option> options = suggestion.getOptions();
                for (CompletionSuggestion.Entry.Option entry : options) {
                    source = entry.getHit().getSourceAsString();
                    t = JacksonPlusUtil.fromJson(source, clazz);
                    suggests.add(t);
                }
            }

        }
        return suggests;
    }

//    /**
//     * 聚合统计，统计前topCount的文档，聚合结果以分组数量倒序排序
//     * @param indexName
//     * @param queryBuilder
//     * @param aggField
//     * @param topCount
//     * @return
//     */
//    @Override
//    public List<TopCountAggResult> topCountAgg(String indexName, QueryBuilder queryBuilder, String aggField, int topCount) {
//
//        List<TopCountAggResult> result = new ArrayList<>();
//        try {
//
//            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//            //统计接口不查询明细 size设置为0
//            searchSourceBuilder.timeout(new TimeValue(60000)).size(0);
//            if(queryBuilder!=null){
//                searchSourceBuilder.query(queryBuilder);
//            }
//            searchSourceBuilder.aggregation(AggregationBuilders.terms(aggField + "_aggs").field(aggField).size(topCount));
//            SearchRequest searchRequest = new SearchRequest(indexName);
//            searchRequest.source(searchSourceBuilder);
//
//            log.info("--ES searchquery aggregate index:{}, sourceBuilder:\r\n{}", JacksonPlusUtil.toJson(indexName), Strings.toString(searchSourceBuilder));
//
//            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//            log.info("--ES searchresult aggregate index:{}, searchResponse:\r\n{}", JacksonPlusUtil.toJson(indexName), Strings.toString(searchResponse));
//
//
//            Terms sortAggregate = searchResponse.getAggregations().get(aggField + "_aggs");
//            for (Terms.Bucket entry : sortAggregate.getBuckets()) {
//                result.add(new TopCountAggResult(entry.getKeyAsString(), entry.getDocCount(), aggField));
//            }
//        } catch (Exception e) {
//            throw new SearchRuntimeException("ES aggregation error", e);
//        }
//        return result;
//    }

    @Override
    public <T> void asyncBulkAdd(String index, String type,
                                 List<T> entityList) {
        asyncBulkAdd(index,type,entityList,null);
    }
    @Override
    public <T> void asyncBulkAdd(String index, String type,
                                 List<T> entityList,String pipeline) {
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        entityList.stream().forEach(entity -> {
            IndexRequest indexRequest = null;
            if (hasId(entity)) {
                String id="";
                if(entity instanceof  IdEntity){
                    id=((IdEntity) entity).getId();
                }
                indexRequest = new IndexRequest(index, type, id);
            } else {
                indexRequest = new IndexRequest(index, type);
            }
            if(!StringUtil.isBlank(pipeline)){
                indexRequest.setPipeline(pipeline);
            }
            try {
                indexRequest.source(JacksonPlusUtil.toJson(entity), XContentType.JSON);
            } catch (Exception e) {
                log.error(" bulkCreate exception,index:{},type:{}", index, type, e);
                throw new RuntimeException(e);
            }
            bulkProcessor.add(indexRequest);
        });
    }

    @Override
    public <T extends IdEntity> void asyncBulkUpdate(String index, String type,
                                                     List<T> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        entityList.stream().forEach(entity -> {
            UpdateRequest request = new UpdateRequest(index, type, entity.getId());
            try {
                request.doc(JacksonPlusUtil.toJson(entity), XContentType.JSON)
                        .upsert(JacksonPlusUtil.toJson(entity), XContentType.JSON)
                        .retryOnConflict(retryOnConflict);
            } catch (Exception e) {
                log.error(" bulkUpdate exception,index:{},type:{}", index, type, e);
                throw new RuntimeException(e);
            }
            bulkProcessor.add(request);
        });
    }


//    @Override
//    public void asyncBulkUpdateScript(String index, String type,
//                                      List<ScriptObject> scriptList) {
//        if (scriptList == null || scriptList.isEmpty()) {
//            return;
//        }
//        scriptList.stream().forEach(scriptObject -> {
//            asyncBulkUpdateScript(index, type, scriptObject);
//        });
//    }
//
//    private void asyncBulkUpdateScript(String index, String type,
//                                       ScriptObject scriptObject) {
//        UpdateRequest request = new UpdateRequest(index, type, scriptObject.getId());
//        request.script(scriptObject.getScript());
//        request.retryOnConflict(retryOnConflict);
//        bulkProcessor.add(request);
//    }

    @Override
    public void asyncBulkDelete(String index, String type, List<String> idList) {
        if (idList == null || idList.isEmpty()) {
            return;
        }
        idList.stream().forEach(id -> {
            DeleteRequest request = new DeleteRequest(index, type, id);
            bulkProcessor.add(request);
        });
    }

    @Override
    public <T> void syncBulkAdd(String index, String type,
                                List<T> entityList) {
        syncBulkAdd(index,type,entityList,null);
    }
    @Override
    public <T> void syncBulkAdd(String index, String type,
                                List<T> entityList,String pipeline) {
        try {
            if (entityList == null || entityList.isEmpty()) {
                return;
            }
            BulkRequest bulkRequest = new BulkRequest();
            for (T entity : entityList) {
                IndexRequest indexRequest = null;
                if (hasId(entity)) {
                    String id="";
                    if(entity instanceof  IdEntity){
                        id=((IdEntity) entity).getId();
                    }
                    indexRequest = new IndexRequest(index, type, id);
                } else {
                    indexRequest = new IndexRequest(index, type);
                }
                if(!StringUtil.isBlank(pipeline)){
                    indexRequest.setPipeline(pipeline);
                }
                indexRequest.source(JacksonPlusUtil.toJson(entity), XContentType.JSON);
                bulkRequest.add(indexRequest);
            }

            BulkResponse bulkResponse = restHighLevelClient
                    .bulk(bulkRequest, RequestOptions.DEFAULT);

            if (bulkResponse.hasFailures()) {
                throw new RuntimeException("bulkCreate exception" + bulkResponse.buildFailureMessage());
            }
        } catch (Exception e) {
            log.error(" bulkCreate exception,index:{},type:{}", index, type, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void syncBulkDelete(String index, String type,
                               List<String> idList) {
        try {
            if (idList == null || idList.isEmpty()) {
                return;
            }
            BulkRequest bulkRequest = new BulkRequest();
            for (String id : idList) {
                DeleteRequest deleteRequest = new DeleteRequest(index, type, id);
                bulkRequest.add(deleteRequest);
            }
            BulkResponse bulkResponse = restHighLevelClient
                    .bulk(bulkRequest, RequestOptions.DEFAULT);
            if (bulkResponse.hasFailures()) {
                throw new RuntimeException("BulkDelete exception" + bulkResponse.buildFailureMessage());
            }
        } catch (Exception e) {
            log.error(" BulkDelete exception,index:{},type:{}", index, type, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T extends IdEntity> void syncBulkUpdate(String index, String type,
                                                    List<T> entityList) {
        try {
            if (entityList == null || entityList.isEmpty()) {
                return;
            }
            BulkRequest bulkRequest = new BulkRequest();
            for (IdEntity entity : entityList) {
                UpdateRequest updateRequest = new UpdateRequest(index, type, entity.getId());
                updateRequest.doc(JacksonPlusUtil.toJson(entity), XContentType.JSON)
                        .upsert(JacksonPlusUtil.toJson(entity), XContentType.JSON)
                        .retryOnConflict(retryOnConflict);
                bulkRequest.add(updateRequest);
            }
            BulkResponse bulkResponse = restHighLevelClient
                    .bulk(bulkRequest, RequestOptions.DEFAULT);
            if (bulkResponse.hasFailures()) {
                throw new RuntimeException("BulkUpdate exception" + bulkResponse.buildFailureMessage());
            }
        } catch (Exception e) {
            log.error(" BulkUpdate exception,index:{},type:{}", index, type, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public MainResponse info() {
        return null;
    }

//    @Override
//    public void syncBulkUpdateScript(String index, String type,
//                                     List<ScriptObject> scriptObjects) {
//        try {
//            if (scriptObjects == null || scriptObjects.isEmpty()) {
//                return;
//            }
//            BulkRequest bulkRequest = new BulkRequest();
//            scriptObjects.forEach(scriptObject -> {
//                UpdateRequest request = new UpdateRequest(index, type, scriptObject.getId());
//                request.script(scriptObject.getScript());
//                request.retryOnConflict(retryOnConflict);
//                bulkRequest.add(request);
//            });
//            restHighLevelClient
//                    .bulk(bulkRequest, RequestOptions.DEFAULT);
//        } catch (Exception e) {
//            log.error(" syncBulkUpdateScript exception,index:{},type:{}", index, type, e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public MainResponse info() {
//        MainResponse mainResponse=null;
//        try{
//            mainResponse=restHighLevelClient.info(RequestOptions.DEFAULT);
//        }
//        catch (IOException e){
//            throw new GenericException(e.getMessage(),e);
//        }
//        return mainResponse;
//    }

    public <T> String addByPipline(String index, String type,
                                   T entity,String pipline) {
        try {
            boolean hasId = hasId(entity);
            IndexRequest indexRequest = null;
            if (hasId) {
                String id="";
                if(entity instanceof  IdEntity){
                    id=((IdEntity) entity).getId();
                }
                indexRequest = new IndexRequest(index, type, id);
            } else {
                indexRequest = new IndexRequest(index, type);
            }
            indexRequest.source(JacksonPlusUtil.toJson(entity), XContentType.JSON);
            indexRequest.setPipeline("");
            IndexResponse indexResponse = restHighLevelClient
                    .index(indexRequest, RequestOptions.DEFAULT);
            return indexResponse.getId();
        } catch (Exception e) {
            log.error("add document exception,index:{},type:{}", index, type, e);
            throw new RuntimeException(e);
        }
    }

}
