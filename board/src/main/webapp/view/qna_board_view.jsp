<%@page import="board.domain.BoardDTO"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Read Board</h3>
		</div>
		<div style="height:20px"></div>
		<form action="" method="post">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10">
						<input type="text" name="name" size="10" class="form-control" maxlength='10' value="${readDto.name}" readonly>
					</div>
				</div>
				<div class="form-group  row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value="${readDto.title}" readonly>
					</div>
				</div>
				<div class="form-group  row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15' readonly>${readDto.content}</textarea>
					</div>
				</div>
				<div class="form-group  row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
					<%
					BoardDTO dto = (BoardDTO)request.getAttribute("readDto");
					String attachFullName = dto.getAttach();
					
					if(attachFullName!=null){
						String attachName = URLEncoder.encode(attachFullName,"utf-8");
						out.print("<a href='/view/download.jsp?fileName="+attachName+"'>");
						out.print(attachFullName);
						out.print("</a>");
					}
					%>
					</div>
				</div>
				<div style="height:10px"></div>
				<div class="box-footer text-center">
					<button type="button" class="btn btn-success" id="reply">답변</button>
					<button type="button" class="btn btn-warning" id="modify">수정</button>
					<button type="button" class="btn btn-danger" id="delete">삭제</button>
					<button type="button" class="btn btn-primary" id="list">목록보기</button>
				</div>
				<div style="height:20px"></div>
			</div>
		</form>
	</div>
</section>
<form action="" method="post" role="form">
	<input type="hidden" name="page" value="${pageDto.page}"/>
	<input type="hidden" name="amount" value="${pageDto.amount}"/>
	<input type="hidden" name="criteria" value="${pageDto.searchDto.criteria}"/>
	<input type="hidden" name="keyword" value="${pageDto.searchDto.keyword}"/>
	<input type="hidden" name="bno" value="${readDto.bno}"/>
</form>
<script src="/js/view.js"></script>
<%@include file="../include/footer.jsp"%>
