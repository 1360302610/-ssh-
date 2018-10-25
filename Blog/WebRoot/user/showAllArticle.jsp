<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的全部文章</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/image/style.css" />

<script type="text/javascript" src="${pageContext.request.contextPath }/user/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/user/kindeditor/lang/zh-CN.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/user/kindeditor/themes/default/default.css"/>
</head>
<style type="text/css">
.mya {
	font-size: 14px;
}

.mya:hover {
	color: #00EEEE;
	font-size: 14px;
}

.myTitle {
	font-size: 15px;
}
</style>

<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
	<jsp:include page="include/UserMainHeader.jsp"></jsp:include>
	<table width="1000" border="0" cellpadding="0" cellspacing="0"
		align="center">
		<tr height="30" valign="bottom">
			<td class="title">&nbsp;&nbsp;我的全部文章</td>
		</tr>
		<tr>
			<td colspan="2" valign="top">
				<table cellpadding="4" cellspacing="1">
					<tr>
						<td>
							<table width="1000" cellpadding="6" cellspacing="1"
								bgcolor="#CCCCCC">

								<!-- 循环输出 -->
								<s:iterator value="pb.articles" id="art">
									<tr>
										<td bgcolor="#FFFFFF"><font class="chinesefont105main">
												<!-- 文章标题  --> <a class="myTitle"
												href="showArticleDetail?id=<s:property value='#art.id'/>"><s:property
														value="#art.title" />
											</a>
												<hr size='1' noshade color='#CCCCCC'> <br>
												<div align='right' class='smalltxt' height='32px'>
													<!-- 发表时间 -->
													发表于:
													<s:property value="#art.date" />
													<!-- 评论与点击数 -->
													|评论(
													<s:property value="#art.commentNum" />
													)|点击(
													<s:property value="#art.clickNum" />
													)&nbsp;&nbsp;
													作者:<s:property value="#art.nickname" />
													
												</div> </font></td>
									</tr>
								</s:iterator>
								<tr>
									<td align="center"><s:if test="pb.currentPage>1">
											<a class="mya"
												href="showAllArticle?flag=${flag }&currentPage=1" style="">首页</a>
											<a class="mya"
												href="showAllArticle?flag=${flag }&currentPage=${pb.currentPage -1 }">上一页</a>
										</s:if> <s:else>
													首页
													上一页
												</s:else> &nbsp; <s:if test="pb.totalPage!=0">
													 第${pb.currentPage }页/共${pb.totalPage }页
												</s:if> &nbsp; <s:if
											test="pb.currentPage==pb.totalPage || pb.totalPage==0">
													下一页
													尾页
												</s:if> <s:else>
											<a class="mya"
												href="showAllArticle?flag=${flag }&currentPage=${pb.currentPage + 1 }">下一页</a>
											<a class="mya"
												href="showAllArticle?flag=${flag }&currentPage=${pb.totalPage }">尾页</a>
										</s:else></td>
								</tr>
							</table>
							<table id="noCount" runat="server" width="1000" cellpadding="6"
								cellspacing="1" bgcolor="#cccccc">
								<tr bgcolor="#ffffff" height="50">
									<td align="center" style="font-size: 15px;">
										${user.nickname}的博客</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>