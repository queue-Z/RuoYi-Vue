package com.ruoyi.unidom.collection.mapper;

import java.util.List;
import com.ruoyi.unidom.collection.domain.UnidomPeopleData;

/**
 * 实体-人Mapper接口
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
public interface UnidomPeopleDataMapper 
{
    /**
     * 查询实体-人
     * 
     * @param id 实体-人主键
     * @return 实体-人
     */
    public UnidomPeopleData selectUnidomPeopleDataById(String id);

    /**
     * 查询实体-人列表
     * 
     * @param unidomPeopleData 实体-人
     * @return 实体-人集合
     */
    public List<UnidomPeopleData> selectUnidomPeopleDataList(UnidomPeopleData unidomPeopleData);

    /**
     * 新增实体-人
     * 
     * @param unidomPeopleData 实体-人
     * @return 结果
     */
    public int insertUnidomPeopleData(UnidomPeopleData unidomPeopleData);

    /**
     * 修改实体-人
     * 
     * @param unidomPeopleData 实体-人
     * @return 结果
     */
    public int updateUnidomPeopleData(UnidomPeopleData unidomPeopleData);

    /**
     * 删除实体-人
     * 
     * @param id 实体-人主键
     * @return 结果
     */
    public int deleteUnidomPeopleDataById(String id);

    /**
     * 批量删除实体-人
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUnidomPeopleDataByIds(String[] ids);
}
