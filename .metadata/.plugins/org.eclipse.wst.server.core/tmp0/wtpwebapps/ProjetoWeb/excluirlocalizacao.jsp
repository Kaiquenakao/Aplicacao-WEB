<%@page import="model.Localizacao"%>
<%@page import="model.Usuario"%>
<%
	int idlocalizacao = Integer.valueOf(request.getParameter("idlocalizacao"));
	String nivelusuario = (String) session.getAttribute("nivelusuario");
	int converte = new Usuario().convert(nivelusuario);
	
	if(converte == 2){
		Localizacao localizacao = new Localizacao();
		localizacao.setIdlocalizacao(idlocalizacao);
		localizacao.deleteLocalizacao();
		response.sendRedirect("adicionarlocalizacao.jsp");
	}
	//S� ADM pode excluir um usu�rio caso contr�rio � redirecionado para o index
	else{
		response.sendRedirect("index.jsp");
	}
%>