package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.*;

@Api(value = "cms页面管理接口", description = "cms页面管理接口,提供页面的增删改查")
public interface CmsPageControllerApi {
    /**
     * 分页查询列表
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value="页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value="每页显示条数", required = true, paramType = "path", dataType = "int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("添加页面")
    public CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("修改页面")
    public ResponseResult edit(String id,CmsPage cmsPage);

    @ApiOperation("根据id查询页面")
    public CmsPage getById(String id);

    @ApiOperation("根据id删除页面")
    public ResponseResult delById(String id);

    @ApiOperation("发布页面")
    public ResponseResult post(String pageId);

    @ApiOperation(" 保存页面")
    public CmsPageResult save(CmsPage cmsPage);

}
