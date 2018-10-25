package top.starcup.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import top.starcup.blog.domain.Article;
import top.starcup.blog.domain.Comment;
import top.starcup.blog.domain.User;
import top.starcup.blog.service.ArticleService;
import top.starcup.blog.service.CommentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>{

	//实例化模型驱动
	private Comment comment=new Comment();;
	public Comment getModel() {
		return comment;
	}

	//依赖注入
	private CommentService commentService;
	public void setCommentService(CommentService commentService){
		this.commentService=commentService;
	}
	
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}



	public String addComment(){
		//判断用户是否处于登录状态
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("tip","错误");
			request.setAttribute("result","您还未登录！请先登录吧");
			request.setAttribute("url", request.getContextPath()+"/login.jsp");
			return "error";
		}
		//判断评论的内容长度是否符合要求
		String content = comment.getContent();
		String url = request.getHeader("REFERER");//获取上一个页面url
		if(content.trim().length()<10){
			request.setAttribute("tip","错误");
			request.setAttribute("result","评论内容长度必须大于10个字。");
			request.setAttribute("url", url);
			return "error";
		}
		comment.setName(user.getNickname());
		//评论时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comment.setTime(sdf.format(new Date()));
		
		//调用业务逻辑方法
		commentService.addComment(comment);
		//修改文章的评论数据
		Article article = articleService.findArticleById(comment.getAid());
		article.setCommentNum(article.getCommentNum()+1);
		articleService.addArticle(article);//更新
	
		request.setAttribute("tip", "温馨提示");
		request.setAttribute("result","评论发表成功!");
		request.setAttribute("url", url);
		return "success";
	}
}
