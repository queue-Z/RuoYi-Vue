package com.ruoyi.unidom.collection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.unidom.model.IdEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实体-组织对象 unidom_organization_data
 * 
 * @author quezhuhu
 * @date 2023-04-23
 */
public class UnidomOrganizationData extends BaseEntity implements IdEntity
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

    /** 
名称 */
    @Excel(name = "名称")
    private String orgName;

    /** 类型 */
    @Excel(name = "类型")
    private String orgType;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String orgBusinessScope;

    /** 状态 */
    @Excel(name = "状态")
    private String orgStatus;

    /** 人员数 */
    @Excel(name = "人员数")
    private Long orgStaffSize;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String orgContactInfo;

    /** 地址 */
    @Excel(name = "地址")
    private String orgAddress;

    /** 唯一标识 */
    @Excel(name = "唯一标识")
    private String orgId;

    /** 成立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期")
    private Date orgEstablishmentDate;

    private String orgUrl;

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
    public void setOrgName(String orgName) 
    {
        this.orgName = orgName;
    }

    public String getOrgName() 
    {
        return orgName;
    }
    public void setOrgType(String orgType) 
    {
        this.orgType = orgType;
    }

    public String getOrgType() 
    {
        return orgType;
    }
    public void setOrgBusinessScope(String orgBusinessScope) 
    {
        this.orgBusinessScope = orgBusinessScope;
    }

    public String getOrgBusinessScope() 
    {
        return orgBusinessScope;
    }
    public void setOrgStatus(String orgStatus) 
    {
        this.orgStatus = orgStatus;
    }

    public String getOrgStatus() 
    {
        return orgStatus;
    }
    public void setOrgStaffSize(Long orgStaffSize) 
    {
        this.orgStaffSize = orgStaffSize;
    }

    public Long getOrgStaffSize() 
    {
        return orgStaffSize;
    }
    public void setOrgContactInfo(String orgContactInfo) 
    {
        this.orgContactInfo = orgContactInfo;
    }

    public String getOrgContactInfo() 
    {
        return orgContactInfo;
    }
    public void setOrgAddress(String orgAddress) 
    {
        this.orgAddress = orgAddress;
    }

    public String getOrgAddress() 
    {
        return orgAddress;
    }
    public void setOrgId(String orgId) 
    {
        this.orgId = orgId;
    }

    public String getOrgId() 
    {
        return orgId;
    }
    public void setOrgEstablishmentDate(Date orgEstablishmentDate) 
    {
        this.orgEstablishmentDate = orgEstablishmentDate;
    }

    public Date getOrgEstablishmentDate() 
    {
        return orgEstablishmentDate;
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
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
            .append("orgName", getOrgName())
            .append("orgType", getOrgType())
            .append("orgBusinessScope", getOrgBusinessScope())
            .append("orgStatus", getOrgStatus())
            .append("orgStaffSize", getOrgStaffSize())
            .append("orgContactInfo", getOrgContactInfo())
            .append("orgAddress", getOrgAddress())
            .append("orgId", getOrgId())
            .append("orgEstablishmentDate", getOrgEstablishmentDate())
            .append("orgUrl", getOrgUrl())
            .toString();
    }
}
