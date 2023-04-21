package com.ruoyi.unidom.collection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实体-物-文件对象 unidom_file_data
 * 
 * @author quezhuhu
 * @date 2023-04-17
 */
public class UnidomFileData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模块编码，默认为m_file */
    @Excel(name = "模块编码，默认为m_file")
    private String moduleCode;

    /** 来源组织 */
    @Excel(name = "来源组织")
    private String orgName;

    /** 标签关键词，多个以英文逗号分隔 */
    @Excel(name = "标签关键词，多个以英文逗号分隔")
    private String labelKeywords;

    /** es更新时间，默认通update_time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "es更新时间，默认通update_time")
    private Date esUpdateTime;

    /** 文件标题 */
    @Excel(name = "文件标题")
    private String dataTitle;

    /** 文件简介 */
    @Excel(name = "文件简介")
    private String dataDesc;

    /** 文件url地址 */
    @Excel(name = "文件url地址")
    private String filePathUrl;

    /** 文件类型，pdf/doc/docx/xls/xlsx/txt/ppt/pptx */
    @Excel(name = "文件类型，pdf/doc/docx/xls/xlsx/txt/ppt/pptx")
    private String fileType;

    /** 文件大小-bytes */
    @Excel(name = "文件大小-bytes")
    private Long fileSizeBytes;

    /** 文件上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "文件上传时间")
    private Date fileUploadTime;

    /** 文件页数 */
    @Excel(name = "文件页数")
    private Long filePageNum;

    /** 对象存储key，如果非空，说明已经上传过文件 */
    @Excel(name = "对象存储key，如果非空，说明已经上传过文件")
    private String ossKey;

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
    public void setOrgName(String orgName) 
    {
        this.orgName = orgName;
    }

    public String getOrgName() 
    {
        return orgName;
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
    public void setFilePathUrl(String filePathUrl) 
    {
        this.filePathUrl = filePathUrl;
    }

    public String getFilePathUrl() 
    {
        return filePathUrl;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileSizeBytes(Long fileSizeBytes) 
    {
        this.fileSizeBytes = fileSizeBytes;
    }

    public Long getFileSizeBytes() 
    {
        return fileSizeBytes;
    }
    public void setFileUploadTime(Date fileUploadTime) 
    {
        this.fileUploadTime = fileUploadTime;
    }

    public Date getFileUploadTime() 
    {
        return fileUploadTime;
    }
    public void setFilePageNum(Long filePageNum) 
    {
        this.filePageNum = filePageNum;
    }

    public Long getFilePageNum() 
    {
        return filePageNum;
    }
    public void setOssKey(String ossKey) 
    {
        this.ossKey = ossKey;
    }

    public String getOssKey() 
    {
        return ossKey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moduleCode", getModuleCode())
            .append("orgName", getOrgName())
            .append("labelKeywords", getLabelKeywords())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("esUpdateTime", getEsUpdateTime())
            .append("dataTitle", getDataTitle())
            .append("dataDesc", getDataDesc())
            .append("filePathUrl", getFilePathUrl())
            .append("fileType", getFileType())
            .append("fileSizeBytes", getFileSizeBytes())
            .append("fileUploadTime", getFileUploadTime())
            .append("filePageNum", getFilePageNum())
            .append("ossKey", getOssKey())
            .toString();
    }
}
