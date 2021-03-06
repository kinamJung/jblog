<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 블로그 메인</title>
	<Link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css">
</head>
<body background="${pageContext.request.contextPath}/images/kubrickbgcolor.jpg">
<center>
<%-- 	<table background="${pageContext.request.contextPath}/images/kubrickheader.jpg"
		 width="760" height="200" border="0" cellpadding="0" cellspacing="0">
      <tr>	<td height="60">&nbsp;</td></tr>
      <!-- 블로그 제목과 태그 시작 -->
      <tr>	<td height="60" class="blogtitle">${blog.title}</td></tr>
      <tr>	<td height="20" class="blogtag">${blog.tags}</td></tr>
      <!-- 블로그 제목과 태그 끝 -->      
      <tr>	<td height="60">&nbsp;</td></tr>
    </table> --%>
	<c:import url="/WEB-INF/views/include/header.jsp"/>
    <table background="${pageContext.request.contextPath}/images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="10">&nbsp;</td></tr>
      <tr>
      	<td width="20">&nbsp;</td>
      	<td width="530" valign="top">
	      	<!-- 포스트 시작 -->
	      	<table height="10" border="0" cellpadding="0" cellspacing="0">
	      		<tr><td class="posttitle">JavaOne 컨퍼런스가 열립니다.</td></tr>
	      		<tr><td class="postdate">2006/06/06</td></tr>
	      		<tr><td class="postcontent"> 6월 27일부터 30일까지 샌프란시스코 모스콘센터에서 2005 JavaOneSM 컨퍼런스가 열립니다. 
	      		심도깊은 강의와 실생활에서의 혁신, 공상적인 관점에 이르기까지 Java의 강력함을 발견할 수 있습니다. 
	      		컨퍼런스에 참가하셔서 Java 탄생 10주년을 축하해주세요. 또한, 전세계의 전문가들, 혁신자들과 의견을 
	      		교환할 수 있는 좋은 기회가 될 것입니다.</td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr><td class="postwriter">posted by 관리자 in J2EE, 덧글 1</td></tr>
	      	</table>
	      	<!-- 포스트 끝-->      	
      	</td>
      	<td width="20">&nbsp;</td>
      	<td width="190" valign="top">
      	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 시작 -->
      	<table cellpadding="0" cellspacing="0">
      		<tr><td>
      		<c:choose>
      			<c:when test="${ empty user }">
      				<a href="${pageContext.request.contextPath}/blog/loginformInblog?blogID=${blog.id}">로그인</a>&nbsp;&nbsp;
      			</c:when> 
      			<c:otherwise>
      				<c:if test="${ blog.id eq user.id }">
      					<a href="${pageContext.request.contextPath}/blog/admin?&blogID=${blog.id}">블로그 관리</a></td></tr>
      				</c:if>
      			</c:otherwise>
      		</c:choose>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td><img height="80" src="${pageContext.request.contextPath}/images/j2eelogo.jpg" border="0"></td></tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td class="categorytitle">카테고리</td></tr>
      		<c:forEach items="${category}" var="cate">
      			<tr><td class="categoryitem"><a class="title" href="#">${cate.name}</a></td></tr>
      		</c:forEach>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td align="center"><img width="80" src="${pageContext.request.contextPath}/images/logo.jpg" border="0"></td></tr>
      	</table>
      	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 끝 -->
      	</td>
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