package top.starcup.blog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.starcup.blog.dao.BlogInfoDao;
import top.starcup.blog.domain.BlogInfo;

public class BlogInfoDaoImpl extends HibernateDaoSupport implements BlogInfoDao{

	public void saveOrUpdate(BlogInfo blogInfo) {
		this.getHibernateTemplate().saveOrUpdate(blogInfo);
		
	}

	public BlogInfo getBlogInfo(String username) {
		List list = this.getHibernateTemplate().find("from BlogInfo info where info.username=?",username);
		return list.size()!=0?(BlogInfo)list.get(0):null;
	}

}
