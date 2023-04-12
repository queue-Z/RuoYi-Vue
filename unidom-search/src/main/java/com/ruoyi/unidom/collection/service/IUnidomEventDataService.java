package com.ruoyi.unidom.collection.service;

import java.util.List;
import com.ruoyi.unidom.collection.domain.UnidomEventData;

/**
 * 实体-事Service接口
 * 
 * @author quezhuhu
 * @date 2023-04-11
 */
public interface IUnidomEventDataService 
{
    /**
     * 查询实体-事
     * 
     * @param id 实体-事主键
     * @return 实体-事
     */
    public UnidomEventData selectUnidomEventDataById(String id);

    /**
     * 查询实体-事列表
     * 
     * @param unidomEventData 实体-事
     * @return 实体-事集合
     */
    public List<UnidomEventData> selectUnidomEventDataList(UnidomEventData unidomEventData);

    /**
     * 新增实体-事
     * 
     * @param unidomEventData 实体-事
     * @return 结果
     */
    public int insertUnidomEventData(UnidomEventData unidomEventData);

    /**
     * 修改实体-事
     * 
     * @param unidomEventData 实体-事
     * @return 结果
     */
    public int updateUnidomEventData(UnidomEventData unidomEventData);

    /**
     * 批量删除实体-事
     * 
     * @param ids 需要删除的实体-事主键集合
     * @return 结果
     */
    public int deleteUnidomEventDataByIds(String[] ids);

    /**
     * 删除实体-事信息
     * 
     * @param id 实体-事主键
     * @return 结果
     */
    public int deleteUnidomEventDataById(String id);
}
