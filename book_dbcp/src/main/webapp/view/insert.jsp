<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="margin-top: 20px">
	<form action="/insert.do" method="post">
	  <div class="form-group">
	    <label for="code">code</label>
	    <input type="text" class="form-control" id="code" placeholder="code" required="required" name="code">
	  </div>
	  <div class="form-group">
	    <label for="title">title</label>
	    <input type="text" class="form-control" id="title" placeholder="title" required="required" name="title">
	  </div>
	  <div class="form-group">
	    <label for="writer">writer</label>
	    <input type="text" class="form-control" id="writer" placeholder="writer" required="required" name="writer">
	  </div>
	  <div class="form-group">
	    <label for="price">price</label>
	    <input type="text" class="form-control" id="price" placeholder="price" required="required" name="price">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
