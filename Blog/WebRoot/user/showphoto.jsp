<%@ page language="java"  import="java.util.*"  pageEncoding="UTF-8"
    contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<title>相册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/image/style.css">
		
		<!-- 导入greybox开源框架 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/user/greybox/AJS_fx.js"></script>
		<script type="text/javascript">
		    var GB_ROOT_DIR = "${pageContext.request.contextPath}/user/greybox/";
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/user/greybox/AJS.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/user/greybox/gb_scripts.js"></script>
		<link href="${pageContext.request.contextPath }/user/greybox/gb_styles.css" rel="stylesheet" type="text/css">
	</HEAD>
	<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<jsp:include page="include/UserMainHeader.jsp"></jsp:include>
		<form action="photoUpload" method="post" enctype="multipart/form-data">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<TD>
						<div align="center">
						<s:fielderror></s:fielderror>
						<input type="file" name="photo">
						<input type="submit" value="上传图片"> 
						</div>
					</TD>
				</TR>
				<tr>
					<table cellspacing="5" align="center">
						<tr>
						<s:iterator value="#request.photoLists" id="photo" status="stu">
								<td>
								<a href='${pageContext.request.contextPath }/attached/${user.nickname }/<s:property value="photo"/>' title="我的相册" rel="gb_imageset[photos]">
									<img src='${pageContext.request.contextPath }/attached/${user.nickname }/<s:property value="photo"/>' style="width: 100%; height: auto;max-width: 100%; display: block;">
								</a>
								</td>
								<s:if test="(#stu.index + 1) % 5 == 0">
									</tr>
									<tr>
								</s:if>
						</s:iterator>
						</tr>
					</table>
				</tr>
				
			</TABLE>
		</form>
	</body>
</HTML>

