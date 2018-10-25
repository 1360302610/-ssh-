package top.starcup.blog.service.impl;

import top.starcup.blog.dao.BlogInfoDao;
import top.starcup.blog.domain.BlogInfo;
import top.starcup.blog.service.BlogInfoService;

public class BlogInfoServiceImpl implements BlogInfoService {

	//依赖注入
	private BlogInfoDao blogInfoDao;
	public void setBlogInfoDao(BlogInfoDao blogInfoDao) {
		this.blogInfoDao = blogInfoDao;
	}

	public void saveBlogInfo(BlogInfo blogInfo) {
		blogInfoDao.saveOrUpdate(blogInfo);
	}

	public BlogInfo getBlogInfo(String username) {
		return blogInfoDao.getBlogInfo(username);
	}

}
