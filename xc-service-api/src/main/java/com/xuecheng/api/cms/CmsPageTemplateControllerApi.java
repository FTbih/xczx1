package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms页面模板管理接口", description = "cms页面模板管理接口,提供页面模板的增删改查")
public interface CmsPageTemplateControllerApi {

    @ApiOperation("查询页面模板列表")
    public QueryResponseResult findAllPageTemplate();




}
