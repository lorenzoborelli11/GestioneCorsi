<%
	String admin = (String) session.getAttribute("admin");
if (admin != null) {
%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GestioneCorsiPD</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="statistica.jsp">Statistiche</a></li>
      <li><a href="inserisci.jsp">Aggiungi</a></li>
      <li><a href="ListaCorsisti.jsp">Lista corsisti</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a> <span class="glyphicon glyphicon-Log-in"></span><%=admin%>
      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<%
	} else {
response.sendRedirect("accessonegato.jsp");
}
%>