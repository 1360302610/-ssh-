package top.starcup.blog.domain;
/**
 * 文章点击封装类
 * @author wu
 *
 */
public class Click {

	private Integer id;
	private Integer aid;
	private String ip;
	private String clickTime;
	
	public Click(){}
	public Click(Integer aid, String ip, String clickTime) {
		super();
		this.aid = aid;
		this.ip = ip;
		this.clickTime = clickTime;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getClickTime() {
		return clickTime;
	}
	public void setClickTime(String clickTime) {
		this.clickTime = clickTime;
	}
	
	
	
	
}
