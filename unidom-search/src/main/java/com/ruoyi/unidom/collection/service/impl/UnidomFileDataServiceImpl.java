package com.ruoyi.unidom.collection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.collection.mapper.UnidomFileDataMapper;
import com.ruoyi.unidom.collection.domain.UnidomFileData;
import com.ruoyi.unidom.collection.service.IUnidomFileDataService;

/**
 * 实体-物-文件Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-04-17
 */
@Service
public class UnidomFileDataServiceImpl implements IUnidomFileDataService 
{
    @Autowired
    private UnidomFileDataMapper unidomFileDataMapper;

    /**
     * 查询实体-物-文件
     * 
     * @param id 实体-物-文件主键
     * @return 实体-物-文件
     */
    @Override
    public UnidomFileData selectUnidomFileDataById(String id)
    {
        return unidomFileDataMapper.selectUnidomFileDataById(id);
    }

    /**
     * 查询实体-物-文件列表
     * 
     * @param unidomFileData 实体-物-文件
     * @return 实体-物-文件
     */
    @Override
    public List<UnidomFileData> selectUnidomFileDataList(UnidomFileData unidomFileData)
    {
        return unidomFileDataMapper.selectUnidomFileDataList(unidomFileData);
    }

    /**
     * 新增实体-物-文件
     * 
     * @param unidomFileData 实体-物-文件
     * @return 结果
     */
    @Override
    public int insertUnidomFileData(UnidomFileData unidomFileData)
    {
        unidomFileData.setCreateTime(DateUtils.getNowDate());
        return unidomFileDataMapper.insertUnidomFileData(unidomFileData);
    }

    /**
     * 修改实体-物-文件
     * 
     * @param unidomFileData 实体-物-文件
     * @return 结果
     */
    @Override
    public int updateUnidomFileData(UnidomFileData unidomFileData)
    {
        unidomFileData.setUpdateTime(DateUtils.getNowDate());
        return unidomFileDataMapper.updateUnidomFileData(unidomFileData);
    }

    /**
     * 批量删除实体-物-文件
     * 
     * @param ids 需要删除的实体-物-文件主键
     * @return 结果
     */
    @Override
    public int deleteUnidomFileDataByIds(String[] ids)
    {
        return unidomFileDataMapper.deleteUnidomFileDataByIds(ids);
    }

    /**
     * 删除实体-物-文件信息
     * 
     * @param id 实体-物-文件主键
     * @return 结果
     */
    @Override
    public int deleteUnidomFileDataById(String id)
    {
        return unidomFileDataMapper.deleteUnidomFileDataById(id);
    }
}
