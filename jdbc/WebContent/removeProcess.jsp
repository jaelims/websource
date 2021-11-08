<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자의 입력값 가져오기 아이디랑 비밀번호
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	// db작업
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	boolean deleteFlag = dao.delete(userid, password);
	
	// 페이지 이동
	if(deleteFlag){
		JdbcUtil.commit(con);
		JdbcUtil.close(con);
		response.sendRedirect("allProcess.jsp");
	} else{
		JdbcUtil.rollback(con);
		JdbcUtil.close(con);
		response.sendRedirect("selectProcess.jsp");
	}
%>