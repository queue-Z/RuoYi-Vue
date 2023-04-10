package com.ruoyi.unidom.collection.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体-事对象 unidom_event_data
 *
 * @author quezhuhu
 * @date 2023-04-10
 */
public class UnidomEventData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模块编码，默认为m_event */
    @Excel(name = "模块编码，默认为m_event")
    private String moduleCode;

    /** 1：省份；2：地市；3：区县；4：乡镇；5：街道,
     如果数据为公共数据，则该区域编码设置为0 */
    @Excel(name = "1：省份；2：地市；3：区县；4：乡镇；5：街道, 如果数据为公共数据，则该区域编码设置为0")
            private Long areaLevel;

            /** 区域编码,1：省份；2：地市；3：区县；4：乡镇；5：街道,
            如果数据为公共数据，则该区域编码设置为01：省份；2：地市；3：区县；4：乡镇；5：街道,
            如果数据为公共数据，则该区域编码设置为0 */
            @Excel(name = "区域编码,1：省份；2：地市；3：区县；4：乡镇；5：街道, " +
                    "如果数据为公共数据，则该区域编码设置为01：省份；2：地市；3：区县；4：乡镇；5：街道, 如果数据为公共数据，则该区域编码设置为0")
                    private String areaCode;

                    /** 区域名称 */
                    @Excel(name = "区域名称")
                    private String areaName;

                    /** 组织机构编码,1：省份；2：地市；3：区县；4：乡镇；5：街道,
                    如果数据为公共数据，则该区域编码设置为01：省份；2：地市；3：区县；4：乡镇；5：街道,
                    如果数据为公共数据，则该区域编码设置为0 */
                    @Excel(name = "组织机构编码,1：省份；2：地市；3：区县；4：乡镇；5：街道, 如果数据为公共数据，则该区域编码设置为01：省份；2：地市；3：区县；4：乡镇；5：街道, 如果数据为公共数据，则该区域编码设置为0")
                            private String orgCode;

                            /** 组织机构名称 */
                            @Excel(name = "组织机构名称")
                            private String orgName;

                            /** 业务分类编码 */
                            @Excel(name = "业务分类编码")
                            private String bizTypeCode;

                            /** 业务分类名称 */
                            @Excel(name = "业务分类名称")
                            private String bizTypeName;

                            /** 标签关键词，多个以英文逗号分隔 */
                            @Excel(name = "标签关键词，多个以英文逗号分隔")
                            private String labelKeywords;

                            /** 业务系统编码 */
                            @Excel(name = "业务系统编码")
                            private String bizSystemCode;

                            /** 业务系统名称 */
                            @Excel(name = "业务系统名称")
                            private String bizSystemName;

                            /** 业务系统地址 */
                            @Excel(name = "业务系统地址")
                            private String bizSystemUrl;

                            /** es更新时间，默认通update_time */
                            @JsonFormat(pattern = "yyyy-MM-dd")
                            @Excel(name = "es更新时间，默认通update_time", width = 30, dateFormat = "yyyy-MM-dd")
                    private Date esUpdateTime;

                    /** 事件Id */
                    @Excel(name = "事件Id")
                    private String eventId;

                    /** 事件标题 */
                    @Excel(name = "事件标题")
                    private String dataTitle;

                    /** 事件关键词 */
                    @Excel(name = "事件关键词")
                    private String dataKeywords;

                    /** 事件简介 */
                    @Excel(name = "事件简介")
                    private String dataDesc;

                    /** 事件详情url地址 */
                    @Excel(name = "事件详情url地址")
                    private String eventDetailUrl;

                    /** 事件证据附件url */
                    @Excel(name = "事件证据附件url")
                    private String eventAttachUrl;

                    /** 事件编码 */
                    @Excel(name = "事件编码")
                    private String eventCode;

                    /** 事件来源编码 */
                    @Excel(name = "事件来源编码")
                    private String eventSourceCode;

                    /** 事件来源名称 */
                    @Excel(name = "事件来源名称")
                    private String eventSourceName;

                    /** 是否上报 */
                    @Excel(name = "是否上报")
                    private String reportToLeader;

                    /** 事件状态编码 */
                    @Excel(name = "事件状态编码")
                    private String eventStatusCode;

                    /** 事件状态描述 */
                    @Excel(name = "事件状态描述")
                    private String eventStatusDesc;

                    /** 事件归口编码 */
                    @Excel(name = "事件归口编码")
                    private String eventBelongCode;

                    /** 事件归口名称 */
                    @Excel(name = "事件归口名称")
                    private String eventBelongName;

                    /** 事件大类型编码 */
                    @Excel(name = "事件大类型编码")
                    private String eventBigTypeCode;

                    /** 事件大类型名称 */
                    @Excel(name = "事件大类型名称")
                    private String eventBigTypeName;

                    /** 事件小类型编码 */
                    @Excel(name = "事件小类型编码")
                    private String eventSmallTypeCode;

                    /** 事件小类型名称 */
                    @Excel(name = "事件小类型名称")
                    private String eventSmallTypeName;

                    /** 事件子类型编码 */
                    @Excel(name = "事件子类型编码")
                    private String eventTypeCode;

                    /** 事件子类型名称 */
                    @Excel(name = "事件子类型名称")
                    private String eventTypeName;

                    /** 事件渠道来源编码 */
                    @Excel(name = "事件渠道来源编码")
                    private String eventChannelCode;

                    /** 事件渠道来源名称 */
                    @Excel(name = "事件渠道来源名称")
                    private String eventChannelName;

                    /** 事件紧急程度编码 */
                    @Excel(name = "事件紧急程度编码")
                    private String eventLevelCode;

                    /** 事件紧急程度名称 */
                    @Excel(name = "事件紧急程度名称")
                    private String eventLevelName;

                    /** 事件发生时间 */
                    @JsonFormat(pattern = "yyyy-MM-dd")
                    @Excel(name = "事件发生时间", width = 30, dateFormat = "yyyy-MM-dd")
            private Date eventOccurTime;

            /** 事件发生地经度 */
            @Excel(name = "事件发生地经度")
            private BigDecimal dataLongitude;

            /** 事件发生地维度 */
            @Excel(name = "事件发生地维度")
            private BigDecimal dataLatitude;

            /** 事件发生地址 */
            @Excel(name = "事件发生地址")
            private String eventAddress;

            /** 事件内容 */
            @Excel(name = "事件内容")
            private String eventContent;

            /** 工单号码 */
            @Excel(name = "工单号码")
            private String workOrderNo;

            /** 工单创建时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "工单创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workOrderCreateTime;

    /** 事件处置对象 */
    @Excel(name = "事件处置对象")
    private String eventHandler;

    /** 事件性质 */
    @Excel(name = "事件性质")
    private String eventNature;

    /** 事件处理出动车辆数 */
    @Excel(name = "事件处理出动车辆数")
    private Long eventRespCar;

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
    public void setAreaLevel(Long areaLevel)
    {
        this.areaLevel = areaLevel;
    }

    public Long getAreaLevel()
    {
        return areaLevel;
    }
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getAreaName()
    {
        return areaName;
    }
    public void setOrgCode(String orgCode)
    {
        this.orgCode = orgCode;
    }

    public String getOrgCode()
    {
        return orgCode;
    }
    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }

    public String getOrgName()
    {
        return orgName;
    }
    public void setBizTypeCode(String bizTypeCode)
    {
        this.bizTypeCode = bizTypeCode;
    }

    public String getBizTypeCode()
    {
        return bizTypeCode;
    }
    public void setBizTypeName(String bizTypeName)
    {
        this.bizTypeName = bizTypeName;
    }

    public String getBizTypeName()
    {
        return bizTypeName;
    }
    public void setLabelKeywords(String labelKeywords)
    {
        this.labelKeywords = labelKeywords;
    }

    public String getLabelKeywords()
    {
        return labelKeywords;
    }
    public void setBizSystemCode(String bizSystemCode)
    {
        this.bizSystemCode = bizSystemCode;
    }

    public String getBizSystemCode()
    {
        return bizSystemCode;
    }
    public void setBizSystemName(String bizSystemName)
    {
        this.bizSystemName = bizSystemName;
    }

    public String getBizSystemName()
    {
        return bizSystemName;
    }
    public void setBizSystemUrl(String bizSystemUrl)
    {
        this.bizSystemUrl = bizSystemUrl;
    }

    public String getBizSystemUrl()
    {
        return bizSystemUrl;
    }
    public void setEsUpdateTime(Date esUpdateTime)
    {
        this.esUpdateTime = esUpdateTime;
    }

    public Date getEsUpdateTime()
    {
        return esUpdateTime;
    }
    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getEventId()
    {
        return eventId;
    }
    public void setDataTitle(String dataTitle)
    {
        this.dataTitle = dataTitle;
    }

    public String getDataTitle()
    {
        return dataTitle;
    }
    public void setDataKeywords(String dataKeywords)
    {
        this.dataKeywords = dataKeywords;
    }

    public String getDataKeywords()
    {
        return dataKeywords;
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
    public void setEventAttachUrl(String eventAttachUrl)
    {
        this.eventAttachUrl = eventAttachUrl;
    }

    public String getEventAttachUrl()
    {
        return eventAttachUrl;
    }
    public void setEventCode(String eventCode)
    {
        this.eventCode = eventCode;
    }

    public String getEventCode()
    {
        return eventCode;
    }
    public void setEventSourceCode(String eventSourceCode)
    {
        this.eventSourceCode = eventSourceCode;
    }

    public String getEventSourceCode()
    {
        return eventSourceCode;
    }
    public void setEventSourceName(String eventSourceName)
    {
        this.eventSourceName = eventSourceName;
    }

    public String getEventSourceName()
    {
        return eventSourceName;
    }
    public void setReportToLeader(String reportToLeader)
    {
        this.reportToLeader = reportToLeader;
    }

    public String getReportToLeader()
    {
        return reportToLeader;
    }
    public void setEventStatusCode(String eventStatusCode)
    {
        this.eventStatusCode = eventStatusCode;
    }

    public String getEventStatusCode()
    {
        return eventStatusCode;
    }
    public void setEventStatusDesc(String eventStatusDesc)
    {
        this.eventStatusDesc = eventStatusDesc;
    }

    public String getEventStatusDesc()
    {
        return eventStatusDesc;
    }
    public void setEventBelongCode(String eventBelongCode)
    {
        this.eventBelongCode = eventBelongCode;
    }

    public String getEventBelongCode()
    {
        return eventBelongCode;
    }
    public void setEventBelongName(String eventBelongName)
    {
        this.eventBelongName = eventBelongName;
    }

    public String getEventBelongName()
    {
        return eventBelongName;
    }
    public void setEventBigTypeCode(String eventBigTypeCode)
    {
        this.eventBigTypeCode = eventBigTypeCode;
    }

    public String getEventBigTypeCode()
    {
        return eventBigTypeCode;
    }
    public void setEventBigTypeName(String eventBigTypeName)
    {
        this.eventBigTypeName = eventBigTypeName;
    }

    public String getEventBigTypeName()
    {
        return eventBigTypeName;
    }
    public void setEventSmallTypeCode(String eventSmallTypeCode)
    {
        this.eventSmallTypeCode = eventSmallTypeCode;
    }

    public String getEventSmallTypeCode()
    {
        return eventSmallTypeCode;
    }
    public void setEventSmallTypeName(String eventSmallTypeName)
    {
        this.eventSmallTypeName = eventSmallTypeName;
    }

    public String getEventSmallTypeName()
    {
        return eventSmallTypeName;
    }
    public void setEventTypeCode(String eventTypeCode)
    {
        this.eventTypeCode = eventTypeCode;
    }

    public String getEventTypeCode()
    {
        return eventTypeCode;
    }
    public void setEventTypeName(String eventTypeName)
    {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName()
    {
        return eventTypeName;
    }
    public void setEventChannelCode(String eventChannelCode)
    {
        this.eventChannelCode = eventChannelCode;
    }

    public String getEventChannelCode()
    {
        return eventChannelCode;
    }
    public void setEventChannelName(String eventChannelName)
    {
        this.eventChannelName = eventChannelName;
    }

    public String getEventChannelName()
    {
        return eventChannelName;
    }
    public void setEventLevelCode(String eventLevelCode)
    {
        this.eventLevelCode = eventLevelCode;
    }

    public String getEventLevelCode()
    {
        return eventLevelCode;
    }
    public void setEventLevelName(String eventLevelName)
    {
        this.eventLevelName = eventLevelName;
    }

    public String getEventLevelName()
    {
        return eventLevelName;
    }
    public void setEventOccurTime(Date eventOccurTime)
    {
        this.eventOccurTime = eventOccurTime;
    }

    public Date getEventOccurTime()
    {
        return eventOccurTime;
    }
    public void setDataLongitude(BigDecimal dataLongitude)
    {
        this.dataLongitude = dataLongitude;
    }

    public BigDecimal getDataLongitude()
    {
        return dataLongitude;
    }
    public void setDataLatitude(BigDecimal dataLatitude)
    {
        this.dataLatitude = dataLatitude;
    }

    public BigDecimal getDataLatitude()
    {
        return dataLatitude;
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
    public void setWorkOrderNo(String workOrderNo)
    {
        this.workOrderNo = workOrderNo;
    }

    public String getWorkOrderNo()
    {
        return workOrderNo;
    }
    public void setWorkOrderCreateTime(Date workOrderCreateTime)
    {
        this.workOrderCreateTime = workOrderCreateTime;
    }

    public Date getWorkOrderCreateTime()
    {
        return workOrderCreateTime;
    }
    public void setEventHandler(String eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    public String getEventHandler()
    {
        return eventHandler;
    }
    public void setEventNature(String eventNature)
    {
        this.eventNature = eventNature;
    }

    public String getEventNature()
    {
        return eventNature;
    }
    public void setEventRespCar(Long eventRespCar)
    {
        this.eventRespCar = eventRespCar;
    }

    public Long getEventRespCar()
    {
        return eventRespCar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("moduleCode", getModuleCode())
                .append("areaLevel", getAreaLevel())
                .append("areaCode", getAreaCode())
                .append("areaName", getAreaName())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("bizTypeCode", getBizTypeCode())
                .append("bizTypeName", getBizTypeName())
                .append("labelKeywords", getLabelKeywords())
                .append("bizSystemCode", getBizSystemCode())
                .append("bizSystemName", getBizSystemName())
                .append("bizSystemUrl", getBizSystemUrl())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("esUpdateTime", getEsUpdateTime())
                .append("eventId", getEventId())
                .append("dataTitle", getDataTitle())
                .append("dataKeywords", getDataKeywords())
                .append("dataDesc", getDataDesc())
                .append("eventDetailUrl", getEventDetailUrl())
                .append("eventAttachUrl", getEventAttachUrl())
                .append("eventCode", getEventCode())
                .append("eventSourceCode", getEventSourceCode())
                .append("eventSourceName", getEventSourceName())
                .append("reportToLeader", getReportToLeader())
                .append("eventStatusCode", getEventStatusCode())
                .append("eventStatusDesc", getEventStatusDesc())
                .append("eventBelongCode", getEventBelongCode())
                .append("eventBelongName", getEventBelongName())
                .append("eventBigTypeCode", getEventBigTypeCode())
                .append("eventBigTypeName", getEventBigTypeName())
                .append("eventSmallTypeCode", getEventSmallTypeCode())
                .append("eventSmallTypeName", getEventSmallTypeName())
                .append("eventTypeCode", getEventTypeCode())
                .append("eventTypeName", getEventTypeName())
                .append("eventChannelCode", getEventChannelCode())
                .append("eventChannelName", getEventChannelName())
                .append("eventLevelCode", getEventLevelCode())
                .append("eventLevelName", getEventLevelName())
                .append("eventOccurTime", getEventOccurTime())
                .append("dataLongitude", getDataLongitude())
                .append("dataLatitude", getDataLatitude())
                .append("eventAddress", getEventAddress())
                .append("eventContent", getEventContent())
                .append("workOrderNo", getWorkOrderNo())
                .append("workOrderCreateTime", getWorkOrderCreateTime())
                .append("eventHandler", getEventHandler())
                .append("eventNature", getEventNature())
                .append("eventRespCar", getEventRespCar())
                .toString();
    }
}
