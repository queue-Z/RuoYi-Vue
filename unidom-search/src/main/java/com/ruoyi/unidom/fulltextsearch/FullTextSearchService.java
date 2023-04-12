package com.ruoyi.unidom.fulltextsearch;

import com.ruoyi.unidom.common.response.PageResponse;
import com.ruoyi.unidom.common.util.DocumentPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.unidom.common.util.EsUtil;

@Service
public class FullTextSearchService {

    @Autowired
    DocumentPlusService docSv;

    @Autowired
    private EsUtil esUtil;

    public void fullTextSearch() {
//        PageResponse pageResult = docSv.search("listIndexName", null, ObjectNode.class, rootQueryBuilder, null, from, pageSize, null, null, null, listSortBuilder);

    }



}
