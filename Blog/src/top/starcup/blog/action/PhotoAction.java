package top.starcup.blog.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import top.starcup.blog.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PhotoAction extends ActionSupport {
	
	private File photo;//上传文件的字段
	private String photoFileName;//文件名称
	private String photoContentType;//文件类型
	public  void  setPhoto(File  photo){
		this.photo=photo;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	
	public String upload(){
		//获取该用户的Session信息
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//指定存放文件的目录
		String fileDir = ServletActionContext.getServletContext().getRealPath("/attached/"+user.getNickname());
		File file=new File(fileDir);
		if(!file.isDirectory()){
			file.mkdir();
		}
		//获取文件扩展名
		String extension = FilenameUtils.getExtension(photoFileName);
		photoFileName=UUID.randomUUID().toString()+"."+extension;
		//上传
		if(photo!=null){
			photo.renameTo(new File(file, photoFileName));//剪切文件
		}
		return "success";
	}

	public String showPhoto(){
		
		//判断用户是否处于登录状态
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("tip", "错误");
			request.setAttribute("result","您还未登录!");
			request.setAttribute("url", "login.jsp");
			return "error";
		}
		//图片的路径
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/attached/"+user.getNickname());
		File file=new File(realPath);
		if(file.exists()){
			String[] photoLists = file.list();
			request.setAttribute("photoLists", photoLists);
		}
		return "success";
	}
}
