package top.starcup.blog.domain;

import java.io.Serializable;

public class BlogInfo implements Serializable{

	private String username;
	private String blogtitle; //���ͱ���
	private String idiograph;//����ǩ��
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
