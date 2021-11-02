<%@page import="user.domain.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   // 세션에 담긴 값 가져오기
   UserDTO loginDto=(UserDTO)session.getAttribute("loginDto");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board 페이지</h1>
<h2><%= loginDto.getName() %>님 반갑습니다.</h2>
</body>
</html>