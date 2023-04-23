package com.ruoyi.unidom.collection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.unidom.model.IdEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实体-地对象 unidom_place_data
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
public class UnidomPlaceData extends BaseEntity implements IdEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模块编码，默认为m_file */
    @Excel(name = "模块编码，默认为m_file")
    private String moduleCode;

    /** 文件标题 */
    @Excel(name = "文件标题")
    private String dataTitle;

    /** 文件简介 */
    @Excel(name = "文件简介")
    private String dataDesc;

    /** 标签关键词，多个以英文逗号分隔 */
    @Excel(name = "标签关键词，多个以英文逗号分隔")
    private String labelKeywords;

    /** es更新时间，默认通update_time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "es更新时间，默认通update_time")
    private Date esUpdateTime;

    /** 类型 */
    @Excel(name = "类型")
    private String plType;

    /** 名称 */
    @Excel(name = "名称")
    private String plName;

    /** 功能 */
    @Excel(name = "功能")
    private String plFunction;

    /** 位置 */
    @Excel(name = "位置")
    private String plLocation;

    /** 地址 */
    @Excel(name = "地址")
    private String plAddress;

    /** 面积 */
    @Excel(name = "面积")
    private String plArea;

    /** 地形 */
    @Excel(name = "地形")
    private String plTerrain;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setDataTitle(String dataTitle) 
    {
        this.dataTitle = dataTitle;
    }

    public String getDataTitle() 
    {
        return dataTitle;
    }
    public void setDataDesc(String dataDesc) 
    {
        this.dataDesc = dataDesc;
    }

    public String getDataDesc() 
    {
        return dataDesc;
    }
    public void setLabelKeywords(String labelKeywords) 
    {
        this.labelKeywords = labelKeywords;
    }

    public String getLabelKeywords() 
    {
        return labelKeywords;
    }
    public void setEsUpdateTime(Date esUpdateTime) 
    {
        this.esUpdateTime = esUpdateTime;
    }

    public Date getEsUpdateTime() 
    {
        return esUpdateTime;
    }
    public void setPlType(String plType) 
    {
        this.plType = plType;
    }

    public String getPlType() 
    {
        return plType;
    }
    public void setPlName(String plName) 
    {
        this.plName = plName;
    }

    public String getPlName() 
    {
        return plName;
    }
    public void setPlFunction(String plFunction) 
    {
        this.plFunction = plFunction;
    }

    public String getPlFunction() 
    {
        return plFunction;
    }
    public void setPlLocation(String plLocation) 
    {
        this.plLocation = plLocation;
    }

    public String getPlLocation() 
    {
        return plLocation;
    }
    public void setPlAddress(String plAddress) 
    {
        this.plAddress = plAddress;
    }

    public String getPlAddress() 
    {
        return plAddress;
    }
    public void setPlArea(String plArea) 
    {
        this.plArea = plArea;
    }

    public String getPlArea() 
    {
        return plArea;
    }
    public void setPlTerrain(String plTerrain) 
    {
        this.plTerrain = plTerrain;
    }

    public String getPlTerrain() 
    {
        return plTerrain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moduleCode", getModuleCode())
            .append("dataTitle", getDataTitle())
            .append("dataDesc", getDataDesc())
            .append("labelKeywords", getLabelKeywords())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("esUpdateTime", getEsUpdateTime())
            .append("plType", getPlType())
            .append("plName", getPlName())
            .append("plFunction", getPlFunction())
            .append("plLocation", getPlLocation())
            .append("plAddress", getPlAddress())
            .append("plArea", getPlArea())
            .append("plTerrain", getPlTerrain())
            .toString();
    }
}
