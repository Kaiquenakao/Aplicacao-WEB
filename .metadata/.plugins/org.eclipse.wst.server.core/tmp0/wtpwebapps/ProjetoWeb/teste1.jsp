<%
	String nome = (String) session.getAttribute("nome");
	out.print(nome);
	if(nome == null){
		response.sendRedirect("index.jsp");
	}
		
%>

<a href="deslogar.jsp">Deslogar</a>