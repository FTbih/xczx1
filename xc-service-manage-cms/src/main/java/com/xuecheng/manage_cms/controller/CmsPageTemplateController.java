package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageTemplateControllerApi;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.PageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cms/pageTemplate")
public class CmsPageTemplateController implements CmsPageTemplateControllerApi {

    @Autowired
    PageTemplateService pageTemplateService;

    @Override
    @GetMapping("/findAllPageTemplate")
    public QueryResponseResult findAllPageTemplate(){
        return pageTemplateService.findAllPageTemplate();
    }
}
