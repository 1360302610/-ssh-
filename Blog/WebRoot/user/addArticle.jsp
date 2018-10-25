<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<HTML>

<script type="text/javascript" src="${pageContext.request.contextPath }/user/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/user/kindeditor/lang/zh-CN.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/user/kindeditor/themes/default/default.css" />
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
	<HEAD>
		<title>发表新文章</title>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<link rel="stylesheet" href="image/style.css">
	</HEAD>
	<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<jsp:include page="include/UserMainHeader.jsp"></jsp:include>
		<form action="addArticle" method="post">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
						
						<br>
		
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
							<tr height="30">
								<td background="image/l-bg3.jpg">&nbsp;&nbsp;&nbsp;<font color="#ffff66"><b>发表新文章</b></font></td>
							</tr>
							<tr height="20">
								<td>
									&nbsp;&nbsp;&nbsp;标题：
									<div>
										&nbsp;&nbsp;&nbsp;<input type="text" name="title"  Width="600px" Style="inputcss" />
										<span style="color: red"><s:fielderror fieldName="title"/></span>
									</div>
								</td>
								
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;&nbsp;内容：
									
									<textarea id="content" name="content" style="width:800px;height:320px"></textarea>
									<span style="color: red"><s:fielderror fieldName="content"/></span>
								</td>
								
							</tr>
							<tr height="20">
								<td>
									<input type="submit"  value="发表" Style="ButtonCss" />
									<input type="button" name="cancelButton" value="取消" onClick="history.back()" Class="ButtonCss">
								</td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</HTML>

