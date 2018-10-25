package top.starcup.blog.service;

import top.starcup.blog.domain.Click;

public interface ClickService {

	//添加当天该ip的谋篇文章的点击记录
	public void addClick(Click click);
	//该ip在谋篇文章当天是否点击过
	public boolean isClick(int aid,String ip,String clickTime);
}
