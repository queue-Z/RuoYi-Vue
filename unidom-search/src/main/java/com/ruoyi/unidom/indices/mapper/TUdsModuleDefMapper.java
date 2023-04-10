package com.ruoyi.unidom.indices.mapper;

import java.util.List;
import com.ruoyi.unidom.indices.domain.TUdsModuleDef;

/**
 * 模块定义Mapper接口
 * 
 * @author quezhuhu
 * @date 2023-03-13
 */
public interface TUdsModuleDefMapper 
{
    /**
     * 查询模块定义
     * 
     * @param id 模块定义主键
     * @return 模块定义
     */
    public TUdsModuleDef selectTUdsModuleDefById(Long id);

    /**
     * 查询模块定义列表
     * 
     * @param tUdsModuleDef 模块定义
     * @return 模块定义集合
     */
    public List<TUdsModuleDef> selectTUdsModuleDefList(TUdsModuleDef tUdsModuleDef);

    /**
     * 新增模块定义
     * 
     * @param tUdsModuleDef 模块定义
     * @return 结果
     */
    public int insertTUdsModuleDef(TUdsModuleDef tUdsModuleDef);

    /**
     * 修改模块定义
     * 
     * @param tUdsModuleDef 模块定义
     * @return 结果
     */
    public int updateTUdsModuleDef(TUdsModuleDef tUdsModuleDef);

    /**
     * 删除模块定义
     * 
     * @param id 模块定义主键
     * @return 结果
     */
    public int deleteTUdsModuleDefById(Long id);

    /**
     * 批量删除模块定义
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTUdsModuleDefByIds(Long[] ids);
}
