package com.ruoyi.unidom.indices.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模块字段对象 t_uds_module_field
 *
 * @author quezhuhu
 * @date 2023-04-25
 */
public class TUdsModuleField extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 模块id */
    @Excel(name = "模块id")
    private Long moduleId;

    /** 检索字段类型（keyword、text、long...） */
    @Excel(name = "检索字段类型", readConverterExp = "k=eyword、text、long...")
    private String fieldType;

    /** 检索字段名称（驼峰命名） */
    @Excel(name = "检索字段名称", readConverterExp = "驼=峰命名")
    private String fieldName;

    /** 全文检索标识 */
    @Excel(name = "全文检索标识")
    private Long fulltextFlag;

    /** 检索类型（query,match,term,wild,fuzzy） */
    @Excel(name = "检索类型", readConverterExp = "q=uery,match,term,wild,fuzzy")
    private String searchType;

    /** 检索字段描述 */
    @Excel(name = "检索字段描述")
    private String fieldDesc;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long isDelete;

    /** 字段评分权重 */
    @Excel(name = "字段评分权重")
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
    public void setFieldDesc(String fieldDesc)
    {
        this.fieldDesc = fieldDesc;
    }

    public String getFieldDesc()
    {
        return fieldDesc;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("moduleId", getModuleId())
                .append("fieldType", getFieldType())
                .append("fieldName", getFieldName())
                .append("fulltextFlag", getFulltextFlag())
                .append("searchType", getSearchType())
                .append("fieldDesc", getFieldDesc())
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
