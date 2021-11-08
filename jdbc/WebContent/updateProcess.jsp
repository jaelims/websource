<%@page import="user.persistence.MemberDAO"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// update.jsp에서 넘긴 값 가져오기
MemberDTO dto = new MemberDTO();
dto.setUserid(request.getParameter("userid"));
dto.setPassword(request.getParameter("currentPassword"));
dto.setChangePassword(request.getParameter("changePassword"));

// db작업
Connection con = JdbcUtil.getConnection();
MemberDAO dao = new MemberDAO(con);
boolean updateFlag = dao.update(dto);

// 페이지 이동
if(updateFlag){
	JdbcUtil.commit(con);
	response.sendRedirect("allProcess.jsp");
} else{
	JdbcUtil.rollback(con);
	response.sendRedirect("update.jsp");
}
%>