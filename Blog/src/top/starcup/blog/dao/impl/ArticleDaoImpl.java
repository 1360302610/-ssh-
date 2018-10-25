package top.starcup.blog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.starcup.blog.dao.ArticleDao;
import top.starcup.blog.domain.Article;

public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {

	public void addArticle(Article article) {
		getHibernateTemplate().saveOrUpdate(article);
	}



	public int count(String nickname) {
		List lists=null;
		if("".equals(nickname) || nickname==null){
			lists= this.getHibernateTemplate().find("select count(*) from Article");
		}else{
			lists=this.getHibernateTemplate().find("select count(*) from Article a where a.nickname=?",nickname);
		}
		if(lists!=null && lists.size()>0){
			return ((Long)lists.get(0)).intValue();
		}else{
			return 0;
		}
	}

	public List<Article> findAllArticles(final String nickname, final int currentPage,
			final int pageSize) {

		if("".equals(nickname) || nickname==null){
			return this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery("select a from Article a  order by a.date desc");
					//设置参数
					query.setMaxResults(pageSize); //设置每页显示多少数据
					query.setFirstResult((currentPage-1)*pageSize);//从哪里开始查询
					return query.list();
				}
			});
		}else{
			return this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery("select a from Article a where a.nickname=? order by a.date desc");
					//设置参数
					query.setParameter(0, nickname);
					query.setMaxResults(pageSize); //设置每页显示多少数据
					query.setFirstResult((currentPage-1)*pageSize);//从哪里开始查询
					return query.list();
				}
			});
		}
	}



	public Article findArticleById(int id) {
		List lists = this.getHibernateTemplate().find("select a from Article a where a.id=?", id);
		if(lists!=null && lists.size()>0){
			return (Article) lists.get(0);
		}
		return null;
	}

}
