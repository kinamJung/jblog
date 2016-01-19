<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<table
	background="${pageContext.request.contextPath}/images/kubrickheader.jpg"
	width="760" height="200" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="60">&nbsp;</td>
	</tr>
	<!-- 블로그 제목과 태그 시작 -->
	<tr>
		<td height="60" class="blogtitle">${blog.title}</td>
	</tr>
	<tr>
		<td height="20" class="blogtag">${blog.tags}</td>
	</tr>
	<!-- 블로그 제목과 태그 끝 -->
	<c:choose>
		<c:when test="${not empty user }">
			<tr>
				<td align="right" height="60"><a href="${pageContext.request.contextPath}/user/logout?blogId=${blog.id}">로그아웃</a>&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/blog/${user.id}">내 블로그 메인</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td></td>
			</tr>
		</c:otherwise>
	</c:choose>
	
</table>