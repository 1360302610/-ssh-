<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>个性化设置</title>
<link rel="stylesheet" href="image/style.css" />
<style type="text/css">
<!--
.STYLE1 {
	color: #0000FF;
	font-weight: bold;
}
-->
</style>
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<jsp:include page="include/UserMainHeader.jsp"></jsp:include>
		
		<form id="Form1" action="addbloginfo" method="post">
			<table width="1000" cellpadding="0" cellspacing="0" border="0" align="center">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="300" valign="top"><img src="${pageContext.request.contextPath }/user/image/editbloginfo.png" height="200px"></td>
					<td width="20">&nbsp;</td>
					<td valign="top">
						<table width="500" border="1" cellpadding="0" cellspacing="0" style="background-color:#FFFFFF;BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse">
							<tr height="30">
								<td colspan="2" align="center" background="image/l-bg1.jpg"><span class="STYLE1">个性化设置</span></td>
							</tr>
							<tr height="40">
								<td align="center">博客标题</td>
								<td style="padding-left: 15px"><input name="blogtitle" type="text"/>*</td>
								<td><s:fielderror><s:param>blogtitle</s:param></s:fielderror></td>
							</tr>
							<tr height="40">
								<td align="center">个性签名</td>
								<td style="padding-left: 15px"><input name="idiograph" type="text" />*</td>
								<td ><s:fielderror><s:param>idiograph</s:param></s:fielderror></td>
							</tr>
							<tr height="40">
								<td colspan="2" align="center">
								<input type="submit" value="提交" name="submit" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置" name="reset" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

