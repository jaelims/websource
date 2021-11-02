<%@page import="user.domain.UserDTO"%>
<%@page import="user.persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// user가 보는 페이지 아님
	// index.jsp에서 로그인 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");

	// 데이터베이스 작업 후 원하는 페이지로 이동
	UserDAO dao = new UserDAO();
	
	// 로그인 성공 후 userid, name 이 담긴 객체를 받게 됨
	UserDTO loginDto = dao.isLogin(userid, password);
	
	if(loginDto != null){
		// 세션객체에 값 담기(모든 페이지에서 세션 값을 사용할 수 있음)
		session.setAttribute("loginDto", loginDto);
		// 페이지 이동 sendRedirect() or forward() 결정
		response.sendRedirect("board.jsp");
	} else{
		response.sendRedirect("/index.jsp");
	}
%>
