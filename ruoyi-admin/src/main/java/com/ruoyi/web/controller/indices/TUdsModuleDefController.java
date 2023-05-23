package com.ruoyi.web.controller.indices;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import com.ruoyi.unidom.indices.service.ITUdsModuleDefService;
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

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模块定义Controller
 * 
 * @author quezhuhu
 * @date 2023-03-13
 */
@RestController
@RequestMapping("/indices/def")
public class TUdsModuleDefController extends BaseController
{
    @Autowired
    private ITUdsModuleDefService tUdsModuleDefService;

    /**
     * 查询模块定义列表
     */
    //@PreAuthorize("@ss.hasPermi('indices:def:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUdsModuleDef tUdsModuleDef)
    {
        startPage();
        List<TUdsModuleDef> list = tUdsModuleDefService.selectTUdsModuleDefList(tUdsModuleDef);
        return getDataTable(list);
    }

    /**
     * 导出模块定义列表
     */
    //@PreAuthorize("@ss.hasPermi('indices:def:export')")
    @Log(title = "模块定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TUdsModuleDef tUdsModuleDef)
    {
        List<TUdsModuleDef> list = tUdsModuleDefService.selectTUdsModuleDefList(tUdsModuleDef);
        ExcelUtil<TUdsModuleDef> util = new ExcelUtil<TUdsModuleDef>(TUdsModuleDef.class);
        util.exportExcel(response, list, "模块定义数据");
    }

    /**
     * 获取模块定义详细信息
     */
    //@PreAuthorize("@ss.hasPermi('indices:def:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tUdsModuleDefService.selectTUdsModuleDefById(id));
    }

    /**
     * 新增模块定义
     */
    //@PreAuthorize("@ss.hasPermi('indices:def:add')")
    @Log(title = "模块定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUdsModuleDef tUdsModuleDef)
    {
        return toAjax(tUdsModuleDefService.insertTUdsModuleDef(tUdsModuleDef));
    }

    /**
     * 修改模块定义
     */
    //@PreAuthorize("@ss.hasPermi('indices:def:edit')")
    @Log(title = "模块定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUdsModuleDef tUdsModuleDef)
    {
        return toAjax(tUdsModuleDefService.updateTUdsModuleDef(tUdsModuleDef));
    }

    /**
     * 删除模块定义
     */
    //@PreAuthorize("@ss.hasPermi('indices:def:remove')")
    @Log(title = "模块定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tUdsModuleDefService.deleteTUdsModuleDefByIds(ids));
    }
}
