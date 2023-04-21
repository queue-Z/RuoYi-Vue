package com.ruoyi.unidom.collection.service;

import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.collection.domain.UnidomFileData;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import com.ruoyi.unidom.indices.service.ITUdsModuleDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    @Autowired
    DocumentPlusService documentPlusService;

    @Autowired
    ITUdsModuleDefService tUdsModuleDefService;
    @Autowired
    IUnidomEventDataService unidomEventDataService;

    @Autowired
    IUnidomFileDataService unidomFileDataService;


    public void collectEvent() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_event");
        // 查询所有的事件
        List<UnidomEventData> unidomEventDataList=unidomEventDataService.selectUnidomEventDataList(null);
        documentPlusService.syncBulkAdd(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomEventDataList);
    }

    public void collectFile() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_file");
        // 查询所有的文档
        List<UnidomFileData> unidomFileDataList=unidomFileDataService.selectUnidomFileDataList(null);
        documentPlusService.syncBulkAdd(module.getModuleIndiceName(), module.getModuleIndiceName(), unidomFileDataList);
    }
}
