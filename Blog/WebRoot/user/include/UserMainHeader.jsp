<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<script language="javascript">
function mhEnter()
{
window.event.srcElement.className="lt1";
}
function mhLeave()
{
window.event.srcElement.className="lt0";
}

</script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/user/image/style.css"/>
<style type="text/css">

.blogtitle {
	font-size: 18px;
	font-weight: bold;
}
.idiograph {
	position: relative;
	left: 50px;
}
	.mya{
		font-size:14px;
	}

</style>
</head>

<body>
<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td background="${pageContext.request.contextPath }/user/image/bg1.jpg" height="150">
		<!-- 博客标题位置-->
		<span class="blogtitle">${sessionScope.blogtitle}</span><br />
	  <span class="idiograph">${sessionScope.idiograph}     </span>		<!-- 个性签名位置-->		</td>
	</tr>
	<tr height="31">
		<td background="${pageContext.request.contextPath }/user/image/line.jpg">
			<table width="1000" border="0" cellpadding="0" cellspacing="0">
				<tr height="20" align="center">
					<td width="17%">&nbsp;</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya" href="${pageContext.request.contextPath }/showAllArticle?flag=<%=Math.random() %>">博客首页</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya" href="${pageContext.request.contextPath }/showAllArticle">用户首页</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya"  href="${pageContext.request.contextPath }/register.jsp">新博客注册</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya" href="${pageContext.request.contextPath }/user/editbloginfo.jsp">个性化设置</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya" href="${pageContext.request.contextPath }/user/addArticle.jsp">写博客</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya" href="${pageContext.request.contextPath }/showPhoto">相册</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a class="mya" href="${pageContext.request.contextPath }/userLogOut">注销</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>

