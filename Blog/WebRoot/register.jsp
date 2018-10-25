<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>博客注册</title>
	<link rel="stylesheet" href="css/style.css">
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<jsp:include page="MainHeader.jsp"></jsp:include>
		<form id="Form1" action="register" method="post">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="80">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="30%" valign="top"><img src="image/register.gif"></td>
					<td width="30">&nbsp;</td>
					<td valign="top">
						<table width="65%" border="1" cellpadding="0" cellspacing="0" style="background-color:#FFFFFF;BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse">
							<tr height="35">
								<td colspan="3" align="center" background="image/main/l-bg1.jpg"><font color="#ffff66"><b>新博客注册</b></font></td>
							</tr>
							<tr height="35">
								<td align="right" width="160">帐号&nbsp;</td>
								<td><input type="text" name="username"/>*</td>
								<td><s:fielderror fieldName="username"/></td>
							</tr>
							<tr height="35">
								<td align="right">密码&nbsp;</td>
								<td><input type="password" name="password"/>*</td>
								<td><s:fielderror fieldName="password"/></td>
							</tr>
							<tr height="35">
								<td align="right">确认密码&nbsp;</td>
								<td><input type="password" name="repwd"/>*</td>
								<td><s:fielderror fieldName="repwd"/></td>
							</tr>
							<tr height="35">
								<td align="right">昵称&nbsp;</td>
								<td><input type="text" name="nickname"/>*</td>
								<td><s:fielderror fieldName="nickname"/></td>
							</tr>
							<tr height="35">
								<td align="right">密码保护问题&nbsp;</td>
								<td>
									<select name="question">
										<option value="你的生日">你的生日</option>
										<option value="你的家乡">你的家乡</option>
										<option value="你最喜欢的食物">你最喜欢的食物</option>
									</select>*
								</td>
								<td><s:fielderror fieldName="question"></s:fielderror></td>
							</tr>
							<tr height="35">
								<td align="right">密码保护的答案&nbsp;</td>
								<td><input type="text" name="answer"/>*</td>
								<td><s:fielderror fieldName="answer"/></td>
							</tr>
							<tr height="35">
								<td colspan="2" align="center">
									<input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" value="重置"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

