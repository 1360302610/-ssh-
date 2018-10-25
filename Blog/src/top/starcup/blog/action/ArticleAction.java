package top.starcup.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import top.starcup.blog.domain.Article;
import top.starcup.blog.domain.Click;
import top.starcup.blog.domain.User;
import top.starcup.blog.service.ArticleService;
import top.starcup.blog.service.ClickService;
import top.starcup.blog.utils.CommentPageBean;
import top.starcup.blog.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>{

	//依赖注入
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	private ClickService clickService;
	public void setClickService(ClickService clickService){
		this.clickService=clickService;
	}
	private Article article=new Article();
	//模型驱动
	public Article getModel() {
		return article;
	}
	
	public String addArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//判断用户是否登录状态
		User user=(User)request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("tip","错误");
			request.setAttribute("result","您还未登录！请先登录吧");
			request.setAttribute("url", request.getContextPath()+"/login.jsp");
			return "error";
		}
		article.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		article.setNickname(user.getNickname());
		articleService.addArticle(article);
		
		request.setAttribute("tip","温馨提示");
		request.setAttribute("result","文章发表成功!");
		request.setAttribute("url",request.getContextPath()+"/showAllArticle");
		return "success";
		
	}
	

	
	//文章详情  ,并分页显示该文章的所有评论
	public String showArticleDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String sid = request.getParameter("id");
		int id=0;
		if(sid!=null && !"".equals(sid)){
			id=Integer.valueOf(sid);
		}
		//查询谋篇文章
		Article article=articleService.findArticleById(id);
		//查询文章在当天该ip下是否点击过了
		
		String ip=request.getRemoteAddr();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String clickTime = sdf.format(new Date());
		boolean b = clickService.isClick(id, ip,clickTime );
		if(!b){
			//若没 点击过，则加1
			article.setClickNum(article.getClickNum()+1);
			Click c=new Click(id, ip, clickTime);
			clickService.addClick(c);
			articleService.addArticle(article);
		}
		//ActionContext.getContext().getValueStack().set("article",article);
		//当前页
		int currentPage=1;
		String curPage=request.getParameter("currentPage");
		if(curPage!=null && !"".equals(curPage)){
			currentPage=Integer.valueOf(curPage);
		}
		//每页显示的数据
		int pageSize=4;
		CommentPageBean cpb=articleService.findArticleAndShowCommentPage(id,currentPage,pageSize);
		ActionContext.getContext().getValueStack().set("cpb", cpb);
		return "success";
		
	}
	
	//分页显示所有文章
	public String showAllArticle(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("tip","错误");
			request.setAttribute("result","您还未登录！请先登录吧");
			request.setAttribute("url", request.getContextPath()+"/login.jsp");
			return "error";
		}
		
		int currentPage=1;
		//获取当前页
		String curPage = ServletActionContext.getRequest().getParameter("currentPage");//一开始可能为空
		if(curPage!=null && !"".equals(curPage)){
			currentPage=Integer.valueOf(curPage);
		}
		//定义每页显示多少数据
		int pageSize=4;
		//判断是显示所有文章，还是只显示该用户的文章
		String flag = request.getParameter("flag");
		PageBean pb=null;
		if(flag!=null && !"".equals(flag)){
			pageSize=8;
			pb=articleService.findArticlesPage("",currentPage,pageSize);
		}else{
			pb=articleService.findArticlesPage(user.getNickname(),currentPage,pageSize);
		}
		ActionContext.getContext().getValueStack().set("pb", pb);
		request.setAttribute("flag",flag);//将标识设置回去
		return "success";
		
	}

}
