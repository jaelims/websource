<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>main 페이지</h1>
<%
	// 세션객체에 특정 값을 담기
	session.setAttribute("name", "hong");
	session.setAttribute("userid", "hong123");
%>
<div>
	<a href="section1.jsp">섹션 1 페이지</a>
</div>
<div>
	<a href="user.jsp">user 페이지</a>
</div>
<div>
	<a href="session1.jsp">세션 페이지</a>
</div>
</body>
</html>