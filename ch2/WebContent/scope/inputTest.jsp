<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String username = request.getParameter("username");
	String userid = request.getParameter("userid");
	
	// request scope(유효번위)를 이용한 객체 담기
	request.setAttribute("username", username);
	request.setAttribute("userid", userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%= username %>님 반갑습니다. 당신의 아이디는 <%= userid %> 입니다.</h3>
	<form action="info.jsp" method="post">
		<div>
			<h3>Session 영역에 저장할 내용</h3>
		</div>
		<div>
			<label for="email">이메일</label>
			<input type="text" name="email" id="email" />
		</div>
		<div>
			<label for="address">주소</label>
			<input type="text" name="address" id="address" />
		</div>
		<div>
			<label for="tel">전화번호</label>
			<input type="text" name="tel" id="tel" />
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>