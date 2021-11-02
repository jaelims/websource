<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 값을 담은 후 sessionTest1 으로 되돌아가기
	session.setAttribute("name", "session Test");
	response.sendRedirect("sessionTest1.jsp");
%>