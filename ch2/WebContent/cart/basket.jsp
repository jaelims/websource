<%@page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
</head>
<body>
<h3>장바구니 보기</h3>
<%
	// 세션에 담긴 장바구니 가져와서 화면 출력
	// String product=(String)session.getAttribute("product");

	ArrayList<String> cartList = (ArrayList<String>) session.getAttribute("cartList");
%>
<p>
	<%=cartList %>
</p>
<p>
	<a href="remove.jsp">장바구니 비우기</a>
</p>
</body>
</html>