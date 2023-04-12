package com.ruoyi.unidom.test.service;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullTextSearchServiceTest {
    @Autowired
    DocumentPlusService docSv;

    @Autowired
    RestHighLevelClient client;

    @Test
    public void searchTest() throws IOException {
        //pageResult = docSv.search(listIndexName, null, ObjectNode.class, rootQueryBuilder, null, from, pageSize, null, null, null, listSortBuilder);
        SearchRequest searchRequest = new SearchRequest("unidom_event_data");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //排序
        sourceBuilder.sort("id", SortOrder.ASC);
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(matchAllQueryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        for (SearchHit documentFields : response.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }

    @Test
    public void matchQuery() {
        try {
            // 构建查询条件
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            searchSourceBuilder.query(QueryBuilders.multiMatchQuery("普陀").analyzer("ik_smart"));

            // 创建查询请求对象，将查询对象配置到其中
            SearchRequest searchRequest = new SearchRequest("unidom_event_data");
            searchRequest.source(searchSourceBuilder);
            // 执行查询，然后处理响应结果
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            // 根据状态和数据条数验证是否返回了数据
            if (RestStatus.OK.equals(searchResponse.status()) ) {
                SearchHits hits = searchResponse.getHits();
                for (SearchHit hit : hits) {
                    // 将 JSON 转换成对象
                    UnidomEventData eventData = JSON.parseObject(hit.getSourceAsString(), UnidomEventData.class);
                    // 输出查询信息
                    System.out.println(eventData.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("查询失败");
        }
    }

}
