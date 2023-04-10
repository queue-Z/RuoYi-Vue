package com.ruoyi.unidom.indices.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 模块定义对象 t_uds_module_def
 * 
 * @author quezhuhu
 * @date 2023-03-13
 */
public class TUdsModuleDef extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 唯一模块编码（warehouse、metadata、indicator、filelib、report、picture、video、prewarn、event、subject） */
    @Excel(name = "唯一模块编码", readConverterExp = "w=arehouse、metadata、indicator、filelib、report、picture、video、prewarn、event、subject")
    private String moduleCode;

    /** 模块名称（原始数据、元数据、指标、文库、报告、图片、视频、预警、事件、主题） */
    @Excel(name = "模块名称", readConverterExp = "原=始数据、元数据、指标、文库、报告、图片、视频、预警、事件、主题")
    private String moduleName;

    /** 展现样式(webpage/table/picture/video/file) */
    @Excel(name = "展现样式(webpage/table/picture/video/file)")
    private String moduleStyle;

    /** 模块索引名称 */
    @Excel(name = "模块索引名称")
    private String moduleIndiceName;

    /** 模块索引别名 */
    @Excel(name = "模块索引别名")
    private String moduleIndiceAlias;

    /** 索引全局别名 */
    @Excel(name = "索引全局别名")
    private String globalIndiceAlias;

    /** 模块详情展示类型（1：自建详情页，2：跳转到外围系统） */
    @Excel(name = "模块详情展示类型", readConverterExp = "1=：自建详情页，2：跳转到外围系统")
    private Long dtlPageDisplay;

    /** 索引模块界面展示标识 1：展示 0：不展示 */
    @Excel(name = "索引模块界面展示标识 1：展示 0：不展示")
    private Long displayFlag;

    /** 索引模块界面排序 */
    @Excel(name = "索引模块界面排序")
    private Long displaySort;

    /** 模块列表前端组件标识 */
    @Excel(name = "模块列表前端组件标识")
    private String frontListTplId;

    /** 模块详情前端组件标识 */
    @Excel(name = "模块详情前端组件标识")
    private String frontDtlTplId;

    /** 地图搜索标识  0：否  1：是 */
    @Excel(name = "地图搜索标识  0：否  1：是")
    private Long mapFlag;

    /** 文件路径字段标识 0:无；1:有 */
    @Excel(name = "文件路径字段标识 0:无；1:有")
    private Long needDbFileField;

    /** ES文件内容分词标识  0:否 1：是 */
    @Excel(name = "ES文件内容分词标识  0:否 1：是")
    private Long esFiledataAnalysisFlag;

    /** 状态标识 1:启用 0：禁用 */
    @Excel(name = "状态标识 1:启用 0：禁用")
    private Long moduleStatus;

    /** 预置标识 1:是 0：否  */
    @Excel(name = "预置标识 1:是 0：否 ")
    private Long presetFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setModuleCode(String moduleCode) 
    {
        this.moduleCode = moduleCode;
    }

    public String getModuleCode() 
    {
        return moduleCode;
    }
    public void setModuleName(String moduleName) 
    {
        this.moduleName = moduleName;
    }

    public String getModuleName() 
    {
        return moduleName;
    }
    public void setModuleStyle(String moduleStyle) 
    {
        this.moduleStyle = moduleStyle;
    }

    public String getModuleStyle() 
    {
        return moduleStyle;
    }
    public void setModuleIndiceName(String moduleIndiceName) 
    {
        this.moduleIndiceName = moduleIndiceName;
    }

    public String getModuleIndiceName() 
    {
        return moduleIndiceName;
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
    public void setDtlPageDisplay(Long dtlPageDisplay) 
    {
        this.dtlPageDisplay = dtlPageDisplay;
    }

    public Long getDtlPageDisplay() 
    {
        return dtlPageDisplay;
    }
    public void setDisplayFlag(Long displayFlag) 
    {
        this.displayFlag = displayFlag;
    }

    public Long getDisplayFlag() 
    {
        return displayFlag;
    }
    public void setDisplaySort(Long displaySort) 
    {
        this.displaySort = displaySort;
    }

    public Long getDisplaySort() 
    {
        return displaySort;
    }
    public void setFrontListTplId(String frontListTplId) 
    {
        this.frontListTplId = frontListTplId;
    }

    public String getFrontListTplId() 
    {
        return frontListTplId;
    }
    public void setFrontDtlTplId(String frontDtlTplId) 
    {
        this.frontDtlTplId = frontDtlTplId;
    }

    public String getFrontDtlTplId() 
    {
        return frontDtlTplId;
    }
    public void setMapFlag(Long mapFlag) 
    {
        this.mapFlag = mapFlag;
    }

    public Long getMapFlag() 
    {
        return mapFlag;
    }
    public void setNeedDbFileField(Long needDbFileField) 
    {
        this.needDbFileField = needDbFileField;
    }

    public Long getNeedDbFileField() 
    {
        return needDbFileField;
    }
    public void setEsFiledataAnalysisFlag(Long esFiledataAnalysisFlag) 
    {
        this.esFiledataAnalysisFlag = esFiledataAnalysisFlag;
    }

    public Long getEsFiledataAnalysisFlag() 
    {
        return esFiledataAnalysisFlag;
    }
    public void setModuleStatus(Long moduleStatus) 
    {
        this.moduleStatus = moduleStatus;
    }

    public Long getModuleStatus() 
    {
        return moduleStatus;
    }
    public void setPresetFlag(Long presetFlag) 
    {
        this.presetFlag = presetFlag;
    }

    public Long getPresetFlag() 
    {
        return presetFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moduleCode", getModuleCode())
            .append("moduleName", getModuleName())
            .append("moduleStyle", getModuleStyle())
            .append("moduleIndiceName", getModuleIndiceName())
            .append("moduleIndiceAlias", getModuleIndiceAlias())
            .append("globalIndiceAlias", getGlobalIndiceAlias())
            .append("dtlPageDisplay", getDtlPageDisplay())
            .append("displayFlag", getDisplayFlag())
            .append("displaySort", getDisplaySort())
            .append("frontListTplId", getFrontListTplId())
            .append("frontDtlTplId", getFrontDtlTplId())
            .append("remark", getRemark())
            .append("mapFlag", getMapFlag())
            .append("needDbFileField", getNeedDbFileField())
            .append("esFiledataAnalysisFlag", getEsFiledataAnalysisFlag())
            .append("moduleStatus", getModuleStatus())
            .append("presetFlag", getPresetFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
