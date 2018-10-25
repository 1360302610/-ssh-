package top.starcup.blog.domain;

public class Comment {

	private Integer id;
	private String name;

	private Integer aid;
	private String content;
	private String time;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
