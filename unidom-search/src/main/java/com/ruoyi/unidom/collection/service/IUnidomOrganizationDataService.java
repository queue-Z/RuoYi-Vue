package com.ruoyi.unidom.collection.service;

import java.util.List;
import com.ruoyi.unidom.collection.domain.UnidomOrganizationData;

/**
 * 实体-组织Service接口
 * 
 * @author quezhuhu
 * @date 2023-04-24
 */
public interface IUnidomOrganizationDataService 
{
    /**
     * 查询实体-组织
     * 
     * @param id 实体-组织主键
     * @return 实体-组织
     */
    public UnidomOrganizationData selectUnidomOrganizationDataById(String id);

    /**
     * 查询实体-组织列表
     * 
     * @param unidomOrganizationData 实体-组织
     * @return 实体-组织集合
     */
    public List<UnidomOrganizationData> selectUnidomOrganizationDataList(UnidomOrganizationData unidomOrganizationData);

    /**
     * 新增实体-组织
     * 
     * @param unidomOrganizationData 实体-组织
     * @return 结果
     */
    public int insertUnidomOrganizationData(UnidomOrganizationData unidomOrganizationData);

    /**
     * 修改实体-组织
     * 
     * @param unidomOrganizationData 实体-组织
     * @return 结果
     */
    public int updateUnidomOrganizationData(UnidomOrganizationData unidomOrganizationData);

    /**
     * 批量删除实体-组织
     * 
     * @param ids 需要删除的实体-组织主键集合
     * @return 结果
     */
    public int deleteUnidomOrganizationDataByIds(String[] ids);

    /**
     * 删除实体-组织信息
     * 
     * @param id 实体-组织主键
     * @return 结果
     */
    public int deleteUnidomOrganizationDataById(String id);
}
