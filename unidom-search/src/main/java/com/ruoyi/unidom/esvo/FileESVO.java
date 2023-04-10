package com.ruoyi.unidom.esvo;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

@Data
public class FileESVO extends BaseESVO{
    @Excel(name = "文件id")
    private	String	fileId;
    @Excel(name = "文件url地址")
    private	String	filePathUrl;
    @Excel(name = "文件内容")
    private	String fileData;
    @Excel(name = "文件类型")
    private	String	fileType;
    @Excel(name = "文件大小-bytes")
    private	Long	fileSizeBytes;
    @Excel(name = "文件上传时间")
    private Date    fileUploadTime;
    @Excel(name = "文件页数")
    private	Long	filePageNum	;

}
