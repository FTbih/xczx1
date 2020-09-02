package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    /**
     * 根据页面名称查询
     * @param PageName
     * @return
     */
    CmsPage findByPageName(String pageName);

    int countByPageType(String s);

    CmsPage findByPageNameAndPageWebPathAndSiteId(String pageName, String pageWebPath, String siteId);


}
