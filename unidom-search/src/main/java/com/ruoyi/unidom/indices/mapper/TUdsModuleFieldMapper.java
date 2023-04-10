package com.ruoyi.unidom.indices.mapper;

import java.util.List;

import com.ruoyi.unidom.indices.domain.TUdsModuleField;

/**
 * 模块字段Mapper接口
 * 
 * @author quezhuhu
 * @date 2023-03-15
 */
public interface TUdsModuleFieldMapper 
{
    /**
     * 查询模块字段
     * 
     * @param id 模块字段主键
     * @return 模块字段
     */
    public TUdsModuleField selectTUdsModuleFieldById(Long id);

    /**
     * 查询模块字段列表
     * 
     * @param tUdsModuleField 模块字段
     * @return 模块字段集合
     */
    public List<TUdsModuleField> selectTUdsModuleFieldList(TUdsModuleField tUdsModuleField);

    /**
     * 新增模块字段
     * 
     * @param tUdsModuleField 模块字段
     * @return 结果
     */
    public int insertTUdsModuleField(TUdsModuleField tUdsModuleField);

    /**
     * 修改模块字段
     * 
     * @param tUdsModuleField 模块字段
     * @return 结果
     */
    public int updateTUdsModuleField(TUdsModuleField tUdsModuleField);

    /**
     * 删除模块字段
     * 
     * @param id 模块字段主键
     * @return 结果
     */
    public int deleteTUdsModuleFieldById(Long id);

    /**
     * 批量删除模块字段
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTUdsModuleFieldByIds(Long[] ids);
}
