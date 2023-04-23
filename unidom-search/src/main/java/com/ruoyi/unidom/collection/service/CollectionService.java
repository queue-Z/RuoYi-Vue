package com.ruoyi.unidom.collection.service;

import com.ruoyi.unidom.collection.domain.*;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import com.ruoyi.unidom.indices.domain.TUdsModuleDef;
import com.ruoyi.unidom.indices.service.ITUdsModuleDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    @Autowired
    DocumentPlusService documentPlusService;

    @Autowired
    ITUdsModuleDefService tUdsModuleDefService;

    @Autowired
    IUnidomPeopleDataService unidomPeopleDataService;
    @Autowired
    IUnidomPlaceDataService unidomPlaceDataService;
    @Autowired
    IUnidomEventDataService unidomEventDataService;
    @Autowired
    IUnidomFileDataService unidomFileDataService;
    @Autowired
    IUnidomOrganizationDataService unidomOrganizationDataService;

    public int collectEntity(String moduleCode){
        int cnt = 0;
        switch (moduleCode){
            case "m_people":
                cnt = collectPeople();
                break;
            case "m_place":
                cnt = collectPlace();
                break;
            case "m_event":
                cnt = collectEvent();
                break;
            case "m_file":
                cnt = collectFile();
                break;
            case "m_organization":
                cnt = collectOrganization();
                break;
            default:
                break;
        }
        return cnt;

    }

    public int deleteAllEntity(String moduleCode){
        int cnt = 0;
        switch (moduleCode){
            case "m_people":
                cnt = deleteAllPeople();
                break;
            case "m_place":
                cnt = deleteAllPlace();
                break;
            case "m_event":
                cnt = deleteAllEvent();
                break;
            case "m_file":
                cnt = deleteAllFile();
                break;
            case "m_organization":
                cnt = deleteAllOrganization();
                break;
            default:
                break;
        }
        return cnt;

    }

    public int updateEntity(String moduleCode){
        int cnt = 0;
        switch (moduleCode){
            case "m_people":
                cnt = updatePeople();
                break;
            case "m_place":
                cnt = updatePlace();
                break;
            case "m_event":
                cnt = updateEvent();
                break;
            case "m_file":
                cnt = updateFile();
                break;
            case "m_organization":
                cnt = updateOrganization();
                break;
            default:
                break;
        }
return cnt;
    }

    public int collectPeople() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_people");
        // 查询所有的人
        List<UnidomPeopleData> unidomPeopleDataList=unidomPeopleDataService.selectUnidomPeopleDataList(null);
        return documentPlusService.syncBulkAdd(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomPeopleDataList);
    }

    public int deleteAllPeople() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_people");
        // 查询所有的人
        List<UnidomPeopleData> unidomPeopleDataList=unidomPeopleDataService.selectUnidomPeopleDataList(null);
        List<String> idList = new ArrayList<>();
        for (UnidomPeopleData unidomPeopleData : unidomPeopleDataList) {
            idList.add(unidomPeopleData.getId().toString());
        }
        return documentPlusService.syncBulkDelete(module.getModuleIndiceName(),module.getModuleIndiceName(), idList);
    }

    public int updatePeople() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_people");
        // 查询所有的人
        List<UnidomPeopleData> unidomPeopleDataList=unidomPeopleDataService.selectUnidomPeopleDataList(null);
        return documentPlusService.syncBulkUpdate(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomPeopleDataList);
    }

    public int collectPlace() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_place");
        // 查询所有的地点
        List<UnidomPlaceData> unidomPlaceDataList=unidomPlaceDataService.selectUnidomPlaceDataList(null);
        return documentPlusService.syncBulkAdd(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomPlaceDataList);
    }

    public int deleteAllPlace() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_place");
        // 查询所有的地点
        List<UnidomPlaceData> unidomPlaceDataList=unidomPlaceDataService.selectUnidomPlaceDataList(null);
        List<String> idList = new ArrayList<>();
        for (UnidomPlaceData unidomPlaceData : unidomPlaceDataList) {
            idList.add(unidomPlaceData.getId().toString());
        }
        return documentPlusService.syncBulkDelete(module.getModuleIndiceName(),module.getModuleIndiceName(), idList);
    }

    public int updatePlace() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_place");
        // 查询所有的地点
        List<UnidomPlaceData> unidomPlaceDataList=unidomPlaceDataService.selectUnidomPlaceDataList(null);
        return documentPlusService.syncBulkUpdate(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomPlaceDataList);
    }


    public int collectEvent() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_event");
        // 查询所有的事件
        List<UnidomEventData> unidomEventDataList=unidomEventDataService.selectUnidomEventDataList(null);
        return documentPlusService.syncBulkAdd(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomEventDataList);
    }

    public int deleteAllEvent() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_event");
        // 查询所有的事件
        List<UnidomEventData> unidomEventDataList=unidomEventDataService.selectUnidomEventDataList(null);
        List<String> idList = new ArrayList<>();
        for (UnidomEventData unidomEventData : unidomEventDataList) {
            idList.add(unidomEventData.getId().toString());
        }
        return documentPlusService.syncBulkDelete(module.getModuleIndiceName(),module.getModuleIndiceName(), idList);
    }

    public int updateEvent() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_event");
        // 查询所有的事件
        List<UnidomEventData> unidomEventDataList=unidomEventDataService.selectUnidomEventDataList(null);
        return documentPlusService.syncBulkUpdate(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomEventDataList);
    }

    public int collectFile() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_file");
        // 查询所有的文档
        List<UnidomFileData> unidomFileDataList=unidomFileDataService.selectUnidomFileDataList(null);
        return documentPlusService.syncBulkAdd(module.getModuleIndiceName(), module.getModuleIndiceName(), unidomFileDataList);
    }

    public int deleteAllFile(){
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_file");
        // 查询所有的文档
        List<UnidomFileData> unidomFileDataList=unidomFileDataService.selectUnidomFileDataList(null);
        List<String> idList = new ArrayList<>();
        for (UnidomFileData unidomFileData : unidomFileDataList) {
            idList.add(unidomFileData.getId().toString());
        }
        return documentPlusService.syncBulkDelete(module.getModuleIndiceName(),module.getModuleIndiceName(), idList);
    }

    public int updateFile(){
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_file");
        // 查询所有的文档
        List<UnidomFileData> unidomFileDataList=unidomFileDataService.selectUnidomFileDataList(null);
        return documentPlusService.syncBulkUpdate(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomFileDataList);
    }

    public int collectOrganization() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_organization");
        // 查询所有的组织
        List<UnidomOrganizationData> unidomOrganizationDataList=unidomOrganizationDataService.selectUnidomOrganizationDataList(null);
        return documentPlusService.syncBulkAdd(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomOrganizationDataList);
    }

    public int deleteAllOrganization() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_organization");
        // 查询所有的组织
        List<UnidomOrganizationData> unidomOrganizationDataList=unidomOrganizationDataService.selectUnidomOrganizationDataList(null);
        List<String> idList = new ArrayList<>();
        for (UnidomOrganizationData unidomOrganizationData : unidomOrganizationDataList) {
            idList.add(unidomOrganizationData.getId().toString());
        }
        return documentPlusService.syncBulkDelete(module.getModuleIndiceName(),module.getModuleIndiceName(), idList);
    }

    public int updateOrganization() {
        TUdsModuleDef module =  tUdsModuleDefService.selectTUdsModuleDefByCode("m_organization");
        // 查询所有的组织
        List<UnidomOrganizationData> unidomOrganizationDataList=unidomOrganizationDataService.selectUnidomOrganizationDataList(null);
        return documentPlusService.syncBulkUpdate(module.getModuleIndiceName(),module.getModuleIndiceName(), unidomOrganizationDataList);
    }

}
