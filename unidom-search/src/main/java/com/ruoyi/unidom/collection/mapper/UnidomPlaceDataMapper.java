package com.ruoyi.unidom.collection.mapper;

import java.util.List;
import com.ruoyi.unidom.collection.domain.UnidomPlaceData;

/**
 * 实体-地Mapper接口
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
public interface UnidomPlaceDataMapper 
{
    /**
     * 查询实体-地
     * 
     * @param id 实体-地主键
     * @return 实体-地
     */
    public UnidomPlaceData selectUnidomPlaceDataById(String id);

    /**
     * 查询实体-地列表
     * 
     * @param unidomPlaceData 实体-地
     * @return 实体-地集合
     */
    public List<UnidomPlaceData> selectUnidomPlaceDataList(UnidomPlaceData unidomPlaceData);

    /**
     * 新增实体-地
     * 
     * @param unidomPlaceData 实体-地
     * @return 结果
     */
    public int insertUnidomPlaceData(UnidomPlaceData unidomPlaceData);

    /**
     * 修改实体-地
     * 
     * @param unidomPlaceData 实体-地
     * @return 结果
     */
    public int updateUnidomPlaceData(UnidomPlaceData unidomPlaceData);

    /**
     * 删除实体-地
     * 
     * @param id 实体-地主键
     * @return 结果
     */
    public int deleteUnidomPlaceDataById(String id);

    /**
     * 批量删除实体-地
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUnidomPlaceDataByIds(String[] ids);
}
