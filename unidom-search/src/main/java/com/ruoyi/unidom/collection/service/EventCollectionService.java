package com.ruoyi.unidom.collection.service;

import com.ruoyi.unidom.esvo.BaseESVO;
import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import com.ruoyi.unidom.util.DocumentPlusServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EventCollectionService {
    DocumentPlusServiceImpl documentPlusService;
    TUdsModuleDef moduleDefEntity;
    public void collectEvent() {
        List<BaseESVO> baseESVOList=new ArrayList<>();
        documentPlusService.syncBulkAdd(moduleDefEntity.getModuleIndiceName(),
                moduleDefEntity.getModuleIndiceName(), baseESVOList);
    }
}
