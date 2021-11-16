<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/search.do" method="post">
	<div class="form-row">
		<div class="form-group col-6">
			<select name="criteria" id="" class="form-control">
				<option value="code">코드</option>
				<option value="writer">저자</option>
			</select>
		</div>
		<div class="form-group col-6">
			<input type="text" class="form-control" id="keyword"
				placeholder="keyword" required="required" name="keyword">
		</div>
	</div>
	<button type="submit" class="btn btn-primary">검색</button>
</form>