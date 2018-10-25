package top.starcup.blog.dao;

import java.util.List;

import top.starcup.blog.domain.Click;

public interface ClickDao {

	//添加谋篇文章点击记录
	public void addClick(Click click);
	//查询谋篇文章该IP条件下当天是否被点击过
	public boolean findClickByAid(int aid,String ip,String clickTime);
}
