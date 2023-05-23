package com.ruoyi.web.controller.indices;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.unidom.indices.domain.TUdsIndiceConf;
import com.ruoyi.unidom.indices.service.ITUdsIndiceConfService;
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
 * 索引配置Controller
 * 
 * @author quezhuhu
 * @date 2023-03-14
 */
@RestController
@RequestMapping("/indices/conf")
public class TUdsIndiceConfController extends BaseController
{
    @Autowired
    private ITUdsIndiceConfService tUdsIndiceConfService;

    /**
     * 查询索引配置列表
     */
    //@PreAuthorize("@ss.hasPermi('indices:conf:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUdsIndiceConf tUdsIndiceConf)
    {
        startPage();
        List<TUdsIndiceConf> list = tUdsIndiceConfService.selectTUdsIndiceConfList(tUdsIndiceConf);
        return getDataTable(list);
    }

    /**
     * 导出索引配置列表
     */
    //@PreAuthorize("@ss.hasPermi('indices:conf:export')")
    @Log(title = "索引配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TUdsIndiceConf tUdsIndiceConf)
    {
        List<TUdsIndiceConf> list = tUdsIndiceConfService.selectTUdsIndiceConfList(tUdsIndiceConf);
        ExcelUtil<TUdsIndiceConf> util = new ExcelUtil<TUdsIndiceConf>(TUdsIndiceConf.class);
        util.exportExcel(response, list, "索引配置数据");
    }

    /**
     * 获取索引配置详细信息
     */
    //@PreAuthorize("@ss.hasPermi('indices:conf:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tUdsIndiceConfService.selectTUdsIndiceConfById(id));
    }

    /**
     * 新增索引配置
     */
    //@PreAuthorize("@ss.hasPermi('indices:conf:add')")
    @Log(title = "索引配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUdsIndiceConf tUdsIndiceConf)
    {
        return toAjax(tUdsIndiceConfService.insertTUdsIndiceConf(tUdsIndiceConf));
    }

    /**
     * 修改索引配置
     */
    //@PreAuthorize("@ss.hasPermi('indices:conf:edit')")
    @Log(title = "索引配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUdsIndiceConf tUdsIndiceConf)
    {
        return toAjax(tUdsIndiceConfService.updateTUdsIndiceConf(tUdsIndiceConf));
    }

    /**
     * 删除索引配置
     */
    //@PreAuthorize("@ss.hasPermi('indices:conf:remove')")
    @Log(title = "索引配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tUdsIndiceConfService.deleteTUdsIndiceConfByIds(ids));
    }
}
