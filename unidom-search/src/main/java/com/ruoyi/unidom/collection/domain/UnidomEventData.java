package com.ruoyi.unidom.collection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实体-事对象 unidom_event_data
 * 
 * @author quezhuhu
 * @date 2023-04-11
 */
public class UnidomEventData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模块编码，默认为m_event */
    @Excel(name = "模块编码，默认为m_event")
    private String moduleCode;

    /** 标签关键词，多个以英文逗号分隔 */
    @Excel(name = "标签关键词，多个以英文逗号分隔")
    private String labelKeywords;

    /** es更新时间，默认通update_time */

    @Excel(name = "es更新时间，默认通update_time")
    private Date esUpdateTime;

    /** 事件标题 */
    @Excel(name = "事件标题")
    private String dataTitle;

    /** 事件简介 */
    @Excel(name = "事件简介")
    private String dataDesc;

    /** 事件详情url地址 */
    @Excel(name = "事件详情url地址")
    private String eventDetailUrl;

    /** 事件子类型名称 */
    @Excel(name = "事件子类型名称")
    private String eventTypeName;

    /** 事件发生时间 */
    @Excel(name = "事件发生时间")
    private Date eventOccurTime;

    /** 事件发生地址 */
    @Excel(name = "事件发生地址")
    private String eventAddress;

    /** 事件内容 */
    @Excel(name = "事件内容")
    private String eventContent;

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
    public void setEventDetailUrl(String eventDetailUrl) 
    {
        this.eventDetailUrl = eventDetailUrl;
    }

    public String getEventDetailUrl() 
    {
        return eventDetailUrl;
    }
    public void setEventTypeName(String eventTypeName) 
    {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName() 
    {
        return eventTypeName;
    }
    public void setEventOccurTime(Date eventOccurTime) 
    {
        this.eventOccurTime = eventOccurTime;
    }

    public Date getEventOccurTime() 
    {
        return eventOccurTime;
    }
    public void setEventAddress(String eventAddress) 
    {
        this.eventAddress = eventAddress;
    }

    public String getEventAddress() 
    {
        return eventAddress;
    }
    public void setEventContent(String eventContent) 
    {
        this.eventContent = eventContent;
    }

    public String getEventContent() 
    {
        return eventContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moduleCode", getModuleCode())
            .append("labelKeywords", getLabelKeywords())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("esUpdateTime", getEsUpdateTime())
            .append("dataTitle", getDataTitle())
            .append("dataDesc", getDataDesc())
            .append("eventDetailUrl", getEventDetailUrl())
            .append("eventTypeName", getEventTypeName())
            .append("eventOccurTime", getEventOccurTime())
            .append("eventAddress", getEventAddress())
            .append("eventContent", getEventContent())
            .toString();
    }
}
