<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta name="viewport" content="with=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Accesso Negato</title>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Login</h3>
				<h3>Credenziali errate!</h3>

				<div class="panel panel-danger">
					<div class="panel-heading">
						<h5>Risorsa non disponibile</h5>
					</div>
				</div>
				<div class="panel-body" style="color: white">
					<p>Chiedi all'amministratore: <a href="#">pdbeta@fake.com</a></p>
					<p>Oppure effettua il Login: <a href="login.jsp">Login</a></p>
					<input type="button" onclick="javascript:window.history.back();"
						class="btn btn-default" value="Torna indietro">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>