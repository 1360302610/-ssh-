package top.starcup.blog.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.starcup.blog.dao.CommentDao;
import top.starcup.blog.domain.Comment;
import top.starcup.blog.service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	//注入
	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao){
		this.commentDao=commentDao;
	}
	public int count(int aid) {
		return commentDao.getCountByAid(aid);
	}
	public List<Comment> findAllCommentByAid(int aid, int currentPage,
			int pageSize) {
		return commentDao.findAllCommentsByAid(aid,currentPage,pageSize);
	}
	public void addComment(Comment comment) {
		commentDao.addComment(comment);
		
	}
}
