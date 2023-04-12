package com.ruoyi.unidom.collection.mapper;

import java.util.List;
import com.ruoyi.unidom.collection.domain.UnidomEventData;

/**
 * 实体-事Mapper接口
 * 
 * @author quezhuhu
 * @date 2023-04-11
 */
public interface UnidomEventDataMapper 
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
     * 删除实体-事
     * 
     * @param id 实体-事主键
     * @return 结果
     */
    public int deleteUnidomEventDataById(String id);

    /**
     * 批量删除实体-事
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUnidomEventDataByIds(String[] ids);
}
