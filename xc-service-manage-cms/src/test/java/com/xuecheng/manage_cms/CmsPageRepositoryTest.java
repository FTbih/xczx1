package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.dao.CmsPageTemplateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    CmsPageTemplateRepository cmsPageTemplateRepository;

    @Test
    public void testFindPage(){
        List<CmsPage> all = cmsPageRepository.findAll();
        List<CmsTemplate> all1 = cmsPageTemplateRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testModify(){
        Optional<CmsPage> byId = cmsPageRepository.findById("5a754adf6abb500ad05688d9");
        if(byId.isPresent()){
            CmsPage cmsPage = byId.get();
            cmsPage.setPageName("郭晨曦");
            cmsPageRepository.save(cmsPage);
        }
    }

    @Test
    public void testCount(){
        CmsPage byPageName = cmsPageRepository.findByPageName("index2.html");
        int i = cmsPageRepository.countByPageType("1");
        System.out.println(i);
    }

    @Test
    public void testCondition(){
        ExampleMatcher matching = ExampleMatcher.matching();

        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("index.html");
        Example<CmsPage> e = Example.of(cmsPage, matching);
        Pageable pageRequest = new PageRequest(0, 10);
        Page<CmsPage> all = cmsPageRepository.findAll(e, pageRequest);
        System.out.println(all);


    }
}
