package com.ruoyi.unidom.fulltextsearch;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.PageResponse;
import com.ruoyi.unidom.common.util.CollectionUtil;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import com.ruoyi.unidom.common.util.StringUtil;
import com.ruoyi.unidom.esvo.EsSortVO;
import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import com.ruoyi.unidom.indices.service.ITUdsModuleDefService;
import org.apache.lucene.search.join.ScoreMode;
import org.apache.poi.ss.formula.functions.T;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.common.util.EsUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullTextSearchService {

    @Autowired
    DocumentPlusService docSv;

    @Autowired
    ITUdsModuleDefService tUdsModuleDefService;

    public PageResult<ObjectNode> fullTextSearch(String keyword) {
//        PageResponse pageResult = docSv.search("listIndexName", null, ObjectNode.class, rootQueryBuilder, null, from, pageSize, null, null, null, listSortBuilder);

        MultiMatchQueryBuilder multiMatch = QueryBuilders.multiMatchQuery(keyword, "dataTitle", "dataDesc");
        BoolQueryBuilder rootQueryBuilder = QueryBuilders.boolQuery();
        rootQueryBuilder.must(multiMatch);
        List<String> highlightFields = new ArrayList<>();
        highlightFields.add("dataTitle");
        highlightFields.add("dataDesc");

        //获取索引名称信息
        List<String> listIndexName=new ArrayList<>();
        List<TUdsModuleDef> listModuleDef = tUdsModuleDefService.selectTUdsModuleDefList(new TUdsModuleDef());
        for(TUdsModuleDef moduleDef:listModuleDef){
            listIndexName.add(moduleDef.getModuleIndiceAlias());
        }

        // PageResult<ObjectNode> pageResult = docSv.search("unidom_event_data", "unidom_event_data", ObjectNode.class, rootQueryBuilder, null, 1, 10, null, null, highlightFields, null);
        PageResult<ObjectNode> pageResult = docSv.search(listIndexName,null, ObjectNode.class, rootQueryBuilder, null, 0, 10000, null, null, highlightFields, null);

        return pageResult;
    }

    public PageResult<ObjectNode> pageSearch(String keyword, int pageNum, int pageSize, List<String> filterModuleCodes){
        PageResult<ObjectNode> pageResult = new PageResult();
        if (pageNum < 1) {
            pageNum = 1;
        }
        //pageSize未传时，默认返回10条
        if (pageSize < 1) {
            pageSize = 10;
        }
        //定义查询开始位置
        int from = (pageNum - 1) * pageSize;
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);

        //获取索引别名信息
        List<String> listIndexName=new ArrayList<>();
        if(filterModuleCodes!=null && filterModuleCodes.size()>0){

            for(String moduleCode:filterModuleCodes){
                TUdsModuleDef moduleDef = tUdsModuleDefService.selectTUdsModuleDefByCode(moduleCode);
                listIndexName.add(moduleDef.getModuleIndiceAlias());
            }
        }
        else {
            List<TUdsModuleDef> listModuleDef = tUdsModuleDefService.selectTUdsModuleDefList(new TUdsModuleDef());
            for(TUdsModuleDef moduleDef:listModuleDef){
                listIndexName.add(moduleDef.getModuleIndiceAlias());
            }
        }
        //获取全文检索的字段列表
        List<String> listModuleFields = filterModuleCodes;

        //根查询条件
        BoolQueryBuilder rootQueryBuilder=QueryBuilders.boolQuery();

        if(StringUtil.isNotBlank(keyword)){
            //关键词匹配
            //关键词multiMatch
            QueryBuilder multiMatch = new MultiMatchQueryBuilder(keyword, "dataTitle", "dataDesc");
            rootQueryBuilder.must(multiMatch);
        }
        List<String> highlightFields = new ArrayList<>();
        highlightFields.add("dataTitle");
        highlightFields.add("dataDesc");

        //拼装排序条件
//        List<SortBuilder> listSortBuilder=new ArrayList<>();
//        if (!CollectionUtil.isEmpty(listSorts)) {
//            listSorts.stream().forEach(p -> {
//                FieldSortBuilder fieldSortBuilder = new FieldSortBuilder(p.getSortField());
//                fieldSortBuilder.order(p.getSortOrder());
//                listSortBuilder.add(fieldSortBuilder);
//            });
//        }

        //执行查询
        pageResult = docSv.search(listIndexName, null, ObjectNode.class, rootQueryBuilder, null, from, pageSize, null, null, highlightFields,null);

        return pageResult;
    }

    public ObjectNode moduleDetail(String moduleCode, String esId) {
        TUdsModuleDef moduleDef = tUdsModuleDefService.selectTUdsModuleDefByCode(moduleCode);
        ObjectNode result = docSv.getById(moduleDef.getModuleIndiceName(),moduleDef.getModuleIndiceName(),ObjectNode.class,esId);
        return result;
    }
}
