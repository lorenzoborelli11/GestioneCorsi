<%@page import="com.padova.bc.AdminFacade"%>
<%@page import="com.padova.architecture.model.Corsista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<jsp:include page="nav.jsp" />
<title>Gestione corsisti</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h3>Lista di tutti i corsisti</h3>
		</div>


		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>codice</th>
						<th>Cognome</th>
						<th>Nome</th>
						<th>Elimina</th>
					</tr>
				</thead>
				<%
				Corsista[] c = AdminFacade.getInstance().getCorsisti();
				System.out.println("dati:" + c);
				/* 	if (c.length > 0) */
				System.out.println("c!=null" + c.length);
				for (int i = 0; i < c.length; i++) {
				%>
				<tbody>
					<tr class="table-active">
					</tr>
					<tr>
					</tr>
					<tr>
						<td scope="row"><%=c[i].getCodCorsista()%></td>
						<td class="table-active"><%=c[i].getCognomeCorsista()%></td>
						<td class="table-active"><%=c[i].getNomeCorsista()%></td>
						<td>
							<form
								action="/<%=application.getServletContextName()%>/rimuoviCorsista "
								method="post">
								<input type="hidden" name="id"
									value="<%=c[i].getCodCorsista()%>">
								<button type="submit" class="btn btn-primary btn">Elimina</button>
							</form>
						</td>

					</tr>

				</tbody>
				<%
				}
				%>



			</table>
			<%
			if (c.length == 0) {
			%>

			<div class="alert alert-info" role="alert">
				<h4 class="alert-heading">Non ci sono corsisti</h4>
				<p>Assicurati di essere connesso a internet.</p>
				<hr>
				<p class="mb-0"><a class="btn btn-primary" href="ListaCorsisti.jsp">Ricarica la pagina</a></p>
			</div>
			<%
			}
			%>
		</div>



	</div>
</body>
</html>