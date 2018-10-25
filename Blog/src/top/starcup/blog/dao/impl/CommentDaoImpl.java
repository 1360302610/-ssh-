package top.starcup.blog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.starcup.blog.dao.CommentDao;
import top.starcup.blog.domain.Comment;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao{

	public int getCountByAid(int aid) {
		List list = this.getHibernateTemplate().find("select count(*) from Comment c  where c.aid=?", aid);
		if(list!=null && list.size()>0){
			return ((Long)list.get(0)).intValue();
		}
		return 0;
	}

	public List<Comment> findAllCommentsByAid(final int aid, final int currentPage,
			final int pageSize) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery("select c from Comment c where c.aid=? order by c.time ");
				query.setParameter(0, aid);
				//设置每页显示多少数据
				query.setMaxResults(pageSize);
				//设置从哪里开始查询
				query.setFirstResult((currentPage-1)*pageSize);
				return query.list();
			}
		});
	}

	public void addComment(Comment comment) {
		this.getHibernateTemplate().save(comment);
	}

	
}
