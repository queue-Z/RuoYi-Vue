package com.ruoyi.unidom.test.service;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.collection.mapper.UnidomEventDataMapper;
import com.ruoyi.unidom.collection.service.EventCollectionService;
import com.ruoyi.unidom.collection.service.IUnidomEventDataService;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.PageResponse;
import com.ruoyi.unidom.common.util.EsUtil;
import com.ruoyi.unidom.esvo.BaseESVO;
import com.ruoyi.unidom.esvo.EventESVO;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventCollectionServiceTest {
    @Resource
    EventCollectionService eventCollectionService;

    @Resource
    IUnidomEventDataService unidomEventDataService;

    @Resource
    UnidomEventDataMapper unidomEventDataMapper;

    @Resource
    DocumentPlusService documentPlusService;

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private EsUtil esUtil;

    @Test
    public void db2esTest() {
        eventCollectionService.collectEvent();
    }

    @Test
    public void test(){
        UnidomEventData eventData =  unidomEventDataMapper.selectUnidomEventDataById("m_event_310107_002");
        EventESVO esvo =new EventESVO();
        BaseESVO baseESVO =new BaseESVO();
        BeanUtils.copyProperties(eventData,esvo);
        System.out.println(esvo);
        esvo.setEventId(baseESVO.getId());
        BeanUtils.copyProperties(eventData,baseESVO);
        BeanUtils.copyProperties(baseESVO,esvo);
        documentPlusService.add("unidom_event_data", "unidom_event_data", esvo);
        System.out.println(esvo);
        System.out.println(baseESVO);

    }

    @Test
    public void test2(){
        UnidomEventData eventData =  unidomEventDataMapper.selectUnidomEventDataById("m_event_310107_002");
        eventData.setEsUpdateTime(new Timestamp(System.currentTimeMillis()));
        documentPlusService.add("unidom_event_data", "unidom_event_data", eventData);
    }

    @Test
    public void addDoc() throws IOException {
        IndexRequest request=new IndexRequest();

        // 2.创建实体类对象，填充数据
        UnidomEventData eventData =  unidomEventDataMapper.selectUnidomEventDataById("m_event_310107_002");
        eventData.setEsUpdateTime(new Timestamp(System.currentTimeMillis()));

        // index()方法设置索引名；id()方法设置唯一id标识
        request.index("unidom_event_data").id(eventData.getId()).type("unidom_event_data");

        // 3.利用jackson将实体类对象转换成JSON格式字符串
        request.source(JSON.toJSONString(eventData), XContentType.JSON);
        System.out.println(JSON.toJSONString(eventData));
        // 5.发送请求，获取响应结果
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println("_index: "+response.getIndex());
        System.out.println("_id: "+response.getId());
        System.out.println("_result: "+response.getResult());
    }

    @Test
    public void test3(){
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        PageResponse<UnidomEventData> pageResponse = esUtil.search("unidom_event_data", searchSourceBuilder,
//                UnidomEventData.class, 1, 10);
//        System.out.println(pageResponse);
    }

    @Test
    public void test4(){
        //关键词"普陀"，查询
        MultiMatchQueryBuilder multiMatch = QueryBuilders.multiMatchQuery("普陀", "eventTitle", "eventContent");
        BoolQueryBuilder rootQueryBuilder = QueryBuilders.boolQuery();
        rootQueryBuilder.must(multiMatch);
        PageResult<UnidomEventData> pageResult = documentPlusService.search("unidom_event_data", "unidom_event_data", UnidomEventData.class, rootQueryBuilder, null, 1, 10, null, null, null, null);
        System.out.println(pageResult);
    }

}
