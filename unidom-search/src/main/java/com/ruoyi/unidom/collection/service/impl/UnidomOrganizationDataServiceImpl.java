package com.ruoyi.unidom.collection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.collection.mapper.UnidomOrganizationDataMapper;
import com.ruoyi.unidom.collection.domain.UnidomOrganizationData;
import com.ruoyi.unidom.collection.service.IUnidomOrganizationDataService;

/**
 * 实体-组织Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-04-24
 */
@Service
public class UnidomOrganizationDataServiceImpl implements IUnidomOrganizationDataService 
{
    @Autowired
    private UnidomOrganizationDataMapper unidomOrganizationDataMapper;

    /**
     * 查询实体-组织
     * 
     * @param id 实体-组织主键
     * @return 实体-组织
     */
    @Override
    public UnidomOrganizationData selectUnidomOrganizationDataById(String id)
    {
        return unidomOrganizationDataMapper.selectUnidomOrganizationDataById(id);
    }

    /**
     * 查询实体-组织列表
     * 
     * @param unidomOrganizationData 实体-组织
     * @return 实体-组织
     */
    @Override
    public List<UnidomOrganizationData> selectUnidomOrganizationDataList(UnidomOrganizationData unidomOrganizationData)
    {
        return unidomOrganizationDataMapper.selectUnidomOrganizationDataList(unidomOrganizationData);
    }

    /**
     * 新增实体-组织
     * 
     * @param unidomOrganizationData 实体-组织
     * @return 结果
     */
    @Override
    public int insertUnidomOrganizationData(UnidomOrganizationData unidomOrganizationData)
    {
        unidomOrganizationData.setCreateTime(DateUtils.getNowDate());
        return unidomOrganizationDataMapper.insertUnidomOrganizationData(unidomOrganizationData);
    }

    /**
     * 修改实体-组织
     * 
     * @param unidomOrganizationData 实体-组织
     * @return 结果
     */
    @Override
    public int updateUnidomOrganizationData(UnidomOrganizationData unidomOrganizationData)
    {
        unidomOrganizationData.setUpdateTime(DateUtils.getNowDate());
        return unidomOrganizationDataMapper.updateUnidomOrganizationData(unidomOrganizationData);
    }

    /**
     * 批量删除实体-组织
     * 
     * @param ids 需要删除的实体-组织主键
     * @return 结果
     */
    @Override
    public int deleteUnidomOrganizationDataByIds(String[] ids)
    {
        return unidomOrganizationDataMapper.deleteUnidomOrganizationDataByIds(ids);
    }

    /**
     * 删除实体-组织信息
     * 
     * @param id 实体-组织主键
     * @return 结果
     */
    @Override
    public int deleteUnidomOrganizationDataById(String id)
    {
        return unidomOrganizationDataMapper.deleteUnidomOrganizationDataById(id);
    }
}
