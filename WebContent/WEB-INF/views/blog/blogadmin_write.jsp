<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 글 작성</title>
	<Link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css">
</head>
<body background="${pageContext.request.contextPath}/images/kubrickbgcolor.jpg">
<center>
<c:import url="/WEB-INF/views/include/header.jsp"/>
    <table background="${pageContext.request.contextPath}/images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="10" colspan="10">&nbsp;</td></tr>
      <tr>
      	<td height="10" width="20">&nbsp;</td>
      	<td width="530" valign="top" class="tdcontent">
      	<!-- 메뉴 시작 -->     
		<c:import url="/WEB-INF/views/include/menu.jsp"/>
      	<!-- 메뉴 끝 -->           	
      	</td>
      </tr>
      <tr><td height="5">&nbsp;</td></tr>
      <tr>
      	<td height="10">&nbsp;</td>
      	<td>
      	<!-- 작업 화면  시작 -->          
      	
      	<form action="${pageContext.request.contextPath}/post/write">
      		<input type="hidden" name="blogID" value="${blog.id }">
	      	<table width="720"  border="0" cellpadding="0" cellspacing="0">
	      		<tr>
	      			<td width="50" class="inputlabel">제목 :</td>
	      			<td width="390"><input class="inputtext" type="text" size="60" name="title"></td>
	      			<td width="300">
	      			<select class="inputtextarea" name="categoryNo">
	      				<c:forEach items="${category}" var="cg">
	      					<option value="${cg.no }">${cg.name }</option>
	      				</c:forEach>
	      			</select></td>
	      		</tr>
	      		<tr>
	      			<td width="50" class="inputlabel">내용 :</td>
	      			<td colspan="10"><textarea name="content" class="inputtextarea" rows="10" cols="100"></textarea></td>
	      		</tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr>
	      			<td colspan="10" align="center">&nbsp;<input type="submit" value="확인"></td>
	      		</tr>
	      	</table>
	      	</form> 	
      	
      	<!-- 작업 화면  끝 -->           	      	
      	</td>
      </tr>
      <tr>
      	<td height="10" colspan="10">&nbsp;</td>
      </tr>
    </table>
    <table background="${pageContext.request.contextPath}/images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td class="blogfooter">J2EE 이야기 is powered by JBlog</td>
      </tr>
	</table>
</center>
   	
</body>
</html>