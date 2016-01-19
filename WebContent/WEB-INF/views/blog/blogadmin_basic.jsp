<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 기본정보 관리</title>
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
      	<form action="${pageContext.request.contextPath}/blog/update">
      	<input type="hidden" name="id" value="${blog.id }" >
      	<table width="720"  border="0" cellpadding="0" cellspacing="0">
      		<tr>
      			<td width="150" class="inputlabel">블로그 제목 :</td>
      			<td><input class="inputtext" type="text" size="40" name="title" value="${blog.title }"></td>
      		</tr>
      		<tr>
      			<td width="150" class="inputlabel">블로그 태그 :</td>
      			<td><input class="inputtext" type="text" size="50" name="tags" value="${blog.tags }" ></td>
      		</tr>
      		<tr>
      			<td width="150" class="inputlabel">메인페이지 포스트  :</td>
      			<td><input class="inputtext" type="text" size="4" name="cntDisplayPost"></td>      			
      		</tr>
      		<tr>
      			<td width="150" class="inputlabel">로고이미지  :</td>
      			<td>&nbsp;<img height="80" src="${pageContext.request.contextPath}/images/j2eelogo.jpg" border="0"></td>      			
      		</tr>      		
      		<tr>
      			<td width="150" class="inputlabel">&nbsp;</td>
      			<td><input class="inputtext" type="text" size="40" name="logoFile">
      			<input type="submit" value="찾아보기"></td>      			
      		</tr>    
      		<tr>
      			<td colspan="2" align="center">&nbsp;
      			<input  type="submit" value="확인">
      			</td>
      		</tr>       		
      	</table>
      	</form>     	
      	
      	<!-- 작업 화면  끝 -->           	      	
      	</td>
      </tr>
      <tr>
      	<td height="10" colspan="10">&nbsp;
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