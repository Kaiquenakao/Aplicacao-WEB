/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2021-07-24 16:25:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Usuario;
import model.Passagem;
import model.LinhaAerea;

public final class adicionarlocalizacao_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.Usuario");
    _jspx_imports_classes.add("model.Passagem");
    _jspx_imports_classes.add("model.LinhaAerea");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		String nivelusuario = (String) session.getAttribute("nivelusuario");
		int converte = new Usuario().convert(nivelusuario);
		if(converte == 2){
	
      out.write("\r\n");
      out.write("<html lang=\"pt\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/design.css\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/design.css\">\r\n");
      out.write(" \t<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("  \r\n");
      out.write("    <title>Adicionar localizacao</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid px-0\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-12 col-lg-12 center\">\r\n");
      out.write("\t\t\t\t<img src=\"img/menuadm.jpg\" class=\"img-fluid\" id=\"menuadm\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"row mt-2 ml-2\">\r\n");
      out.write("\t\t\t<div class=\"col-8 col-lg-9 justify-content-between \">\r\n");
      out.write("\t             <a href=\"index.jsp\">\r\n");
      out.write("\t\t\t    \t<button type=\"button\" class=\"btn btn-primary\">Voltar</button>\r\n");
      out.write("\t\t\t    </a>\r\n");
      out.write("\t\t\t </div>  \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t<div class=\"col-1 col-lg-1 mt-2 ml-2\">\r\n");
      out.write("\t\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t  <a class=\"btn btn-secondary dropdown-toggle\" href=\"#\" role=\"button\" id=\"dropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t   ADM\r\n");
      out.write("\t\t\t\t  </a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t  <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuLink\">\r\n");
      out.write("\t\t\t\t    <a class=\"dropdown-item\" href=\"adicionarlocalizacao.jsp\">Adicionar Localização</a>\r\n");
      out.write("\t\t\t\t    <a class=\"dropdown-item\" href=\"adicionarpassagem.jsp\">Adicionar Passagem</a>\r\n");
      out.write("\t\t\t\t    <a class=\"dropdown-item\" href=\"adicionarlinha.jsp\">Adicionar Companhia Aérea</a>\r\n");
      out.write("\t\t\t\t    <a class=\"dropdown-item\" href=\"usuariomenu.jsp\">Menu Usuário</a>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row justify-content-center mt-2\">\r\n");
      out.write("\t\t\t<div class=\"col-3 col-lg-3 text-center h2\">\r\n");
      out.write("\t\t\t\tMenu Administrador\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"row justify-content-center mt-4\">\r\n");
      out.write("\t\t\t<div class=\"col-6 col-lg-3 text-center h2\">\r\n");
      out.write("\t\t\t\tAdicionar Localização\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"row justify-content-center mt-5\">\r\n");
      out.write("\t\t\t<div class=\"col-6 col-lg-5 text-center h3\">\r\n");
      out.write("\t\t\t\tFormulário para adicionar o país\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row justify-content-center mt-2\">\r\n");
      out.write("\t\t<div class=\"col-lg-8 mt-1\">\r\n");
      out.write("\t\t\t<div class=\"card\" >\r\n");
      out.write("\t  \t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t    <h4 class=\"card-title text-center\">Dados</h4>\r\n");
      out.write("\t\t\t\t\t<form id=\"localizacao-form\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t  <div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group col-md-4\">\r\n");
      out.write("\t\t\t\t\t      <label for=\"nome\" class=\"h6\">Nome do país e lugar:</label>\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"cxnome\" name=\"cxurl\" placeholder=\"Exemplo (Brasil, São Paulo)\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group col-md-5 ml-5\">\r\n");
      out.write("\t\t\t\t\t      <label for=\"inputPassword4\" class=\"h6\">URL imagem:</label>\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"cxurl\" name=\"cxurl\" placeholder=\"Digite a URL da imagem...\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t  \t<div class=\"form-group col-md-2 mt-4 ml-5\">\r\n");
      out.write("\t\t\t\t        \t<button type=\"submit\" class=\"btn btn-primary\">Inserir</button>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t      \r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/script.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
 	
		}
	else{
		response.sendRedirect("index.jsp");
	}

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
