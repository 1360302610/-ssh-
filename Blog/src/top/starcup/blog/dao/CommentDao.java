package top.starcup.blog.dao;

import java.util.List;

import top.starcup.blog.domain.Comment;

public interface CommentDao {

	//根据文章id查询该评论的总记录数
	int getCountByAid(int aid);
	//根据文章id查询出它 所有的评论，并分页显示
	List<Comment> findAllCommentsByAid(int aid, int currentPage, int pageSize);
	//添加评论
	void addComment(Comment comment);

}
