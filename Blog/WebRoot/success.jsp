<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
 <%-- <meta http-equiv="refresh" content='3; url=<%=request.getAttribute("url")%>'> --%>
<title>操作成功</title>
<link rel="stylesheet" href="image/style.css" />
<script type="text/javascript">
	/* onload=function(){
		setInterval(login,1000);
	};
	var x=4;
	function login(){
		x--;
		if(x>0){
			document.getElementById("sp").innerHTML=x;
		}else{
			location.href="${pageContext.request.contextPath}/login.jsp";
		}
	} */
	
</script>
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<form id="Form1" method="post">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="35%"><img src="${pageContext.request.contextPath }/image/success.gif"></td>
					<td width="5%">&nbsp;</td>
					<td valign="top">
						<table width="60%" border="1" cellpadding="0" cellspacing="0" style="BORDER-RIGHT:#cccccc 1px solid;BORDER-TOP:#cccccc 1px solid;BORDER-LEFT:#cccccc 1px solid;BORDER-BOTTOM:#cccccc 1px solid;BORDER-COLLAPSE:collapse;BACKGROUND-COLOR:#ffffff">
							<tr height="40">
								<td colspan="2" align="center" background="image/main/l-bg5.jpg"><font color="#7FFFD4" size="5"><b>${tip }</b></font></td>
							</tr>
							<tr height="180">
								<td align="center">${result }</td>
							</tr>
						</table>
					</td>
				</tr>
				<%
					//跳转
					String url=(String)request.getAttribute("url");
					response.setHeader("Refresh", "3,url="+url);
					
				 %>
			</table>
		</form>
		<br/>
		
	</body>
	
</html>
