package top.starcup.blog.service;

import top.starcup.blog.domain.BlogInfo;

public interface BlogInfoService {

	//������Ի�����
	public void saveBlogInfo(BlogInfo blogInfo);

	//��ȡ���Ի���������Ϣ
	public BlogInfo getBlogInfo(String username);
}
