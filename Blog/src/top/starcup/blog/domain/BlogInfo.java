package top.starcup.blog.domain;

import java.io.Serializable;

public class BlogInfo implements Serializable{

	private String username;
	private String blogtitle; //博客标题
	private String idiograph;//个性签名
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getIdiograph() {
		return idiograph;
	}
	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}
	
}
