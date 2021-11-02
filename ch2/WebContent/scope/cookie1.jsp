<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 생성 후 저장
	Cookie name = new Cookie("name", "John");
	name.setMaxAge(600);
	response.addCookie(name);
	response.addCookie(new Cookie("gender", "Male"));
	response.addCookie(new Cookie("age", "30"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 데이터 저장</h3>
	<div>
		<a href="getCookie1.jsp">쿠키 확인</a>
	</div>
</body>
</html>