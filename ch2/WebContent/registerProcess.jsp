<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.print(request.getParameter("userid"));

	// db 작업 결과 화면에 기록
	// 사용가능 ture / 사용불가 false
	out.print("true");


%>