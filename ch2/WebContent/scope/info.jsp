<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	
	// request scope에 담은 객체 가져오기
	String username= (String)request.getAttribute("username");
	String userid= (String)request.getAttribute("userid");
	
	// form에 담긴 값 가져오기
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String tel = request.getParameter("tel");
	
	// session scope를 이용한 객체 담기
	session.setAttribute("email", email);
	session.setAttribute("address", address);
	session.setAttribute("tel", tel);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%= username %>님 반갑습니다. 당신의 아이디는 <%= userid %> 입니다.</h3>
<p>
	email : <%= email %>
</p>
<p>
	address : <%= address %>
</p>
<p>
	tel : <%= tel %>
</p>
<p><a href="result.jsp">세션 값 확인</a></p>
</body>
</html>