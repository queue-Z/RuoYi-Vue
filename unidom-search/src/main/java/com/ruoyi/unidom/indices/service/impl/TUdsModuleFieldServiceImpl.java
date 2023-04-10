package com.ruoyi.unidom.indices.service.impl;

import java.util.List;

import com.ruoyi.unidom.indices.domain.TUdsModuleField;
import com.ruoyi.unidom.indices.mapper.TUdsModuleFieldMapper;
import com.ruoyi.unidom.indices.service.ITUdsModuleFieldService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模块字段Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-03-15
 */
@Service
public class TUdsModuleFieldServiceImpl implements ITUdsModuleFieldService
{
    @Autowired
    private TUdsModuleFieldMapper tUdsModuleFieldMapper;

    /**
     * 查询模块字段
     * 
     * @param id 模块字段主键
     * @return 模块字段
     */
    @Override
    public TUdsModuleField selectTUdsModuleFieldById(Long id)
    {
        return tUdsModuleFieldMapper.selectTUdsModuleFieldById(id);
    }

    /**
     * 查询模块字段列表
     * 
     * @param tUdsModuleField 模块字段
     * @return 模块字段
     */
    @Override
    public List<TUdsModuleField> selectTUdsModuleFieldList(TUdsModuleField tUdsModuleField)
    {
        return tUdsModuleFieldMapper.selectTUdsModuleFieldList(tUdsModuleField);
    }

    /**
     * 新增模块字段
     * 
     * @param tUdsModuleField 模块字段
     * @return 结果
     */
    @Override
    public int insertTUdsModuleField(TUdsModuleField tUdsModuleField)
    {
        tUdsModuleField.setCreateTime(DateUtils.getNowDate());
        return tUdsModuleFieldMapper.insertTUdsModuleField(tUdsModuleField);
    }

    /**
     * 修改模块字段
     * 
     * @param tUdsModuleField 模块字段
     * @return 结果
     */
    @Override
    public int updateTUdsModuleField(TUdsModuleField tUdsModuleField)
    {
        tUdsModuleField.setUpdateTime(DateUtils.getNowDate());
        return tUdsModuleFieldMapper.updateTUdsModuleField(tUdsModuleField);
    }

    /**
     * 批量删除模块字段
     * 
     * @param ids 需要删除的模块字段主键
     * @return 结果
     */
    @Override
    public int deleteTUdsModuleFieldByIds(Long[] ids)
    {
        return tUdsModuleFieldMapper.deleteTUdsModuleFieldByIds(ids);
    }

    /**
     * 删除模块字段信息
     * 
     * @param id 模块字段主键
     * @return 结果
     */
    @Override
    public int deleteTUdsModuleFieldById(Long id)
    {
        return tUdsModuleFieldMapper.deleteTUdsModuleFieldById(id);
    }
}
