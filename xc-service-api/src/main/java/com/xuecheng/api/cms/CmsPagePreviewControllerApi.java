package com.xuecheng.api.cms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms页面预览接口", description = "提供页面预览功能")
public interface CmsPagePreviewControllerApi {
    @ApiOperation("页面预览")
    public void preview(String pageId);
}
