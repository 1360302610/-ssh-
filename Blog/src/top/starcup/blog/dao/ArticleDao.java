package top.starcup.blog.dao;

import java.util.List;

import top.starcup.blog.domain.Article;

public interface ArticleDao {

	//添加新文章
	public void addArticle(Article article);

	//查询总记录数
	public int count(String nickname);

	//分页查询该用户的所有文章
	public List<Article> findAllArticles(String nickname, int currentPage,
			int pageSize);

	public Article findArticleById(int id);
	
}
