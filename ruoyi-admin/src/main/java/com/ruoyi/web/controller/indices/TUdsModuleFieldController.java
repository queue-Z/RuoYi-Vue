package com.ruoyi.web.controller.indices;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.unidom.indices.domain.TUdsModuleField;
import com.ruoyi.unidom.indices.service.ITUdsModuleFieldService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模块字段Controller
 * 
 * @author quezhuhu
 * @date 2023-03-15
 */
@RestController
@RequestMapping("/indices/field")
public class TUdsModuleFieldController extends BaseController
{
    @Autowired
    private ITUdsModuleFieldService tUdsModuleFieldService;

    /**
     * 查询模块字段列表
     */
    //@PreAuthorize("@ss.hasPermi('indices:field:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUdsModuleField tUdsModuleField)
    {
        startPage();
        List<TUdsModuleField> list = tUdsModuleFieldService.selectTUdsModuleFieldList(tUdsModuleField);
        return getDataTable(list);
    }

    /**
     * 导出模块字段列表
     */
    //@PreAuthorize("@ss.hasPermi('indices:field:export')")
    @Log(title = "模块字段", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TUdsModuleField tUdsModuleField)
    {
        List<TUdsModuleField> list = tUdsModuleFieldService.selectTUdsModuleFieldList(tUdsModuleField);
        ExcelUtil<TUdsModuleField> util = new ExcelUtil<TUdsModuleField>(TUdsModuleField.class);
        util.exportExcel(response, list, "模块字段数据");
    }

    /**
     * 获取模块字段详细信息
     */
    //@PreAuthorize("@ss.hasPermi('indices:field:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tUdsModuleFieldService.selectTUdsModuleFieldById(id));
    }

    /**
     * 新增模块字段
     */
    //@PreAuthorize("@ss.hasPermi('indices:field:add')")
    @Log(title = "模块字段", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUdsModuleField tUdsModuleField)
    {
        return toAjax(tUdsModuleFieldService.insertTUdsModuleField(tUdsModuleField));
    }

    /**
     * 修改模块字段
     */
    //@PreAuthorize("@ss.hasPermi('indices:field:edit')")
    @Log(title = "模块字段", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUdsModuleField tUdsModuleField)
    {
        return toAjax(tUdsModuleFieldService.updateTUdsModuleField(tUdsModuleField));
    }

    /**
     * 删除模块字段
     */
    //@PreAuthorize("@ss.hasPermi('indices:field:remove')")
    @Log(title = "模块字段", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tUdsModuleFieldService.deleteTUdsModuleFieldByIds(ids));
    }
}
