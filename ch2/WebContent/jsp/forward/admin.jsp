<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 다른 페이지로 특정 값을 넘기는 방법 : get/post
	 get : 주소줄에 따라가는 값이 보임
	 post : 보이지 않음
 --%>
	<p>
	<a href="adminPage.jsp?page=1&password=1234">관리자 페이지</a>
	</p>
	<form action="adminPage.jsp" method="post">
		<div>
			비밀번호 : <input type="password" name="password" />
			<input type="submit" value="전송" />
		</div>
	</form>
</body>
</html>