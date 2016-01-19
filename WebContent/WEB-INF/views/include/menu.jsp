<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:choose>
	<c:when test="${ menu == 'defalut'}">
		기본설정
		&nbsp;&nbsp;
		
		<a class="title"
			href="${pageContext.request.contextPath}/category/list?menu=category&blogID=${blog.id }">
			카테고리
		</a>
		
		&nbsp;&nbsp;
		<a class="title" href="${pageContext.request.contextPath}/post/writeform?menu=write&blogID=${blog.id }"> 글작성</a>
	
	</c:when>
	<c:when test="${ param.menu eq 'category' || menu == 'category' }">
		<a class="title" href="${pageContext.request.contextPath}/blog/admin?blogID=${blog.id}"><b>기본설정</b> </a>
		&nbsp;&nbsp;
		<b>카테고리</b>
		&nbsp;&nbsp;	
		<a class="title" href="${pageContext.request.contextPath}/post/writeform?menu=write&blogID=${blog.id }"> 글작성</a>
		
		&nbsp;&nbsp;	
	</c:when>
	<c:when test="${ param.menu eq 'write' || menu == 'write' }">
		<a class="title" href="${pageContext.request.contextPath}/blog/admin?blogID=${blog.id}"><b>기본설정</b> </a>
		&nbsp;&nbsp;
		<a class="title"
			href="${pageContext.request.contextPath}/category/list?menu=category&blogID=${blog.id }">
			카테고리
		</a>
		&nbsp;&nbsp;
		<b>글작성</b>
		
		&nbsp;&nbsp;	
	</c:when>
</c:choose>
