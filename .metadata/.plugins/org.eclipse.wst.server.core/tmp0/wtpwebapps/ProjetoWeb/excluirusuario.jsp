<%@page import="model.Usuario"%>
<%
	int idusuario = Integer.valueOf(request.getParameter("idusuario"));
	String nivelusuario = (String) session.getAttribute("nivelusuario");
	int converte = new Usuario().convert(nivelusuario);
	
	if(converte == 2){
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idusuario);
		usuario.deleteUsuario();
		response.sendRedirect("usuariomenu.jsp");
	}else{
		response.sendRedirect("index.jsp");
	}
%>