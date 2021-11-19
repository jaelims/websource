/**
 * qna_board_list.jsp
 */
$(function(){
	
	// 새글 작성을 클릭하면 actionForm 보내기
	// onclick="location.href='/view/qna_board_write.jsp'"
	$(".btn-success").click(function(){
		$("#actionForm").find("[name='bno']").remove();
		$("#actionForm").attr("action", "/view/qna_board_write.jsp");
		$("#actionForm").attr("method", "get");
		$("#actionForm").submit();
	})
	
	// 제목을 클릭하면 actionForm 보내기
	$(".count").click(function(e){
		e.preventDefault(); // a 태그 동작 막기
		
		let href = $(this).attr('href');
		
		$("#actionForm").find("[name='bno']").val(href);
		$("#actionForm").attr("action", "/countUpdate.do");
		$("#actionForm").submit();		
	})
	
	// 페이지 번호를 클릭하면 actionForm 보내기
	$(".move").click(function(e){
		e.preventDefault(); // a 태그 동작 막기
		
		let href = $(this).attr('href');
		
		$("#actionForm").find("[name='bno']").remove();
		$("#actionForm").find("[name='page']").val(href);
		$("#actionForm").attr("action", "/list.do");
		$("#actionForm").submit();		
	})

	// 검색어에서 엔터 치는 것 방지
	$(":text").keydown(function(e){
		if(e.keyCode == 13){
			e.preventDefault();
		}
	})	
	
	// 검색버튼을 누르면
	// 검색조건(criteria),검색어(keyword) 가져온 후
	// 내용이 안들어 있으면 메세지 띄우기
	$(".btn-primary").click(function(){
		let criteria=$("[name='criteria']");
		let keyword=$("[name='keyword']");
		
		if(criteria.val()=="n"){
			alert("검색 조건이 없습니다.");
			criteria.focus();
			return;
		}else if(keyword.val()==""){
			alert("검색할 내용을 입력해 주세요");
			keyword.focus();
			return;
		}
		$("#search").find("[name='page']").val("1");
		$("#search").submit();
	}) 
})