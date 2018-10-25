package top.starcup.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import top.starcup.blog.domain.User;
import top.starcup.blog.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;

	public void setUserService(UserService userService){
		this.userService=userService;
	}
	private User user=new User();

	public User getModel() {
		return user;
	}
	
	
	public String register(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userService.registerUser(user)){
			request.setAttribute("url","login.jsp");
			request.setAttribute("result","注册成功了");
			request.setAttribute("tip", "温馨提示");
			return "success";
		}
		request.setAttribute("url","register.jsp");
		request.setAttribute("result","该账号已被注册了");
		request.setAttribute("tip", "错误 ");
		return "error";
	}
	
/*
	public void addFieldError(String fieldName, String errorMessage){
	    System.out.println(fieldName+"---"+errorMessage); 
	}*/
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User u=userService.login(user.getUsername(),user.getPassword());
		if(u!=null){
			//将用户放进session中
			request.getSession().setAttribute("user",u);
			request.setAttribute("url",request.getContextPath()+"/getBlogInfo");
			request.setAttribute("tip","温馨提示");
			request.setAttribute("result","您已经登录成功了！");
			return "success";
		}else{
			request.setAttribute("url","login.jsp");
			request.setAttribute("tip","错误");
			request.setAttribute("result","用户名或密码不匹配!");
			return "error";
		}
	}
	//注销
	public String userLogOut(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}

}
