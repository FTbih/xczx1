package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms页面站点管理接口", description = "cms页面站点管理接口,提供页面站点的增删改查")
public interface CmsPageSiteControllerApi {

    @ApiOperation("查询页面站点列表")
    public QueryResponseResult findAllPageSite();




}
