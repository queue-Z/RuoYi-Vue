package com.ruoyi.unidom.collection.service;

import com.ruoyi.unidom.collection.domain.UnidomEventData;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCollectionService {
    @Autowired
    DocumentPlusService documentPlusService;
    @Autowired
    IUnidomEventDataService unidomEventDataService;
    public void collectEvent() {
        // 查询所有的事件
        List<UnidomEventData> unidomEventDataList=unidomEventDataService.selectUnidomEventDataList(null);
        documentPlusService.syncBulkAdd("unidom_event_data", "unidom_event_data", unidomEventDataList);
    }
}
