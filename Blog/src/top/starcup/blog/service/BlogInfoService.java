package top.starcup.blog.service;

import top.starcup.blog.domain.BlogInfo;

public interface BlogInfoService {

	//保存个性化设置
	public void saveBlogInfo(BlogInfo blogInfo);

	//获取个性化的设置信息
	public BlogInfo getBlogInfo(String username);
}
