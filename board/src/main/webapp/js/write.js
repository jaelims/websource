/**
 * qna_board_write.jsp 스크립트
 */
$(function(){
	$("#list").click(function(){
		// location.href='/list.do';
		$("#actionForm").attr("action", "/list.do");
		$("#actionForm").submit();	
	})
})