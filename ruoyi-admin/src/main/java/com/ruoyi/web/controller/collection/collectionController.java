package com.ruoyi.web.controller.collection;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.unidom.collection.service.CollectionService;
import com.ruoyi.unidom.common.page.PageResult;
import com.ruoyi.unidom.common.response.ResponseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collection")
public class collectionController {
    @Autowired
    private CollectionService collectionService;

    @PostMapping("/add/{moduleCode}")
    public ResponseContent add2es(@PathVariable String moduleCode) {
        int cnt = collectionService.collectEntity(moduleCode);
        ResponseContent res=ResponseContent.success("成功采集"+cnt+"条数据");
        return res;
    }

    @PutMapping("/update/{moduleCode}")
    public ResponseContent update2es(@PathVariable String moduleCode) {
        int cnt = collectionService.updateEntity(moduleCode);
        ResponseContent res=ResponseContent.success("成功更新"+cnt+"条数据");
        return res;
    }

    @DeleteMapping("/delete/{moduleCode}")
    public ResponseContent delete2es(@PathVariable String moduleCode) {
        int cnt = collectionService.deleteAllEntity(moduleCode);
        ResponseContent res=ResponseContent.success("成功删除"+cnt+"条数据");
        return res;
    }

}
