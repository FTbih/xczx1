package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageSiteControllerApi;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.PageSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/pageSite")
public class CmsPageSiteController implements CmsPageSiteControllerApi {

    @Autowired
    PageSiteService pageSiteService;

    @Override
    @GetMapping("/findAllPageSite")
    public QueryResponseResult findAllPageSite() {
        return pageSiteService.findAllSite();
    }
    {
        
    }
    
}
