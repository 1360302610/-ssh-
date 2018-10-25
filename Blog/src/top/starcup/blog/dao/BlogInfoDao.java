package top.starcup.blog.dao;

import top.starcup.blog.domain.BlogInfo;

public interface BlogInfoDao {

	//保存BlogInfo
	public void saveOrUpdate(BlogInfo blogInfo);

	//获取BlogInfo信息
	public BlogInfo getBlogInfo(String username);
}
