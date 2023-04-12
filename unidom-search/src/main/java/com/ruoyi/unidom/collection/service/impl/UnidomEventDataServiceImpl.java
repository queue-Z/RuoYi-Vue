package com.ruoyi.unidom.collection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.collection.mapper.UnidomEventDataMapper;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.collection.service.IUnidomEventDataService;

/**
 * 实体-事Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-04-11
 */
@Service
public class UnidomEventDataServiceImpl implements IUnidomEventDataService 
{
    @Autowired
    private UnidomEventDataMapper unidomEventDataMapper;

    /**
     * 查询实体-事
     * 
     * @param id 实体-事主键
     * @return 实体-事
     */
    @Override
    public UnidomEventData selectUnidomEventDataById(String id)
    {
        return unidomEventDataMapper.selectUnidomEventDataById(id);
    }

    /**
     * 查询实体-事列表
     * 
     * @param unidomEventData 实体-事
     * @return 实体-事
     */
    @Override
    public List<UnidomEventData> selectUnidomEventDataList(UnidomEventData unidomEventData)
    {
        return unidomEventDataMapper.selectUnidomEventDataList(unidomEventData);
    }

    /**
     * 新增实体-事
     * 
     * @param unidomEventData 实体-事
     * @return 结果
     */
    @Override
    public int insertUnidomEventData(UnidomEventData unidomEventData)
    {
        unidomEventData.setCreateTime(DateUtils.getNowDate());
        return unidomEventDataMapper.insertUnidomEventData(unidomEventData);
    }

    /**
     * 修改实体-事
     * 
     * @param unidomEventData 实体-事
     * @return 结果
     */
    @Override
    public int updateUnidomEventData(UnidomEventData unidomEventData)
    {
        unidomEventData.setUpdateTime(DateUtils.getNowDate());
        return unidomEventDataMapper.updateUnidomEventData(unidomEventData);
    }

    /**
     * 批量删除实体-事
     * 
     * @param ids 需要删除的实体-事主键
     * @return 结果
     */
    @Override
    public int deleteUnidomEventDataByIds(String[] ids)
    {
        return unidomEventDataMapper.deleteUnidomEventDataByIds(ids);
    }

    /**
     * 删除实体-事信息
     * 
     * @param id 实体-事主键
     * @return 结果
     */
    @Override
    public int deleteUnidomEventDataById(String id)
    {
        return unidomEventDataMapper.deleteUnidomEventDataById(id);
    }
}
