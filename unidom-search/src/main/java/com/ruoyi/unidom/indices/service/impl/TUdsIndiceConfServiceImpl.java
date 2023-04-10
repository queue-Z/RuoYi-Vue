package com.ruoyi.unidom.indices.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.indices.mapper.TUdsIndiceConfMapper;
import com.ruoyi.unidom.indices.domain.TUdsIndiceConf;
import com.ruoyi.unidom.indices.service.ITUdsIndiceConfService;

/**
 * 索引配置Service业务层处理
 * 
 * @author quezhuhu
 * @date 2023-03-14
 */
@Service
public class TUdsIndiceConfServiceImpl implements ITUdsIndiceConfService
{
    @Autowired
    private TUdsIndiceConfMapper tUdsIndiceConfMapper;

    /**
     * 查询索引配置
     * 
     * @param id 索引配置主键
     * @return 索引配置
     */
    @Override
    public TUdsIndiceConf selectTUdsIndiceConfById(Long id)
    {
        return tUdsIndiceConfMapper.selectTUdsIndiceConfById(id);
    }

    /**
     * 查询索引配置列表
     * 
     * @param tUdsIndiceConf 索引配置
     * @return 索引配置
     */
    @Override
    public List<TUdsIndiceConf> selectTUdsIndiceConfList(TUdsIndiceConf tUdsIndiceConf)
    {
        return tUdsIndiceConfMapper.selectTUdsIndiceConfList(tUdsIndiceConf);
    }

    /**
     * 新增索引配置
     * 
     * @param tUdsIndiceConf 索引配置
     * @return 结果
     */
    @Override
    public int insertTUdsIndiceConf(TUdsIndiceConf tUdsIndiceConf)
    {
        tUdsIndiceConf.setCreateTime(DateUtils.getNowDate());
        return tUdsIndiceConfMapper.insertTUdsIndiceConf(tUdsIndiceConf);
    }

    /**
     * 修改索引配置
     * 
     * @param tUdsIndiceConf 索引配置
     * @return 结果
     */
    @Override
    public int updateTUdsIndiceConf(TUdsIndiceConf tUdsIndiceConf)
    {
        tUdsIndiceConf.setUpdateTime(DateUtils.getNowDate());
        return tUdsIndiceConfMapper.updateTUdsIndiceConf(tUdsIndiceConf);
    }

    /**
     * 批量删除索引配置
     * 
     * @param ids 需要删除的索引配置主键
     * @return 结果
     */
    @Override
    public int deleteTUdsIndiceConfByIds(Long[] ids)
    {
        return tUdsIndiceConfMapper.deleteTUdsIndiceConfByIds(ids);
    }

    /**
     * 删除索引配置信息
     * 
     * @param id 索引配置主键
     * @return 结果
     */
    @Override
    public int deleteTUdsIndiceConfById(Long id)
    {
        return tUdsIndiceConfMapper.deleteTUdsIndiceConfById(id);
    }
}
