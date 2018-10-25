package top.starcup.blog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
/**
 * 不拦截编辑器的图片地址
 * @author wu
 *
 */
public class KindeditorUrlFilter extends StrutsPrepareAndExecuteFilter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//不过滤的url
		HttpServletRequest request=(HttpServletRequest) req;
		String url = request.getServletPath();
		if("/user/kindeditor/jsp/file_manager_json.jsp".equals(url)){
			chain.doFilter(req, res);
		}else if("/user/kindeditor/jsp/upload_json.jsp".equals(url)){
			chain.doFilter(req, res);
		}else{
			super.doFilter(req, res, chain);
			//使用默认的拦截器
		}
	}
}
