package top.starcup.blog.service;

import java.util.List;

import top.starcup.blog.domain.Article;
import top.starcup.blog.utils.CommentPageBean;
import top.starcup.blog.utils.PageBean;

public interface ArticleService {

	//添加新博客
	public void addArticle(Article article);

	//分页查询
	public PageBean findArticlesPage(String nickname, int currentPage,
			int pageSize);

	//查询文章详情
	public Article findArticleById(int id);

	//分页查询该文章的所有评论
	public CommentPageBean findArticleAndShowCommentPage(int aid,
			int currentPage, int pageSize);
}
