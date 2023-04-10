package com.ruoyi.unidom.esvo;
import lombok.Data;
import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseESVO implements Serializable {
    @Excel(name = "主键")
    protected	String	id	;
    @Excel(name = "浏览次数")
    protected	Long	viewCount	;
    @Excel(name = "下载次数")
    protected	Long	downloadCount	;
    @Excel(name = "模块编码")
    protected	String	moduleCode	;
    @Excel(name = "区域级别")
    protected	String	areaLevel	;
    @Excel(name = "区域编码")
    protected	String	areaCode	;
    @Excel(name = "区域名称")
    protected	String	areaName	;
    @Excel(name = "组织机构编码")
    protected	String	orgCode	;
    @Excel(name = "组织机构名称")
    protected	String	orgName	;
    @Excel(name = "业务类型编码")
    protected	String	bizTypeCode	;
    @Excel(name = "业务类型名称")
    protected	String	bizTypeName	;
    @Excel(name = "标签关键词")
    protected	String	labelKeywords	;
    @Excel(name = "业务系统编码")
    protected	String	bizSystemCode	;
    @Excel(name = "业务系统名称")
    protected	String	bizSystemName	;
    @Excel(name = "业务系统url")
    protected	String	bizSystemUrl	;
    @Excel(name = "数据创建时间")
    protected	Date	createTime	;
    @Excel(name = "数据更新时间")
    protected	Date	updateTime	;
    @Excel(name = "es更新时间")
    protected   Date esUpdateTime	;
    @Excel(name = "数据标题")
    protected	String	dataTitle	;
    @Excel(name = "数据关键词")
    protected	String	dataKeywords	;
    @Excel(name = "数据描述")
    protected	String	dataDesc	;

    //扩展字段，预留对接oss对象存储
    //oss存储key
    @Excel(name = "oss存储key")
    protected String ossKey;
    //oss存储Bucket
    @Excel(name = "oss存储Bucket")
    protected String ossBucket;
    //oss访问url
    @Excel(name = "oss访问url")
    protected String ossUrl;
    //oss缩略图url
    @Excel(name = "oss缩略图url")
    protected String ossThumbnailUrl;

    @Excel(name = "数据经度")
    protected 	Double	dataLongitude;
    @Excel(name = "数据纬度")
    protected 	Double	dataLatitude;

}
