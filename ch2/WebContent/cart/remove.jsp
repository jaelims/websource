<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>장바구니 비우기</h3>
<%
	// 세션 값 삭제
	// session.removeAttribute("product");
	session.removeAttribute("cartList");
%>
<p>
	<a href="cart.jsp">상품 선택</a>
</p>
</body>
</html>