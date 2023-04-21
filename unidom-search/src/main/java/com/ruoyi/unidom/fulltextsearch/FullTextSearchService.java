package com.ruoyi.unidom.fulltextsearch;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.PageResponse;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.common.util.EsUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class FullTextSearchService {

    @Autowired
    DocumentPlusService docSv;

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

        // PageResult<ObjectNode> pageResult = docSv.search("unidom_event_data", "unidom_event_data", ObjectNode.class, rootQueryBuilder, null, 1, 10, null, null, highlightFields, null);
        PageResult<ObjectNode> pageResult = docSv.search(listIndexName, listIndexName, ObjectNode.class, rootQueryBuilder, null, 1, 10, null, null, highlightFields, null);

        return pageResult;
    }



}
