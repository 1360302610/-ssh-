<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户登陆</title>
<link rel="stylesheet" href="css/style.css">
	<style type="text/css">
<!--
.STYLE1 {
	color: #0066FF;
	font-weight: bold;
}
-->
</style>
</head>

<body onLoad="document.forms[0]['username'].focus()" topmargin="0"
	leftmargin="0" bgcolor="#f3f3f3">
	<jsp:include page="MainHeader.jsp"></jsp:include>

<br/>
<form action="login" id="Form1" method="post">
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr width="100%">
			<td width="30%">&nbsp;</td>
			<td width="30%" height="300px">
				<table  style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#ffffff"
				 width="100%" height="99%" cellpadding="0" cellspacing="0" border="1">
					<tr width="20%">
						<td  colspan="2" align="center" style="font-size: 13pt;">博客登录</td>
					</tr>
					<tr width="20%">
						<td align="center" width="20%" style="font-size: 11pt;">用户名:</td>
						<td align="center" width="40%" ><input  style="height:50%;width:70%" type="text" name="username"/></td>
						
					</tr>
					<tr width="20%">
						<td align="center" align="center" width="20%" style="font-size: 11pt;">密码:</td>
						<td align="center" align="center" width="40%" ><input style="height:50%;width:70%" type="password" name="password"/></td>
						
					</tr>
					<tr width="20%">
						<td colspan="2" align="center" ><input style="font-size: 10pt;" type="submit" value="登录"/>
					&nbsp;&nbsp;<a href="www.baidu.com" style="font-size:11px;">忘记密码?</a>
						</td>
						
					</tr>
				</table>
			</td>
			<td width="1%">
				<span style="color: red"><s:actionerror/></span>
			</td>
			<td width="39%">
				<img src="image/login.jpeg" width="260px" height="300px"/>
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>
