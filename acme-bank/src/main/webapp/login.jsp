<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login/Cadastro</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<body>
	<div style="width:400px;margin:0 auto;" >
		<h2>Login/Cadastro </h2>
		<br/>
		<form action="loginServlet" method="POST">
			<div class="form-row">
			<br>
				<label for="email">E-mail:</label>
				<input id="email"class="form-control" name="email" type="email" placeholder="e-mail" >
			</div>
			<div class="form-row">
			<br>
				<label for="password">Password:</label>
				<input id="password"class="form-control" name="password" type="password" placeholder="password" >
			</div>
			<div class="form-row">
			<br>
				<input type="submit" value="Login" id="btn-Login">
			</div>			
			<div class="form-row">
			<br>
			<h5>Não possui cadastro?</h5>
  				<a href="add_client.jsp">Cadastrar</a>
			</div>
		</form>
	</div>
</body>
</html>