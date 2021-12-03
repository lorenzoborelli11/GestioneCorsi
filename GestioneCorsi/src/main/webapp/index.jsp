
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Login</h3>
			</div>
			<div class="card-body">
				<form action="/<%=application.getServletContextName()%>/login"
				method="post" class="form-horizontal">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" name="nomeadmin" class="form-control" placeholder="nome...">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="codadmin" class="form-control" placeholder="codice...">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Ricordati
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Non hai un account?<a href="#">Scrivi a pdbeta@fake.com</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="#">Non hai la password?</a>
				</div>
			</div>
		</div>
	</div>
</div>



</body>
</html>
