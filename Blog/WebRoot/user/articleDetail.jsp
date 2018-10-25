<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>我的文章</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/user/image/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/user/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/user/kindeditor/lang/zh-CN.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/user/kindeditor/themes/default/default.css"/>
	
</head>
<script type="text/javascript">
	//简单模式初始化
        var editor;
        KindEditor.ready(function(K) {
            editor = K.create('textarea[name="content"]', {
             filterMode:false,
                resizeType : 0,
                allowPreviewEmoticons : true,
                allowImageUpload : true,
                uploadJson : "${pageContext.request.contextPath}/user/kindeditor/jsp/upload_json.jsp",
				fileManagerJson : "${pageContext.request.contextPath}/user/kindeditor/jsp/file_manager_json.jsp",
				allowFileManager : true,
                items : [
                    'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                    'insertunorderedlist', '|', 'emoticons', 'image', 'link']
            });
            
        });
</script>
<style  type="text/css">
	.mya {
	font-size: 14px;
}

.mya:hover {
	color: #00EEEE;
	font-size: 14px;
}
</style>
<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
	<jsp:include page="include/UserMainHeader.jsp"></jsp:include>
	<table width="1000" border="0" cellpadding="0" cellspacing="0"
		align="center">
		<tr>
			<td width="722" valign="top">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr height="30" valign="bottom">
						<td class="title">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" valign="top">
							<table width="1000" cellpadding="4" cellspacing="1">
								<tr>
									<td>
										<table width="1000" cellpadding="6" cellspacing="1"
											bgcolor="#CCCCCC">

											<tr>
												<td bgcolor="#FFFFFF">
														<font size="5px">
															<s:property value="cpb.article.title" />
														</font>
														<hr size='1' noshade color='#CCCCCC'> <br>
														<div>
															<s:property value="cpb.article.content" escape="false" />
														</div> </td>
											</tr>
											<!-- 显示评论 -->
												<s:iterator value="cpb.comments" id="comment" status="status">
													<tr>
														<td height="20"></td>
													</tr>
													<tr>
													<td bgcolor="#FFFFFF">
														<p align="right"><s:property value="#status.index+1"/>楼</p>
														<font class="chinesefont105main">
														<s:property value="#comment.content" escape="false"/>
															<hr size='1' noshade color='#CCCCCC'> <br>
														<p align="right">评论人:<s:property value="#comment.name"/>&nbsp;&nbsp;评论于:<s:property value="#comment.time"/></p>
															 </font>
													</td>
													</tr>
												</s:iterator>
												<tr>
											<td align="center">
												<s:if test="cpb.totalPage!=0">
													<s:if test="cpb.currentPage>1">
													<a class="mya" href="showArticleDetail?id=${cpb.article.id}&currentPage=1">首页</a>
													<a class="mya" href="showArticleDetail?id=${cpb.article.id}&currentPage=${cpb.currentPage -1 }">上一页</a>
												</s:if>
												<s:else>
													首页
													上一页
												</s:else>
												 &nbsp; <s:if test="cpb.totalPage!=0">
													 第${cpb.currentPage }页/共${cpb.totalPage }页
												</s:if> &nbsp; 
												<s:if test="cpb.currentPage==cpb.totalPage || cpb.totalPage==0">
													下一页
													尾页
												</s:if>
												<s:else>
													<a class="mya" href="showArticleDetail?id=${cpb.article.id}&currentPage=${cpb.currentPage + 1 }">下一页</a>
													<a class="mya" href="showArticleDetail?id=${cpb.article.id}&currentPage=${cpb.totalPage }">尾页</a>			
												</s:else>
												</s:if>
											</td>
										</tr>
											</table>
											
											<form action="addComment" method="post">
			<input type="hidden" name="aid" value='${cpb.article.id }'/>
			<TABLE WIDTH="1000"  height="300" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
							<tr height="30">
								<td background="${pageContext.request.contextPath }/image/l-bg3.jpg">&nbsp;&nbsp;&nbsp;<font color="#76EEC6"><b>发表你的评论</b></font></td>
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;&nbsp;内容：
									<textarea name="content" style="width:800px;height:200px;"></textarea>
								</td>
							</tr>
							<tr height="20">
								<td>
									<input type="submit"  value="发表 " Style="ButtonCss" />
									<input type="reset" name="cancelButton" value="重置"  Class="ButtonCss">
								</td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
		</form>
							
										
										
							
							
							
							
										<table id="noCount" runat="server" width="1000"
											cellpadding="6" cellspacing="1" bgcolor="#cccccc">
											<tr bgcolor="#ffffff" height="50">
												
													<%-- <%
														String ref = request.getHeader("REFERER");
													%> <input
													type="button" id="backBtn" name="button"
													class="button_return" value="返回"
													onclick="javascript:window.location='<%=ref%>'"> --%>
													<input type="button" value="返回" class="button_return" onclick="javascript:history.back(-1);"/>
												<td align="center" style="font-size:15px;">${user.nickname}的博客</td>
											</tr>
										</table></td>
								</tr>
								<tr>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>