package com.ruoyi.unidom.collection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.unidom.model.IdEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实体-人对象 unidom_people_data
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
public class UnidomPeopleData extends BaseEntity implements IdEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模块编码，默认为m_file */
    @Excel(name = "模块编码，默认为m_file")
    private String moduleCode;

    /** 标题 */
    @Excel(name = "标题")
    private String dataTitle;

    /** 简介 */
    @Excel(name = "简介")
    private String dataDesc;

    /** 标签关键词，多个以英文逗号分隔 */
    @Excel(name = "标签关键词，多个以英文逗号分隔")
    private String labelKeywords;

    /** es更新时间，默认通update_time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "es更新时间，默认通update_time")
    private Date esUpdateTime;

    /** 姓名 */
    @Excel(name = "姓名")
    private String perName;

    /** 性别 */
    @Excel(name = "性别")
    private String perGender;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日")
    private Date perBirthDate;

    /** 身份唯一标识 */
    @Excel(name = "身份唯一标识")
    private String perId;

    /** 国籍 */
    @Excel(name = "国籍")
    private String perNationality;

    /** 民族 */
    @Excel(name = "民族")
    private String perEthnicity;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String perNativePlace;

    /** 出生地 */
    @Excel(name = "出生地")
    private String perBirthPlace;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String perContactInfo;

    /** 学历 */
    @Excel(name = "学历")
    private String perEducation;

    /** 职业 */
    @Excel(name = "职业")
    private String perOccupation;

    /** 工作地 */
    @Excel(name = "工作地")
    private String perWorkPlace;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String perHomeAddress;

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
    public void setPerName(String perName) 
    {
        this.perName = perName;
    }

    public String getPerName() 
    {
        return perName;
    }
    public void setPerGender(String perGender) 
    {
        this.perGender = perGender;
    }

    public String getPerGender() 
    {
        return perGender;
    }
    public void setPerBirthDate(Date perBirthDate) 
    {
        this.perBirthDate = perBirthDate;
    }

    public Date getPerBirthDate() 
    {
        return perBirthDate;
    }
    public void setPerId(String perId) 
    {
        this.perId = perId;
    }

    public String getPerId() 
    {
        return perId;
    }
    public void setPerNationality(String perNationality) 
    {
        this.perNationality = perNationality;
    }

    public String getPerNationality() 
    {
        return perNationality;
    }
    public void setPerEthnicity(String perEthnicity) 
    {
        this.perEthnicity = perEthnicity;
    }

    public String getPerEthnicity() 
    {
        return perEthnicity;
    }
    public void setPerNativePlace(String perNativePlace) 
    {
        this.perNativePlace = perNativePlace;
    }

    public String getPerNativePlace() 
    {
        return perNativePlace;
    }
    public void setPerBirthPlace(String perBirthPlace) 
    {
        this.perBirthPlace = perBirthPlace;
    }

    public String getPerBirthPlace() 
    {
        return perBirthPlace;
    }
    public void setPerContactInfo(String perContactInfo) 
    {
        this.perContactInfo = perContactInfo;
    }

    public String getPerContactInfo() 
    {
        return perContactInfo;
    }
    public void setPerEducation(String perEducation) 
    {
        this.perEducation = perEducation;
    }

    public String getPerEducation() 
    {
        return perEducation;
    }
    public void setPerOccupation(String perOccupation) 
    {
        this.perOccupation = perOccupation;
    }

    public String getPerOccupation() 
    {
        return perOccupation;
    }
    public void setPerWorkPlace(String perWorkPlace) 
    {
        this.perWorkPlace = perWorkPlace;
    }

    public String getPerWorkPlace() 
    {
        return perWorkPlace;
    }
    public void setPerHomeAddress(String perHomeAddress) 
    {
        this.perHomeAddress = perHomeAddress;
    }

    public String getPerHomeAddress() 
    {
        return perHomeAddress;
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
            .append("perName", getPerName())
            .append("perGender", getPerGender())
            .append("perBirthDate", getPerBirthDate())
            .append("perId", getPerId())
            .append("perNationality", getPerNationality())
            .append("perEthnicity", getPerEthnicity())
            .append("perNativePlace", getPerNativePlace())
            .append("perBirthPlace", getPerBirthPlace())
            .append("perContactInfo", getPerContactInfo())
            .append("perEducation", getPerEducation())
            .append("perOccupation", getPerOccupation())
            .append("perWorkPlace", getPerWorkPlace())
            .append("perHomeAddress", getPerHomeAddress())
            .toString();
    }
}
