package com.ruoyi.unidom.fulltextsearch;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.PageResponse;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import com.ruoyi.unidom.common.util.StringUtil;
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
        listIndexName.add("unidom_event_data");
        listIndexName.add("unidom_file_data");
        listIndexName.add("unidom_people_data");
        listIndexName.add("unidom_place_data");
        listIndexName.add("unidom_organization_data");

        // PageResult<ObjectNode> pageResult = docSv.search("unidom_event_data", "unidom_event_data", ObjectNode.class, rootQueryBuilder, null, 1, 10, null, null, highlightFields, null);
        PageResult<ObjectNode> pageResult = docSv.search(listIndexName, listIndexName, ObjectNode.class, rootQueryBuilder, null, 0, 1000, null, null, highlightFields, null);

        return pageResult;
    }

    public PageResult<ObjectNode> pageSearch(String keyword, int pageNum, int pageSize, List<String> filterModuleCodes){
        //定义返回结果
        if(pageNum<1){
            pageNum=1;
        }
        //定义查询开始位置
        int from=(pageNum-1)*pageSize;

        //获取索引名称信息
        List<String> listIndexName=new ArrayList<>();
        if(filterModuleCodes!=null && filterModuleCodes.size()>0){

            for(String moduleCode:filterModuleCodes){
                TUdsModuleDef moduleDef = tUdsModuleDefService.selectTUdsModuleDefByCode(moduleCode);
                listIndexName.add(moduleDef.getModuleIndiceAlias());
            }
        }else {
            List<TUdsModuleDef> listModuleDef = tUdsModuleDefService.selectTUdsModuleDefList(new TUdsModuleDef());
            for(TUdsModuleDef moduleDef:listModuleDef){
                listIndexName.add(moduleDef.getModuleIndiceName());
            }
        }
//        //获取全文检索的字段列表
//        List<String> listModuleFields = filterModuleCodes;

        //根查询条件
        BoolQueryBuilder rootQueryBuilder=QueryBuilders.boolQuery();

        if(StringUtil.isNotBlank(keyword)){
            //关键词匹配
            //关键词multiMatch
            QueryBuilder multiMatch = new MultiMatchQueryBuilder(keyword, "dataTitle", "dataDesc");
            rootQueryBuilder.must(multiMatch);
        }

        //拼装排序条件
        List<SortBuilder> listSortBuilder=new ArrayList<>();

        PageResult<ObjectNode> result = docSv.search(listIndexName, null, ObjectNode.class, rootQueryBuilder, null, from, pageSize, null, null, null, listSortBuilder);

        return result;
    }

    public ObjectNode moduleDetail(String moduleCode, String esId) {
        TUdsModuleDef moduleDef = tUdsModuleDefService.selectTUdsModuleDefByCode(moduleCode);
        ObjectNode result = docSv.getById(moduleDef.getModuleIndiceName(),moduleDef.getModuleIndiceName(),ObjectNode.class,esId);
        return result;
    }
}
