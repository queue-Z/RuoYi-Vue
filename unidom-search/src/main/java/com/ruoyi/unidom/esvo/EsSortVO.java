package com.ruoyi.unidom.esvo;

import org.elasticsearch.search.sort.SortOrder;

import java.io.Serializable;

public class EsSortVO implements Serializable {
    // 排序字段
    private String sortField;
    // 排序规则
    private SortOrder sortOrder;


    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
}

