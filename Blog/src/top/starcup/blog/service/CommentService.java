package top.starcup.blog.service;

import java.util.List;

import top.starcup.blog.domain.Comment;

public interface CommentService {

	//根据文章id查询 该文章所有评论的总记录数
	int count(int aid);

	/**
	 * 分页查询该文章的所有评论
	 * @param id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	List<Comment> findAllCommentByAid(int aid, int currentPage, int pageSize);

	//添加评论
	void addComment(Comment comment);

}
