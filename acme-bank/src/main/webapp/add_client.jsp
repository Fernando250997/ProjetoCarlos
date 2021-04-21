<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novo Cadastro</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
	
	<div style="width:400px;margin:0 auto;" >
		<h2>Novo Cadastro</h2>
		<br/>
		<c:if test="${msg != null}">
		   <div align="center"> <strong><p>${msg}</strong></p> </div>			
		</c:if>
		<br>
		<br>
		<form action="clientServlet" method="POST">
		    <c:if test="${edit==true}">
			  <input type="hidden" name="edit" value="true">
		    </c:if>	    
			
		    <div class="form-row">
			<label for="id">Id:</label>
			<input id="id" class="form-control" name="id" type="text" placeholder="id" value="${client.id}" readonly>
			</div>			
			
		    <div class="form-row">
			<label for="name">Name:</label>
			<input id="name" name="name" class="form-control" type="text" placeholder="name" value="${client.name}">
			</div>			
			
		    <div class="form-row">
			<label for="email">E-mail:</label>
			<input id="email" name="email" class="form-control" type="email" placeholder="email" value="${client.email}">
			</div>			
			
		    <div class="form-row">
			<label for="phone">Phone:</label>
			<input id="phone" name="phone" class="form-control" type="text" placeholder="phone" value="${client.phone}">
			</div>			
			
		    <div class="form-row">
			<label for="password">Password:</label>
			<input id="password" name="password" class="form-control" type="password" placeholder="password" value="${client.password}">
			</div>			
			<div class="form-row">
			<br>
			<input type="submit" value="Save" id="btn-Login">
			<button type="button" onclick="javascript:history.back()">Cancel</button>			
			</div>
		</form>
	</div>
	</div>
</body>
</html>