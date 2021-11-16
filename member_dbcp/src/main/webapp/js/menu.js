/**
 * 로그인시 보여줄 메뉴 작성
 */
$(function(){
	// register 메뉴 제거
	$("#2").detach();
	
	// login 메뉴 제거
	$("#3").detach();
	
	// ~~~님 반갑습니다. 비밀번호수정 로그아웃 회원탈퇴 버튼 생성
	let tag = "<span class = 'navbar-text'>"+name+" 님 반갑습니다.</span>&nbsp;&nbsp;";
	tag += " <button type='button' id='modify' class='btn btn-success'>비밀번호수정</button>&nbsp;&nbsp;";
	tag += " <button type='button' id='logout' class='btn btn-primary'>로그아웃</button>&nbsp;&nbsp;";
	tag += " <button type='button' id='leave' class='btn btn-danger'>회원탈퇴</button>";
	
	$("#navbarCollapse").append(tag);
	
})