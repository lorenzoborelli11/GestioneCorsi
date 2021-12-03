
<%
	String user = (String) session.getAttribute("username");
	String admin = (String) session.getAttribute("admin");
if (user != null || admin !=null) {
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
	<div class="panel panel-danger">
		<div class="panel heading">
			<h3>Hai appena effettuato il logout</h3>
		</div>

		<div class="panel-body">
			<p>Per effettuare di nuovo il login effetuare il login</p>
			<p>
				<a href="index.jsp">Login >></a>
		</div>
	</div>

</body>
</html>

<%
	} else {
response.sendRedirect("accessonegato.jsp");
}
%>

