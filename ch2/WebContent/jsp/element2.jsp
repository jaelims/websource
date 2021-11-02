<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 1~100 합계
	int total = 0;
	for(int i=0;i<=100;i++){
		total+=i;
	}
	out.print("<h3>"+total+"</h3>");
%>
<h3><%= total %></h3>
</body>
</html>