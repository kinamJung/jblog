<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 카테고리 관리</title>
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
      	<table width="720"  border="1" cellpadding="0" cellspacing="0">
      		<tr>
      			<td width="50" class="tablelabel">번호</td>
      			<td width="150" class="tablelabel">카테고리명</td>
      			<td width="70" class="tablelabel">포스트 수</td>
      			<td width="280" class="tablelabel">설명</td>
      			<td width="70" class="tablelabel">삭제</td>      			
      		</tr>
      		<c:forEach items="${categoryList }" var="category" varStatus="status">
      		<tr>
      			<td class="tablecontent" align="center">${status.index+1}</td>
      			<td class="tablecontent">${category.name }</td>
      			<c:set value="false" var="flag"></c:set>
      			<c:forEach items="${ postCountWithCategory}" var="postCount">
      				<c:if test="${postCount.categoryNo == category.no}">
      						<td class="tablecontent" align="center">${postCount.postCount}</td>
      						 <c:set value="true" var="flag"></c:set> 
      				</c:if>
      			</c:forEach>
      			 <c:if test="${ flag == false }">
      				<td class="tablecontent" align="center">0</td>
      				<c:set value="false" var="flag"></c:set>
      			</c:if> 
      			
      			<td width="280" class="tablelabel">${category.description}</td>
      			<td class="tablecontent" align="center">&nbsp;<img height="9" src="${pageContext.request.contextPath}/images/delete.jpg" border="0"></td>
      			</tr>
      		</c:forEach>
      						
      	</table>
      	
      	<form action="${pageContext.request.contextPath}/category/insert">
      		<input type="hidden" name="blogID" value="${blog.id }">
      		<table width="720"  border="0" cellpadding="0" cellspacing="0">
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td class="tdcontent" height="5"><b>새로운 카테고리 추가</b></td></tr>
      		<tr><td height="5">&nbsp;</td></tr>      		
      		<tr>
      			<td width="150" class="inputlabel">카테고리명 :</td>
      			<td><input class="inputtext" type="text" size="40" name="name" value=""></td>
      		</tr>
      		<tr>
      			<td width="150" class="inputlabel">설명 :</td>
      			<td><input class="inputtext" type="text" size="50" name="description" value=""></td>
      		</tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr>
      			<td colspan="10" align="center">&nbsp;<input type="submit" value="추가하기"></td>
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