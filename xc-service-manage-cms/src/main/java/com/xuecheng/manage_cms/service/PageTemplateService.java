package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageTemplateService {

    @Autowired
    CmsPageTemplateRepository cmsPageTemplateRepository;

    public QueryResponseResult findAllPageTemplate(){
        List<CmsTemplate> all = cmsPageTemplateRepository.findAll();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

}
