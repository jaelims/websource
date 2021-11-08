<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<div style="margin-top: 20px">
	<form action="updateProcess.jsp" method="post">
		<div class="form-group">
			<label for="userid">userid</label> <input type="text"
				class="form-control" id="userid" placeholder="아이디" name="userid">
		</div>
		<div class="form-group">
			<label for="currentPassword">password</label> <input type="password"
				class="form-control" id="currentPassword" placeholder="현재 비밀번호"
				name="currentPassword">
		</div>
		<div class="form-group">
			<label for="changePassword">change password</label> <input
				type="password" class="form-control" id="changePassword"
				placeholder="변경 비밀번호" name="changePassword">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="/layout/footer.jsp"%>