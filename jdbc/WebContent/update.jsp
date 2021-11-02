<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/layout/header.jsp" %>
<div style="margin-top: 20px">
	<form action="" method="post">
	  <div class="form-group">
	    <label for="userid">userid</label>
	    <input type="text" class="form-control" id="userid" placeholder="아이디">
	  </div>
	  <div class="form-group">
	    <label for="password">password</label>
	    <input type="password" class="form-control" id="password" placeholder="현재 비밀번호">
	  </div>
	  <div class="form-group">
	    <label for="password">change password</label>
	    <input type="password" class="form-control" id="password" placeholder="변경 비밀번호">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file = "/layout/footer.jsp" %>