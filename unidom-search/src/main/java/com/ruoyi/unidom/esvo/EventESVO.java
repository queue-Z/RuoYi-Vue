package com.ruoyi.unidom.esvo;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

@Data
public class EventESVO extends BaseESVO{
    @Excel(name = "事件id")
    private	String	eventId	;
    @Excel(name = "事件详情url地址")
    private	String	eventDetailUrl	;
    @Excel(name = "事件证据附件url")
    private	String	eventAttachUrl	;
    @Excel(name = "事件编码")
    private	String	eventCode	;
    @Excel(name = "事件来源编码")
    private	String	eventSourceCode	;
    @Excel(name = "事件来源名称")
    private	String	eventSourceName	;
    @Excel(name = "是否上报")
    private	String	reportToLeader	;
    @Excel(name = "事件状态编码")
    private	String	eventStatusCode	;
    @Excel(name = "事件状态描述")
    private	String	eventStatusDesc	;
    @Excel(name = "事件归口编码")
    private	String	eventBelongCode	;
    @Excel(name = "事件归口名称")
    private	String	eventBelongName	;
    @Excel(name = "事件大类编码")
    private	String	eventBigTypeCode	;
    @Excel(name = "事件大类名称")
    private	String	eventBigTypeName	;
    @Excel(name = "事件小类编码")
    private	String	eventSmallTypeCode	;
    @Excel(name = "事件小类名称")
    private	String	eventSmallTypeName	;
    @Excel(name = "事件类型编码")
    private	String	eventTypeCode	;
    @Excel(name = "事件类型名称")
    private	String	eventTypeName	;
    @Excel(name = "事件渠道来源编码")
    private	String	eventChannelCode	;
    @Excel(name = "事件渠道来源名称")
    private	String	eventChannelName	;
    @Excel(name = "事件紧急程度编码")
    private	String	eventLevelCode	;
    @Excel(name = "事件紧急程度名称")
    private	String	eventLevelName	;
    @Excel(name = "事件发生时间")
    private	Date	eventOccurTime	;
    @Excel(name = "事件发生地经度-1.2版本后调整为dataLongitude")
    private	Double	eventLongitude	;
    @Excel(name = "事件发生地纬度-1.2版本后调整为dataLatitude")
    private	Double	eventLatitude	;
    @Excel(name = "事件发生地址")
    private	String	eventAddress	;
    @Excel(name = "事件内容")
    private	String	eventContent	;
    @Excel(name = "工单号码")
    private	String	workOrderNo	;
    @Excel(name = "工单创建时间")
    private Date workOrderCreateTime	;


    @Excel(name = "事件处置对象")
    private	String	eventHandler	;
    @Excel(name = "事件性质")
    private	String	eventNature	;
    @Excel(name = "事件处理出动车辆数")
    protected	Long	eventRespCar	;

}
