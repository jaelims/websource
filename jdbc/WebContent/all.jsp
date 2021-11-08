<%@page import="user.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/layout/header.jsp" %>
<%
	List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");
%>
<%-- 회원 전체 조회 --%>
<table class="table" style="margin-top: 20px">
  <thead class="thead-light">
    <tr>
      <th scope="col">userid</th>
      <th scope="col">name</th>
      <th scope="col">gender</th>
      <th scope="col">email</th>
    </tr>
  </thead>
  <tbody>
  <% 
  	if(!list.isEmpty()){
  		for(MemberDTO dto:list){ %>
		    <tr>
		      <th scope="row"><%=dto.getUserid() %></th>
		      <td><%=dto.getName() %></td>
		      <td><%=dto.getGender() %></td>
		      <td><%=dto.getEmail() %></td>
		    </tr>
    <% }
  	} else{
  		out.print("<tr>");
  		out.print("<td colspan='4'>");
  		out.print("내용 없음");
  		out.print("</td></tr>");
  	}
  	%>
  </tbody>
</table>
<%@ include file = "/layout/footer.jsp" %>