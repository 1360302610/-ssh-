package top.starcup.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import top.starcup.blog.domain.BlogInfo;
import top.starcup.blog.domain.User;
import top.starcup.blog.service.BlogInfoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BlogInfoAction extends ActionSupport implements ModelDriven<BlogInfo>{

	//依赖注入
	private BlogInfoService blogInfoService;
	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	private BlogInfo blogInfo=new BlogInfo();
	public BlogInfo getModel() {
		return blogInfo;
	}

	public String addbloginfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user!=null){
			blogInfo.setUsername(user.getUsername());
			blogInfoService.saveBlogInfo(blogInfo);
			return "success";
		}
		request.setAttribute("tip","错误");
		request.setAttribute("result","您还未登录，请先登录吧!");
		request.setAttribute("url",request.getContextPath()+"/login.jsp");
		return "error";
	}
	
	public String getBlogInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null){
			BlogInfo blogInfo=blogInfoService.getBlogInfo(user.getUsername());
			if(blogInfo!=null){
				request.getSession().setAttribute("blogtitle",blogInfo.getBlogtitle());
				request.getSession().setAttribute("idiograph", blogInfo.getIdiograph());
			}
		}
		return "success";
	}
	
}
