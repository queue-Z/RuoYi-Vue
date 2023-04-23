package com.ruoyi.unidom.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
@Data
public class SearchParam implements Serializable {

    @NotNull(message = "关键字不能为空")
    private String keyword;

    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    @NotNull(message = "每页数量不能为空")
    private Integer pageSize;

    protected List<String> moduleCodes;
}
