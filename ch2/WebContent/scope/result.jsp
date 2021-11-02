<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션 값 확인</h2>
<p>
	email : <%= session.getAttribute("email") %>
</p>
<p>
	address : <%= session.getAttribute("address") %>
</p>
<p>
	tel : <%= session.getAttribute("tel") %>
</p>
</body>
</html>