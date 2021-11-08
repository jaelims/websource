<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	<!-- <a href="/insert.do?no=10">삽입</a> -->
</p>
<form action="/login.do" method="post">
	<div>
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid"/>
	</div>
	<div>
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password"/>
	</div>
	<div>
		<button type="submit">보내기</button>
	</div>
</form>
</body>
</html>