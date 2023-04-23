package com.ruoyi.unidom.collection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.collection.mapper.UnidomPeopleDataMapper;
import com.ruoyi.unidom.collection.domain.UnidomPeopleData;
import com.ruoyi.unidom.collection.service.IUnidomPeopleDataService;

/**
 * 实体-人Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
@Service
public class UnidomPeopleDataServiceImpl implements IUnidomPeopleDataService 
{
    @Autowired
    private UnidomPeopleDataMapper unidomPeopleDataMapper;

    /**
     * 查询实体-人
     * 
     * @param id 实体-人主键
     * @return 实体-人
     */
    @Override
    public UnidomPeopleData selectUnidomPeopleDataById(String id)
    {
        return unidomPeopleDataMapper.selectUnidomPeopleDataById(id);
    }

    /**
     * 查询实体-人列表
     * 
     * @param unidomPeopleData 实体-人
     * @return 实体-人
     */
    @Override
    public List<UnidomPeopleData> selectUnidomPeopleDataList(UnidomPeopleData unidomPeopleData)
    {
        return unidomPeopleDataMapper.selectUnidomPeopleDataList(unidomPeopleData);
    }

    /**
     * 新增实体-人
     * 
     * @param unidomPeopleData 实体-人
     * @return 结果
     */
    @Override
    public int insertUnidomPeopleData(UnidomPeopleData unidomPeopleData)
    {
        unidomPeopleData.setCreateTime(DateUtils.getNowDate());
        return unidomPeopleDataMapper.insertUnidomPeopleData(unidomPeopleData);
    }

    /**
     * 修改实体-人
     * 
     * @param unidomPeopleData 实体-人
     * @return 结果
     */
    @Override
    public int updateUnidomPeopleData(UnidomPeopleData unidomPeopleData)
    {
        unidomPeopleData.setUpdateTime(DateUtils.getNowDate());
        return unidomPeopleDataMapper.updateUnidomPeopleData(unidomPeopleData);
    }

    /**
     * 批量删除实体-人
     * 
     * @param ids 需要删除的实体-人主键
     * @return 结果
     */
    @Override
    public int deleteUnidomPeopleDataByIds(String[] ids)
    {
        return unidomPeopleDataMapper.deleteUnidomPeopleDataByIds(ids);
    }

    /**
     * 删除实体-人信息
     * 
     * @param id 实体-人主键
     * @return 结果
     */
    @Override
    public int deleteUnidomPeopleDataById(String id)
    {
        return unidomPeopleDataMapper.deleteUnidomPeopleDataById(id);
    }
}
