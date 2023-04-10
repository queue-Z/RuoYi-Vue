package com.ruoyi.unidom.util;

import org.elasticsearch.action.main.MainResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.script.Script;
import com.ruoyi.unidom.model.IdEntity;

import java.util.List;

public interface DocumentPlusService {

    <T> String add(String index, String type, T entity);
    <T> String add(String index, String type, T entity,String pipeline);

    <T extends IdEntity> int update(String index, String type, T entity);

    <T extends IdEntity> int upsert(String index, String type, T entity);


    boolean exists(String index, String type, String id);

    <T> T getById(String index, String type, Class<T> clazz,
                  String id);

    <T> List<T> getByIds(String index, String type,
                         Class<T> clazz,
                         List<String> ids);

    int updateScriptById(String index, String type, String id, Script script);


    int delete(String index, String type, String id);

//    /**
//     *
//     * @param index 索引名称
//     * @param type 索引类型
//     * @param clazz
//     * @param queryBuilder
//     * @param collapseBuilder 折叠查询，去重
//     * @param from
//     * @param size
//     * @param sortBuilders
//     * @param <T>
//     * @return
//     */
//    <T> PageResult<T> search(String index, String type,
//                             Class<T> clazz,
//                             QueryBuilder queryBuilder,
//                             CollapseBuilder collapseBuilder,
//                             int from, int size, List<SortBuilder> sortBuilders);
//
//    <T> PageResult<T> search(String index, String type,
//                             Class<T> clazz,
//                             QueryBuilder queryBuilder,
//                             CollapseBuilder collapseBuilder,
//                             int from, int size, List<String> includeFields, List<String> excludeFields,
//                             List<String> highlightFields,
//                             List<SortBuilder> sortBuilders);
//
//    <T> PageResult<T> search(List<String> index, List<String> type,
//                             Class<T> clazz,
//                             QueryBuilder queryBuilder,
//                             CollapseBuilder collapseBuilder,
//                             int from, int size, List<String> includeFields, List<String> excludeFields,
//                             List<String> highlightFields,
//                             List<SortBuilder> sortBuilders);

//    /**
//     * 折叠查询
//     * @param index
//     * @param type
//     * @param clazz
//     * @param queryBuilder
//     * @param collapseBuilder
//     * @param from
//     * @param size
//     * @param includeFields
//     * @param excludeFields
//     * @param sortBuilders
//     * @param <T>
//     * @return
//     */
//    <T> List<CollapseResult<T>> collapseSearch(List<String> index, List<String> type, Class<T> clazz, QueryBuilder queryBuilder, CollapseBuilder collapseBuilder, List<String> includeFields, List<String> excludeFields,int from, int size, List<SortBuilder<?>> sortBuilders);

    long deleteByQuery(String index, String type, QueryBuilder queryBuilder);

    long updateScriptByQuery(String index, String type,
                             QueryBuilder queryBuilder,
                             Script script);



    /**
     * 自动补全查询服务
     * @param indexName
     * @param queryBuilder
     * @param fields
     * @param value
     * @param count
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> suggest(String indexName,QueryBuilder queryBuilder, String[] fields, String value, int count, Class<T> clazz);

    <T> void asyncBulkAdd(String index, String type, List<T> entityList);
    <T> void asyncBulkAdd(String index, String type, List<T> entityList,String pipline);

    <T extends IdEntity> void asyncBulkUpdate(String index, String type, List<T> entityList);

//    void asyncBulkUpdateScript(String index, String type, List<ScriptObject> scriptList);

    void asyncBulkDelete(String index, String type, List<String> idList);

    <T> void syncBulkAdd(String index, String type, List<T> entityList);
    <T> void syncBulkAdd(String index, String type, List<T> entityList,String pipline);

    void syncBulkDelete(String index, String type, List<String> idList);

    <T extends IdEntity> void syncBulkUpdate(String index, String type, List<T> entityList);

//    void syncBulkUpdateScript(String index, String type, List<ScriptObject> scriptObjects);

    MainResponse info();

    long count(String index, QueryBuilder queryBuilder);


}

