<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>User List</title>
	<Link rel="stylesheet" href="/css/theme.css">
</head>
<body>
 <table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td height=40 colspan="10">&nbsp;</td>
      </tr>
      <tr>
        <td width="100%" height="120"colspan="10" align="center">
        <img src="${pageContext.request.contextPath}/images/logo.jpg" border="0"></td>
      </tr>
     </table>

<h4 align="center">user count : ${userCount}</h4> <br>


<table border=1 width=600 align="center">
	<tr>
		<td>아이디</td><td>이름</td><td>가입일</td>
	</tr>
	<c:forEach items="${userlist}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.regDate}</td>
		</tr>
	</c:forEach>	
</table>
<center>
<br>
<br>
<form method="get" action="" >
<select name=searchKind>
	<option value="userId">아이디</option>
	<option value="userName">이름</option>
	<option value="idname">이름 || 아이디</option>
</select>
<input type=text name=searchStr size=20>
<input type=submit value=Search>
</form>
<br>
<a href="${pageContext.request.contextPath}/user/userRegisterForm">사용자등록</a><br>
<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
</center>
</body>
</html>