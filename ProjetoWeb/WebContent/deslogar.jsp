<%
	int pag = Integer.valueOf(request.getParameter("pag"));
	String idpassagem = request.getParameter("idpassagem");
	session.invalidate();
	if(pag == 2){
		response.sendRedirect("passagens.jsp");
		
	}
	
	if(pag == 1){
		response.sendRedirect("index.jsp");
	}

%>