package com.ruoyi.unidom.indices.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 索引配置对象 t_uds_indice_conf
 * 
 * @author quezhuhu
 * @date 2023-03-14
 */
public class TUdsIndiceConf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 模块id */
    @Excel(name = "模块id")
    private Long moduleId;

    /** 索引名称 */
    @Excel(name = "索引名称")
    private String indiceName;

    /** 模块索引别名 */
    @Excel(name = "模块索引别名")
    private String moduleIndiceAlias;

    /** 索引全局别名 */
    @Excel(name = "索引全局别名")
    private String globalIndiceAlias;

    /** 索引settings */
    @Excel(name = "索引settings")
    private String indiceSettings;

    /** 索引mappings */
    @Excel(name = "索引mappings")
    private String indiceMappings;

    /** 自定义配置信息 */
    @Excel(name = "自定义配置信息")
    private String confInfo;

    /** 索引状态 */
    @Excel(name = "索引状态")
    private Long indiceStatus;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long isDelete;

    private TUdsModuleDef moduleDef;
    public TUdsModuleDef getModuleDef() {
        return moduleDef;
    }
    public void setModuleDef(TUdsModuleDef moduleDef) {
        this.moduleDef = moduleDef;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setModuleId(Long moduleId) 
    {
        this.moduleId = moduleId;
    }

    public Long getModuleId() 
    {
        return moduleId;
    }
    public void setIndiceName(String indiceName) 
    {
        this.indiceName = indiceName;
    }

    public String getIndiceName() 
    {
        return indiceName;
    }
    public void setModuleIndiceAlias(String moduleIndiceAlias) 
    {
        this.moduleIndiceAlias = moduleIndiceAlias;
    }

    public String getModuleIndiceAlias() 
    {
        return moduleIndiceAlias;
    }
    public void setGlobalIndiceAlias(String globalIndiceAlias) 
    {
        this.globalIndiceAlias = globalIndiceAlias;
    }

    public String getGlobalIndiceAlias() 
    {
        return globalIndiceAlias;
    }
    public void setIndiceSettings(String indiceSettings) 
    {
        this.indiceSettings = indiceSettings;
    }

    public String getIndiceSettings() 
    {
        return indiceSettings;
    }
    public void setIndiceMappings(String indiceMappings) 
    {
        this.indiceMappings = indiceMappings;
    }

    public String getIndiceMappings() 
    {
        return indiceMappings;
    }
    public void setConfInfo(String confInfo) 
    {
        this.confInfo = confInfo;
    }

    public String getConfInfo() 
    {
        return confInfo;
    }
    public void setIndiceStatus(Long indiceStatus) 
    {
        this.indiceStatus = indiceStatus;
    }

    public Long getIndiceStatus() 
    {
        return indiceStatus;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("moduleId", getModuleId())
            .append("indiceName", getIndiceName())
            .append("moduleIndiceAlias", getModuleIndiceAlias())
            .append("globalIndiceAlias", getGlobalIndiceAlias())
            .append("indiceSettings", getIndiceSettings())
            .append("indiceMappings", getIndiceMappings())
            .append("confInfo", getConfInfo())
            .append("indiceStatus", getIndiceStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("isDelete", getIsDelete())
            .append("moduleDef", getModuleDef())
            .toString();
    }
}
