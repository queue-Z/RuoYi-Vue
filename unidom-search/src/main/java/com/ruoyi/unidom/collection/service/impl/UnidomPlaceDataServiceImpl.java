package com.ruoyi.unidom.collection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.collection.mapper.UnidomPlaceDataMapper;
import com.ruoyi.unidom.collection.domain.UnidomPlaceData;
import com.ruoyi.unidom.collection.service.IUnidomPlaceDataService;

/**
 * 实体-地Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
@Service
public class UnidomPlaceDataServiceImpl implements IUnidomPlaceDataService 
{
    @Autowired
    private UnidomPlaceDataMapper unidomPlaceDataMapper;

    /**
     * 查询实体-地
     * 
     * @param id 实体-地主键
     * @return 实体-地
     */
    @Override
    public UnidomPlaceData selectUnidomPlaceDataById(String id)
    {
        return unidomPlaceDataMapper.selectUnidomPlaceDataById(id);
    }

    /**
     * 查询实体-地列表
     * 
     * @param unidomPlaceData 实体-地
     * @return 实体-地
     */
    @Override
    public List<UnidomPlaceData> selectUnidomPlaceDataList(UnidomPlaceData unidomPlaceData)
    {
        return unidomPlaceDataMapper.selectUnidomPlaceDataList(unidomPlaceData);
    }

    /**
     * 新增实体-地
     * 
     * @param unidomPlaceData 实体-地
     * @return 结果
     */
    @Override
    public int insertUnidomPlaceData(UnidomPlaceData unidomPlaceData)
    {
        unidomPlaceData.setCreateTime(DateUtils.getNowDate());
        return unidomPlaceDataMapper.insertUnidomPlaceData(unidomPlaceData);
    }

    /**
     * 修改实体-地
     * 
     * @param unidomPlaceData 实体-地
     * @return 结果
     */
    @Override
    public int updateUnidomPlaceData(UnidomPlaceData unidomPlaceData)
    {
        unidomPlaceData.setUpdateTime(DateUtils.getNowDate());
        return unidomPlaceDataMapper.updateUnidomPlaceData(unidomPlaceData);
    }

    /**
     * 批量删除实体-地
     * 
     * @param ids 需要删除的实体-地主键
     * @return 结果
     */
    @Override
    public int deleteUnidomPlaceDataByIds(String[] ids)
    {
        return unidomPlaceDataMapper.deleteUnidomPlaceDataByIds(ids);
    }

    /**
     * 删除实体-地信息
     * 
     * @param id 实体-地主键
     * @return 结果
     */
    @Override
    public int deleteUnidomPlaceDataById(String id)
    {
        return unidomPlaceDataMapper.deleteUnidomPlaceDataById(id);
    }
}
