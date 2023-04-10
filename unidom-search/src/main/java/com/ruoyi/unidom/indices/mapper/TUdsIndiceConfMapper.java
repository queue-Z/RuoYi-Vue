package com.ruoyi.unidom.indices.mapper;

import java.util.List;

import com.ruoyi.unidom.indices.domain.TUdsIndiceConf;

/**
 * 索引配置Mapper接口
 * 
 * @author quezhuhu
 * @date 2023-03-14
 */
public interface TUdsIndiceConfMapper 
{
    /**
     * 查询索引配置
     * 
     * @param id 索引配置主键
     * @return 索引配置
     */
    public TUdsIndiceConf selectTUdsIndiceConfById(Long id);

    /**
     * 查询索引配置列表
     * 
     * @param tUdsIndiceConf 索引配置
     * @return 索引配置集合
     */
    public List<TUdsIndiceConf> selectTUdsIndiceConfList(TUdsIndiceConf tUdsIndiceConf);

    /**
     * 新增索引配置
     * 
     * @param tUdsIndiceConf 索引配置
     * @return 结果
     */
    public int insertTUdsIndiceConf(TUdsIndiceConf tUdsIndiceConf);

    /**
     * 修改索引配置
     * 
     * @param tUdsIndiceConf 索引配置
     * @return 结果
     */
    public int updateTUdsIndiceConf(TUdsIndiceConf tUdsIndiceConf);

    /**
     * 删除索引配置
     * 
     * @param id 索引配置主键
     * @return 结果
     */
    public int deleteTUdsIndiceConfById(Long id);

    /**
     * 批量删除索引配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTUdsIndiceConfByIds(Long[] ids);
}
