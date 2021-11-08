<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// select.jsp에서 넘긴 값 가져오기
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));
	
	// db작업
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	MemberDTO dto1 = dao.getRow(dto);
	
	JdbcUtil.close(con);
	
	// 페이지 이동
	if(dto1!=null){
		request.setAttribute("dto1", dto1);
		pageContext.forward("getMember.jsp");
	} else{
		response.sendRedirect("select.jsp");
	}

%>