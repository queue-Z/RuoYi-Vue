package com.ruoyi.unidom.collection.service;

import java.util.List;
import com.ruoyi.unidom.collection.domain.UnidomFileData;

/**
 * 实体-物-文件Service接口
 * 
 * @author quezhuhu
 * @date 2023-04-17
 */
public interface IUnidomFileDataService 
{
    /**
     * 查询实体-物-文件
     * 
     * @param id 实体-物-文件主键
     * @return 实体-物-文件
     */
    public UnidomFileData selectUnidomFileDataById(String id);

    /**
     * 查询实体-物-文件列表
     * 
     * @param unidomFileData 实体-物-文件
     * @return 实体-物-文件集合
     */
    public List<UnidomFileData> selectUnidomFileDataList(UnidomFileData unidomFileData);

    /**
     * 新增实体-物-文件
     * 
     * @param unidomFileData 实体-物-文件
     * @return 结果
     */
    public int insertUnidomFileData(UnidomFileData unidomFileData);

    /**
     * 修改实体-物-文件
     * 
     * @param unidomFileData 实体-物-文件
     * @return 结果
     */
    public int updateUnidomFileData(UnidomFileData unidomFileData);

    /**
     * 批量删除实体-物-文件
     * 
     * @param ids 需要删除的实体-物-文件主键集合
     * @return 结果
     */
    public int deleteUnidomFileDataByIds(String[] ids);

    /**
     * 删除实体-物-文件信息
     * 
     * @param id 实体-物-文件主键
     * @return 结果
     */
    public int deleteUnidomFileDataById(String id);
}
