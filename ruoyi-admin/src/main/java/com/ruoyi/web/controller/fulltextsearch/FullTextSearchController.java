package com.ruoyi.web.controller.fulltextsearch;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.ResponseContent;
import com.ruoyi.unidom.fulltextsearch.FullTextSearchService;
import com.ruoyi.unidom.model.SearchParam;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fulltextsearch")
public class FullTextSearchController {
    @Value("${es_search_default_pageSize:1000}")
    protected Integer esDefaultPageSize;
    @Autowired
    private FullTextSearchService fullTextSearchService;

    @GetMapping("/search")
    public ResponseContent<PageResult<ObjectNode>> globalsearch(
            @RequestParam(name = "keyword", required = true) String keyword
    ) {

        PageResult<ObjectNode> list = fullTextSearchService.fullTextSearch(keyword);
        ResponseContent res=ResponseContent.success(list);
        return res;
    }


    @ApiOperation("unidom分页全文检索")
    @PostMapping("/pageSearch")
    public ResponseContent<PageResult<ObjectNode>> unidomPageSearch(
            @Valid @RequestBody SearchParam param
    ){

        String keyword=param.getKeyword();
        List<String> filterModuleCodes=param.getModuleCodes();

        int pageNum=param.getPageNum();
        int pageSize=param.getPageSize();
        //执行全文检索
        PageResult<ObjectNode> list= fullTextSearchService.pageSearch(keyword,pageNum,pageSize,filterModuleCodes);
        ResponseContent res=ResponseContent.success(list);
        return res;
    }

    @ApiOperation("unidom索引详情查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="moduleCode",value ="模块编码",required=true),
            @ApiImplicitParam(name="esId",value ="索引ID",required=true)
    })
    @GetMapping("/moduleDetail/{moduleCode}/{esId}")
    public ResponseContent<PageResult<ObjectNode>> unidomModuledetail(
            @PathVariable("moduleCode") String moduleCode,
            @PathVariable("esId") String esId
    ){
        ObjectNode list= fullTextSearchService.moduleDetail(moduleCode,esId);
        ResponseContent res=ResponseContent.success(list);
        return res;
    }

}