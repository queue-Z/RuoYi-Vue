package com.ruoyi.unidom.indices.service.impl;

import java.util.List;

import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import com.ruoyi.unidom.indices.mapper.TUdsModuleDefMapper;
import com.ruoyi.unidom.indices.service.ITUdsModuleDefService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模块定义Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-03-13
 */
@Service
public class TUdsModuleDefServiceImpl implements ITUdsModuleDefService
{
    @Autowired
    private TUdsModuleDefMapper tUdsModuleDefMapper;

    /**
     * 查询模块定义
     * 
     * @param id 模块定义主键
     * @return 模块定义
     */
    @Override
    public TUdsModuleDef selectTUdsModuleDefById(Long id)
    {
        return tUdsModuleDefMapper.selectTUdsModuleDefById(id);
    }

    @Override
    public TUdsModuleDef selectTUdsModuleDefByCode(String code)
    {
        return tUdsModuleDefMapper.selectTUdsModuleDefByCode(code);
    }
    /**
     * 查询模块定义列表
     * 
     * @param tUdsModuleDef 模块定义
     * @return 模块定义
     */
    @Override
    public List<TUdsModuleDef> selectTUdsModuleDefList(TUdsModuleDef tUdsModuleDef)
    {
        return tUdsModuleDefMapper.selectTUdsModuleDefList(tUdsModuleDef);
    }

    /**
     * 新增模块定义
     * 
     * @param tUdsModuleDef 模块定义
     * @return 结果
     */
    @Override
    public int insertTUdsModuleDef(TUdsModuleDef tUdsModuleDef)
    {
        tUdsModuleDef.setCreateTime(DateUtils.getNowDate());
        return tUdsModuleDefMapper.insertTUdsModuleDef(tUdsModuleDef);
    }

    /**
     * 修改模块定义
     * 
     * @param tUdsModuleDef 模块定义
     * @return 结果
     */
    @Override
    public int updateTUdsModuleDef(TUdsModuleDef tUdsModuleDef)
    {
        tUdsModuleDef.setUpdateTime(DateUtils.getNowDate());
        return tUdsModuleDefMapper.updateTUdsModuleDef(tUdsModuleDef);
    }

    /**
     * 批量删除模块定义
     * 
     * @param ids 需要删除的模块定义主键
     * @return 结果
     */
    @Override
    public int deleteTUdsModuleDefByIds(Long[] ids)
    {
        return tUdsModuleDefMapper.deleteTUdsModuleDefByIds(ids);
    }

    /**
     * 删除模块定义信息
     * 
     * @param id 模块定义主键
     * @return 结果
     */
    @Override
    public int deleteTUdsModuleDefById(Long id)
    {
        return tUdsModuleDefMapper.deleteTUdsModuleDefById(id);
    }
}

