
<%
String user = (String) session.getAttribute("username");
String admin = (String) session.getAttribute("admin");
if (user != null || admin != null) {
	session.invalidate();
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta name="viewport" content="with=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>




	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Hai fatto il logout con successo</h3>
				</div>

				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Per effettuare di nuovo il login
					</div>
					
						<a href="index.jsp" class="btn btn-info" role="button">Ritorna
							al Login</a>
					</p>

				</div>
			</div>
		</div>
	</div>


	</div>



</body>
</html>

<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>

