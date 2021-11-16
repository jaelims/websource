<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="/delete.do" method="post">
	  <div class="form-group">
	    <label for="code">code</label>
	    <input type="text" class="form-control" id="code" placeholder="code" required="required" name="code">
	  </div>
	  <button type="submit" class="btn btn-primary">삭제</button>
</form>