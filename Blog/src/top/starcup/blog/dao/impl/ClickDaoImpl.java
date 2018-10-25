package top.starcup.blog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.starcup.blog.dao.ClickDao;
import top.starcup.blog.domain.Click;

public class ClickDaoImpl extends HibernateDaoSupport implements ClickDao {

	public void addClick(Click click) {
		this.getHibernateTemplate().save(click);
	}

	public boolean findClickByAid(int aid, String ip, String clickTime) {
		List list = getHibernateTemplate().find("select c from Click c where c.aid=? and c.ip=? and c.clickTime=?", aid,ip,clickTime);
		if(list!=null && list.size()!=0){
			return true;
		}
		return false;
	}

}
