package top.starcup.blog.utils;

import java.util.List;

import top.starcup.blog.domain.Article;
import top.starcup.blog.domain.Comment;

public class CommentPageBean {

	private int currentPage;//当前页
	private int pageSize;//每页显示多少条数据
	private int count;//总记录数
	private int totalPage;//总页数
	
	//要显示的数据
	
	private Article article;
	private List<Comment> comments;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
