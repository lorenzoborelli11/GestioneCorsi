<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
	
		<div class="d-flex justify-content-center">
			<div class="card">
				<div class="card-header">
					<h3>Inserisci Utente</h3>
				</div>
				<div class="card-body">	
					<form id="corsistaForm"
     				 action="/<%=application.getServletContextName()%>/inserisci"
    				 method="post" class="form-horizontal">
    				 
    				 	<!-- NOME -->
    				 	<div class="input-inserisci">
						
						<input type="text" class="form-control" placeholder="Nome"
						name="nome" id="nome">	
						</div>
						<!-- FINE NOME -->
						
						<!-- COGNOME -->
						<div class="input-inserisci">
					
						<input type="text" class="form-control" placeholder="Cognome"
						name="cognome" id="cognome">	
						</div>
						<!-- FINE COGNOME -->
						
						<!-- CORSI -->
				 	<h5 style="color: white; margin-top:20px;">Elenco Corsi</h5>
					
					
					<div class="check-corsi">
						<label for="corso" style="color: white;">CORSO 1</label><br>
						<p style="color:white;">INIZIO</p>
						<p style="color:white;">FINE</p>
						<p style="color:white;">Aula</p>
						<p style="color:white;">Docente</p>
						<input type="checkbox" name="corso1" id="corso1" value="corso1">
					</div>
					
					<div class="check-corsi">
						<label for="corso" style="color: white;">CORSO 2</label><br>
						<p style="color:white;">INIZIO</p>
						<p style="color:white;">FINE</p>
						<p style="color:white;">Aula</p>
						<p style="color:white;">Docente</p>
						<input type="checkbox" name="corso2" id="corso2" value="corso2">
					</div>
					<!-- FINE CORSI -->
					
					<!-- COMMENTI -->
					<h5 style="color:white; margin-bottom:5px;">Inserisci un commento</h5>
					<textarea class="tarea" rows="5" cols="45" ></textarea>
					<!-- FINE COMMENTI -->
					
					<!-- PRECEDENTI FORMATIVI -->
					<div style="margin-top: 10px;" class="check-corsi">
						<label for="precedenti" style="color: white;">Precedenti formativi</label>
						<span style="color:white;">SI</span><input type="radio" name="precedenti" id="precedenti" value="si">
						<span style="color:white;">NO</span><input type="radio" name="precedenti" id="precedenti" value="no">
					</div>
					<!-- FINE PRECEDENTI FORMATIVI -->
					  <button style="margin-top: 10px;" type="submit" class="btn btn-warning">
         				   Registra
          			</button>
    				</form>
				</div>			
			</div>
		</div>
	</div>
	<jsp:include page="footer.html" />
</body>
</html>