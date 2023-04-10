package com.ruoyi.unidom.indices.domain;

import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 模块字段对象 t_uds_module_field
 * 
 * @author quezhuhu
 * @date 2023-03-15
 */
public class TUdsModuleField extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 索引模块 */
    private Long moduleId;

    /** 索引字段类型 */
    @Excel(name = "索引字段类型")
    private String fieldType;

    /** 索引字段名称 */
    @Excel(name = "索引字段名称")
    private String fieldName;

    /** 全文检索标识  */
    @Excel(name = "全文检索标识 ")
    private Long fulltextFlag;

    /** 搜索类型 */
    @Excel(name = "搜索类型")
    private String searchType;

    /** 字段展示分类(1：标题，2：简介，3：关键词，4：业务分类，5：业务标签，6：普通文本，7、表格信息，8：权限信息) */
    private Long fieldClass;

    /** 字段描述 */
    @Excel(name = "字段描述")
    private String fieldDesc;

    /** 否支为排序字段 1：是，0：否 */
    private Long orderbyFlag;

    /** 列表显示标识 1：是，0：否 */
    private Long listFlag;

    /** 列表显示顺序 */
    private Long listSort;

    /** 详情显示标识 1：是，0：否 */
    private Long dtlFlag;

    /** 详情显示顺序 */
    private Long dtlSort;

    /** 筛选条件标识 1：是，0：否 */
    private Long condFlag;

    /** 筛选条件顺序 */
    private Long condSort;

    /** 筛选条件形式（input：输入框；dropdown：下拉列表；tree：树形选择） */
    private String condFormat;

    /** 筛选条件来源表(业务分类表、区域表、组织机构表、系统参数表) */
    private String condTable;

    /** 筛选条件参数类型，对应系统参数表type_code */
    private String condSysTypeCode;

    /** 是否中文拼音混合查询1：是，0：否 */
    private Long cnPinyinMixFlag;

    /** 搜索结果高亮标识1：是，0：否 */
    private Long hightlightFlag;

    /** 是否脱敏 */
    private Long maskFlag;

    /** 脱敏规则 */
    private String maskRule;

    /** 源始表名 */
    private String origTable;

    /** 源字段名 */
    private String origField;

    /** 自定义配置信息 */
    private String confInfo;

    /** 是否删除 */
    private Long isDelete;

    /** 字段评分权重 */
    private BigDecimal fieldBoost;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setModuleId(Long moduleId) 
    {
        this.moduleId = moduleId;
    }

    public Long getModuleId() 
    {
        return moduleId;
    }
    public void setFieldType(String fieldType) 
    {
        this.fieldType = fieldType;
    }

    public String getFieldType() 
    {
        return fieldType;
    }
    public void setFieldName(String fieldName) 
    {
        this.fieldName = fieldName;
    }

    public String getFieldName() 
    {
        return fieldName;
    }
    public void setFulltextFlag(Long fulltextFlag) 
    {
        this.fulltextFlag = fulltextFlag;
    }

    public Long getFulltextFlag() 
    {
        return fulltextFlag;
    }
    public void setSearchType(String searchType) 
    {
        this.searchType = searchType;
    }

    public String getSearchType() 
    {
        return searchType;
    }
    public void setFieldClass(Long fieldClass) 
    {
        this.fieldClass = fieldClass;
    }

    public Long getFieldClass() 
    {
        return fieldClass;
    }
    public void setFieldDesc(String fieldDesc) 
    {
        this.fieldDesc = fieldDesc;
    }

    public String getFieldDesc() 
    {
        return fieldDesc;
    }
    public void setOrderbyFlag(Long orderbyFlag) 
    {
        this.orderbyFlag = orderbyFlag;
    }

    public Long getOrderbyFlag() 
    {
        return orderbyFlag;
    }
    public void setListFlag(Long listFlag) 
    {
        this.listFlag = listFlag;
    }

    public Long getListFlag() 
    {
        return listFlag;
    }
    public void setListSort(Long listSort) 
    {
        this.listSort = listSort;
    }

    public Long getListSort() 
    {
        return listSort;
    }
    public void setDtlFlag(Long dtlFlag) 
    {
        this.dtlFlag = dtlFlag;
    }

    public Long getDtlFlag() 
    {
        return dtlFlag;
    }
    public void setDtlSort(Long dtlSort) 
    {
        this.dtlSort = dtlSort;
    }

    public Long getDtlSort() 
    {
        return dtlSort;
    }
    public void setCondFlag(Long condFlag) 
    {
        this.condFlag = condFlag;
    }

    public Long getCondFlag() 
    {
        return condFlag;
    }
    public void setCondSort(Long condSort) 
    {
        this.condSort = condSort;
    }

    public Long getCondSort() 
    {
        return condSort;
    }
    public void setCondFormat(String condFormat) 
    {
        this.condFormat = condFormat;
    }

    public String getCondFormat() 
    {
        return condFormat;
    }
    public void setCondTable(String condTable) 
    {
        this.condTable = condTable;
    }

    public String getCondTable() 
    {
        return condTable;
    }
    public void setCondSysTypeCode(String condSysTypeCode) 
    {
        this.condSysTypeCode = condSysTypeCode;
    }

    public String getCondSysTypeCode() 
    {
        return condSysTypeCode;
    }
    public void setCnPinyinMixFlag(Long cnPinyinMixFlag) 
    {
        this.cnPinyinMixFlag = cnPinyinMixFlag;
    }

    public Long getCnPinyinMixFlag() 
    {
        return cnPinyinMixFlag;
    }
    public void setHightlightFlag(Long hightlightFlag) 
    {
        this.hightlightFlag = hightlightFlag;
    }

    public Long getHightlightFlag() 
    {
        return hightlightFlag;
    }
    public void setMaskFlag(Long maskFlag) 
    {
        this.maskFlag = maskFlag;
    }

    public Long getMaskFlag() 
    {
        return maskFlag;
    }
    public void setMaskRule(String maskRule) 
    {
        this.maskRule = maskRule;
    }

    public String getMaskRule() 
    {
        return maskRule;
    }
    public void setOrigTable(String origTable) 
    {
        this.origTable = origTable;
    }

    public String getOrigTable() 
    {
        return origTable;
    }
    public void setOrigField(String origField) 
    {
        this.origField = origField;
    }

    public String getOrigField() 
    {
        return origField;
    }
    public void setConfInfo(String confInfo) 
    {
        this.confInfo = confInfo;
    }

    public String getConfInfo() 
    {
        return confInfo;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }
    public void setFieldBoost(BigDecimal fieldBoost) 
    {
        this.fieldBoost = fieldBoost;
    }

    public BigDecimal getFieldBoost() 
    {
        return fieldBoost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("moduleId", getModuleId())
            .append("fieldType", getFieldType())
            .append("fieldName", getFieldName())
            .append("fulltextFlag", getFulltextFlag())
            .append("searchType", getSearchType())
            .append("fieldClass", getFieldClass())
            .append("fieldDesc", getFieldDesc())
            .append("orderbyFlag", getOrderbyFlag())
            .append("listFlag", getListFlag())
            .append("listSort", getListSort())
            .append("dtlFlag", getDtlFlag())
            .append("dtlSort", getDtlSort())
            .append("condFlag", getCondFlag())
            .append("condSort", getCondSort())
            .append("condFormat", getCondFormat())
            .append("condTable", getCondTable())
            .append("condSysTypeCode", getCondSysTypeCode())
            .append("cnPinyinMixFlag", getCnPinyinMixFlag())
            .append("hightlightFlag", getHightlightFlag())
            .append("maskFlag", getMaskFlag())
            .append("maskRule", getMaskRule())
            .append("origTable", getOrigTable())
            .append("origField", getOrigField())
            .append("confInfo", getConfInfo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("isDelete", getIsDelete())
            .append("fieldBoost", getFieldBoost())
            .toString();
    }
}
