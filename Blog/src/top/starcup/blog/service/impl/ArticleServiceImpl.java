package top.starcup.blog.service.impl;

import java.util.List;

import top.starcup.blog.dao.ArticleDao;
import top.starcup.blog.dao.CommentDao;
import top.starcup.blog.domain.Article;
import top.starcup.blog.domain.Comment;
import top.starcup.blog.service.ArticleService;
import top.starcup.blog.service.CommentService;
import top.starcup.blog.utils.CommentPageBean;
import top.starcup.blog.utils.PageBean;

public class ArticleServiceImpl implements ArticleService{

	//依赖注入
	private ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public void addArticle(Article article) {
		articleDao.addArticle(article);
		
	}
	//注入评论Service
	private CommentService commentService;
	public void setCommentService(CommentService commentService){
		this.commentService=commentService;
	}


	public PageBean findArticlesPage(String username, int currentPage,
			int pageSize) {
		PageBean pb=new PageBean();
		int count=articleDao.count(username);//得到总记录数
		int totalPage=0; //计算总页数
		if(count!=0){
			totalPage=(int) Math.ceil((count*1.0/pageSize));
		}
		
		List<Article> lists=articleDao.findAllArticles(username,currentPage,pageSize);
		
		//封装PageBean
		pb.setCount(count);
		pb.setCurrentPage(currentPage);
		pb.setTotalPage(totalPage);
		pb.setArticles(lists);
		pb.setPageSize(pageSize);
		
		return pb;
	}

	public Article findArticleById(int id) {
		return articleDao.findArticleById(id);
	}

	public CommentPageBean findArticleAndShowCommentPage(int aid,
			int currentPage, int pageSize) {
		CommentPageBean cpb=new CommentPageBean();
		//得到该文章下的所有评论记录
		int count=commentService.count(aid);
		//计算总页数
		int totalPage=0;
		if(count!=0){
			totalPage=(int) Math.ceil((count*1.0/pageSize));
		}
		Article article = articleDao.findArticleById(aid);
		//得到该文章的所有评论
		List<Comment> comments=commentService.findAllCommentByAid(aid,currentPage,pageSize);
		
		//封装分页bean
		cpb.setArticle(article);
		cpb.setComments(comments);
		cpb.setCount(count);
		cpb.setCurrentPage(currentPage);
		cpb.setTotalPage(totalPage);
		cpb.setPageSize(pageSize);
		return cpb;
	}

}
