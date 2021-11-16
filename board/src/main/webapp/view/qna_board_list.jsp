<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">List Board</h3>
		</div>
		<div class="row">
			<div class="col-md-4">
				<!--글쓰기 버튼-->
				<button type="button" class="btn btn-success" onclick="location.href='/view/qna_board_write.jsp'">새글작성</button>
			</div>
			<div class="col-md-4 offset-md-4"><!--검색 들어갈 부분-->
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class='text-center' style='width:100px'>번호</th>
				<th class='text-center'>제목</th>
				<th class='text-center'>작성자</th>
				<th class='text-center'>날짜</th>
				<th class='text-center' style='width:100px'>조회수</th>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr><!-- 리스트 목록 보여주기 -->
					<td class='text-center'>${dto.bno}</td><!--번호-->
					<td><a href="/countUpdate.do?bno=${dto.bno}">${dto.title}</a></td><!--제목-->
					<td class='text-center'>${dto.name}</td><!--작성자-->
					<td class='text-center'>${dto.regdate}</td><!--날짜-->
					<td class='text-center'><span class="badge badge-pill badge-primary">${dto.readcount}</span></td>
				</tr>
			</c:forEach>	
		</table>
		<div class="container">
			<div class="row  justify-content-md-center">
				<nav aria-label="Page navigation example">
				  <ul class="pagination"><!--하단의 페이지 나누기 부분-->

				  </ul>
				</nav>					
			</div>
		</div>
		<div style="height:20px"></div>
	</div>	
</section>
<%@include file="../include/footer.jsp"%>
