package com.ruoyi.unidom.test.service;

import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.unidom.indices.domain.TUdsIndiceConf;
import com.ruoyi.unidom.indices.service.ITUdsIndiceConfService;
import com.ruoyi.unidom.indices.service.ITUdsModuleDefService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleServiceTest {

    @Autowired
    private ITUdsModuleDefService moduleDefService;
    @Autowired
    private ISysPostService sysPostService;

    @Autowired
    private ITUdsIndiceConfService indiceConfService;

    @Test
    public void test() {
//        TUdsModuleDef moduleDef = new TUdsModuleDef();
//        moduleDef.setId(1L);
//
//        System.out.println(moduleDefService.selectTUdsModuleDefById(2L));

        System.out.println(sysPostService.selectPostById(1L));

    }

    @Test
    public void testIndiceConf(){
        System.out.println(indiceConfService.selectTUdsIndiceConfList(new TUdsIndiceConf()));
    }
}
