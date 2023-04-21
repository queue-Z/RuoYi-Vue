package com.ruoyi.web.controller.fulltextsearch;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.ResponseContent;
import com.ruoyi.unidom.fulltextsearch.FullTextSearchService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class FullTextSearchController {
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
}