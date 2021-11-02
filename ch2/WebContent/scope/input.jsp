<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="inputTest.jsp" method="post">
	<div>
		<label for="username">이름</label>
		<input type="text" name="username" id="username" />
	</div>
	<div>
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid" />
	</div>
	<div>
		<button type="submit">전송</button>
	</div>
</form>
</body>
</html>