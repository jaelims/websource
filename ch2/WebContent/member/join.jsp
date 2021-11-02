<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="joinProcess.jsp" method="post">
<div>
	<p>
	<label for="userid">아이디</label>
	<input type="text" name="userid" id="userid" placeholder="아이디를 입력하세요"/>
	</p>
	<p>
	<label for="password">비밀번호</label>
	<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요"/>
	</p>
	<p>
	<label for="password2">비밀번호 확인</label>
	<input type="password" name="password2" id="password2" placeholder="비밀번호를 다시 입력하세요"/>
	</p>
	<p>
	<label for="name">이름</label>
	<input type="text" name="name" id="name" placeholder="이름을 입력하세요"/>
	</p>
	<p>
	<label for="gender">성별</label>
	<input type="radio" name="gender" id="gender" />남
	<input type="radio" name="gender" id="gender" />여
	</p>
	<p>
	<label for="email">이메일</label>
	<input type="text" name="email" id="email" placeholder="example@gamil.com"/>
	</p>
</div>
<div>
<button type="submit">입력</button>
<button type="reset">취소</button>
</div>
</form>
</body>
</html>