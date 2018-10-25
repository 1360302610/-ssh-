package top.starcup.blog.utils;

import java.util.List;

import top.starcup.blog.domain.Article;

public class PageBean {

	private int currentPage; //当前页数
	private int pageSize;//每页显示多少数据
	
	private int count;//总的记录数
	private int totalPage;//总页数
	
	private List<Article> articles;//要查询的数据

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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
