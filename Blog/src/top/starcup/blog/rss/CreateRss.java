package top.starcup.blog.rss;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import top.starcup.blog.domain.Article;

public class CreateRss {

	public  static void publicRss(List<Article> articles,String fileName){
		
		try {
			FileWriter fw=new FileWriter(fileName);
			//缓冲流
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("<?xml version=\"1.0\" encoding=\"gbk\"?>\r\n");
			bw.write("<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\"\r\n");
			bw.write("xmlns:cf=\"http://www.microsoft.com/schemas/rss/core/2005\"\r\n");
			bw.write("xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\r\n");
			bw.write("xmlns:trackback=\"http://madskills.com/public/xml/rss/module/trackback/\"\r\n");
			bw.write("xmlns:wfw=\"http://wellformedweb.org/CommentAPI/\"\r\n");
			bw.write("xmlns:slash=\"http://purl.org/rss/1.0/modules/slash/\"\r\n>");
			
			bw.write("<channel>\r\n");
			bw.write("<title>我的博客</title>\r\n");
			bw.write("<link>http://localhost:8080/Blog/login.jsp</link>\r\n");
			bw.write("<description>基于ssh编写的博客了解一下</description>\r\n");
			
			for(Article art : articles) {
				bw.write("<item>\r\n");
				bw.write("<title>" + art.getTitle()+"</title>\r\n");
				bw.write("<link>http://localhost:8080/Blog/user/showAllArticle.action?id = " + art.getId() + "</link>\r\n");
				bw.write("<description>" + art.getContent() + "</description>\r\n");
				bw.write("<author>" + art.getNickname() + "</author>\r\n");
				bw.write("<pubDate>" + art.getDate() + "</pubDate>\r\n");
				bw.write("</item>\r\n");
			}
			
			bw.write("</channel>\r\n");
			bw.write("</rss>\r\n");
			
			//关流
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
