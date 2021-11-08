<%@page import="user.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<%
	MemberDTO dto1 = (MemberDTO) request.getAttribute("dto1");
%>
<div style="margin-top: 20px">
	<form action="" method="post">
		<div class="form-group">
			<label for="userid">userid</label> <input type="text"
				class="form-control" id="userid" placeholder="아이디"
				required="required" name="userid" value="<%=dto1.getUserid()%>"
				readonly>
		</div>
		<div class="form-group" style="display: none">
			<label for="password">password</label> <input type="password"
				class="form-control" id="password" placeholder="현재 비밀번호"
				required="required" name="password">
		</div>
		<div class="form-group">
			<label for="name">name</label> <input type="text"
				class="form-control" id="name" placeholder="이름" required="required"
				name="name" value="<%=dto1.getName()%>" readonly>
		</div>
		<div class="form-group">
			<label for="gender">gender</label> <input type="text"
				class="form-control" id="gender" placeholder="성별"
				required="required" name="gender" value="<%=dto1.getGender()%>"
				readonly>
		</div>
		<div class="form-group">
			<label for="email">email</label> <input type="email"
				class="form-control" id="email" placeholder="이메일"
				required="required" name="email" value="<%=dto1.getEmail()%>"
				readonly>
		</div>
		<button type="submit" class="btn btn-primary">탈퇴</button>
	</form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script>
$(function(){
	$("button").click(function(e){
		e.preventDefault();
		
		// password 영역을 보여주기
		let divPwd = $("form div:nth-child(2)");
		
		if(divPwd.css("display") == "none"){
			divPwd.css("display","block");
		} else{
			// 비밀번호를 입력하지 않으면 경고창을 띄우기
			let input = divPwd.children("input");
			if(input.val() == ""){
				alert("비밀번호를 입력해 주세요");
			// 비밀번호란에 포커스 지정
				input.focus();
				return;
			}
			// 폼 전송
			$("form").attr("action", "removeProcess.jsp");
			$("form").submit();
		}
	})
})
</script>
<%@ include file="/layout/footer.jsp"%>