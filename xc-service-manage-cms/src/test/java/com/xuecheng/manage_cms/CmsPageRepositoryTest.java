package com.xuecheng.manage_cms;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.dao.CmsPageSiteRepository;
import com.xuecheng.manage_cms.dao.CmsPageTemplateRepository;
import com.xuecheng.manage_cms.service.PageService;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    CmsPageTemplateRepository cmsPageTemplateRepository;

    @Autowired
    CmsPageSiteRepository cmsPageSiteRepository;

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

    @Test
    public void testPageSite(){
        List<CmsSite> all = cmsPageSiteRepository.findAll();
        System.out.println(all);
    }

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRestTemplate(){
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getModel/5a791725dd573c3574ee333f", Map.class);

        System.out.println(forEntity);
    }

    //测试gridFS文件存储

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @Test
    public void testGridFS() throws FileNotFoundException {
        File file = new File("E:\\course.ftl");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "course.ftl");
        System.out.println(objectId.toString());
    }

    //测试gridFS文件取出
    @Test
    public void queryFile() throws IOException {
        String fileId = "5f47bd1480e0702240224b74";
        GridFSFile id = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(id.getObjectId());
        GridFsResource gridFsResource = new GridFsResource(id, gridFSDownloadStream);
        String s = IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");
        System.out.println(s);
    }

    @Autowired
    PageService pageService;

    @Test
    public void testFreeMarker(){
        String pageHtml = pageService.getPageHtml("5f467afc80e07022e4e05527");
        System.out.println(pageHtml);
    }

}
