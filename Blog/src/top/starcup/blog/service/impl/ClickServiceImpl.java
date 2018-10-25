package top.starcup.blog.service.impl;

import top.starcup.blog.dao.ClickDao;
import top.starcup.blog.domain.Click;
import top.starcup.blog.service.ClickService;

public class ClickServiceImpl implements ClickService {

	//依赖注入
	private ClickDao clickDao;
	public void setClickDao(ClickDao clickDao){
		this.clickDao=clickDao;
	}
	public void addClick(Click click) {
		clickDao.addClick(click);
	}

	public boolean isClick(int aid, String ip, String clickTime) {
		return clickDao.findClickByAid(aid, ip, clickTime);
	}

}
