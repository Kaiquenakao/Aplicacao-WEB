/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2021-07-20 02:52:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Passagem;
import model.LinhaAerea;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"pt\">\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write(" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("    <script\r\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.6.0.js\"\r\n");
      out.write("  integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\"\r\n");
      out.write("  crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/design.css\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("    \r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    ");

    	String carousel = new Passagem().CarouselPromocao();
    	String carouselcards = new Passagem().CarouselCards();
    	String nome = (String) session.getAttribute("nome");
    	String localizacao = new LinhaAerea().localizacao();
    
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid px-0\">\r\n");
      out.write("     \r\n");
      out.write("     <div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-12 col-lg-12 center\">\r\n");
      out.write("\t\t\t\t<img src=\"img/menu.jpg\" class=\"img-responsive\" alt=\"Responsive image\" id=\"imagem\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("        <div class=\"col-9 col-lg-9 justify-content-between mt-4 ml-2\" id=\"mensagem\">\r\n");
      out.write("            \"Seu primeiro destino é aqui\"\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("  \t\r\n");
      out.write("  \t\r\n");
      out.write("\t");
 if(nome == null){ 
      out.write("\r\n");
      out.write("    <div class=\"col-1 col-lg-1 mt-4\">\r\n");
      out.write("      \t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#login\" data-whatever=\"@mdo\">Login</button>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"modal fade\" id=\"login\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Login</h5>\r\n");
      out.write("\t\t\t\t        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t        </button>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t        <form method=\"POST\" id=\"login-form\">\r\n");
      out.write("\t\t\t\t          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t          \t<div class=\"alert alert-danger center\" role=\"alert\" id=\"errologin\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t            <label for=\"login\" class=\"col-form-label\">Login:</label>\r\n");
      out.write("\t\t\t\t            <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\">\r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"senha\" class=\"col-form-label\">Senha:</label>\r\n");
      out.write("\t\t\t\t            <input type=\"password\" class=\"form-control\" id=\"senha\" name=\"senha\">\r\n");
      out.write("\t\t\t\t       \r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t      \r\n");
      out.write("\t\t\t\t      <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("\t\t\t\t        <button type=\"submit\" class=\"btn btn-primary\">Send message</button>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t      </form>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"col-1 col-lg-1 mt-4\">\r\n");
      out.write("      \t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#registrar\" data-whatever=\"@mdo\">Registrar</button>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"modal fade\" id=\"registrar\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t  <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t      <div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Registrar</h5>\r\n");
      out.write("\t\t\t\t        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("\t\t\t\t          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t        </button>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t      <div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t        <form method=\"POST\" id=\"register-form\">\r\n");
      out.write("\t\t\t\t        \t<div class=\"alert alert-danger center\" role=\"alert\" id=\"erro\">\r\n");
      out.write("  \t\t\t\t\t\t\t\tNome ou Login já cadastrado!\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t            <label for=\"nome\" class=\"col-form-label\">Nome Completo:</label>\r\n");
      out.write("\t\t\t\t            <input type=\"text\" class=\"form-control\" id=\"nome\" name=\"nome\">\r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"login\" class=\"col-form-label\">Login:</label>\r\n");
      out.write("\t\t\t\t            <input type=\"text\" class=\"form-control\" id=\"cxlogin\" name=\"cxlogin\">\r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\t\t\t          <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"senha\" class=\"col-form-label\">Senha:</label>\r\n");
      out.write("\t\t\t\t            <input type=\"password\" class=\"form-control\" id=\"cxsenha\" name=\"cxsenha\">\r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t         \r\n");
      out.write("\t\t\t\t         <div class=\"form-row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group col-md-6\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"telefone\" class=\"col-form-label\">Telefone:</label>\r\n");
      out.write("\t\t\t\t            <input type=\"text\" class=\"form-control\" id=\"telefone\" placeholder=\"Digite seu telefone...\" name=\"telefone\">\r\n");
      out.write("\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t          \r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group col-md-3 ml-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"estado\" class=\"col-form-label\">Estado</label>\r\n");
      out.write("      \t\t\t\t\t\t<select id=\"estado\" class=\"form-control\">\r\n");
      out.write("\t        \t\t\t\t\t<option value=\"AC\" selected>AC</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"AL\">AL</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"AP\">AP</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"AM\">AM</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"BA\">BA</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"CE\">CE</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"ES\">ES</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"GO\">GO</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"MA\">MA</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"MT\">MT</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"MS\">MS</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"MG\">MG</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"PA\">PA</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"PB\">PB</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"PR\">PR</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"PE\">PE</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"PI\">PI</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"RJ\">RJ</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"RN\">RN</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"RS\">RS</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"RO\">RO</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"RR\">RR</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"SC\">SC</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"SP\">SP</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"SE\">SE</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"TO\">TO</option>\r\n");
      out.write("\t       \t\t\t\t\t\t<option value=\"DF\">DF</option>\r\n");
      out.write("      \t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t      \r\n");
      out.write("\t\t\t\t      <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("\t\t\t\t        <button type=\"submit\" class=\"btn btn-primary\">Send message</button>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t      </form>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("\t");
 }
	
	else{
	
      out.write("\r\n");
      out.write("\t<div class=\"row justify-content-end\">\r\n");
      out.write("\t\t<div class=\"col-1 col-lg-1 mt-4 ml-4\">\r\n");
      out.write("\t\t\t<a href=\"deslogar.jsp?pag=1\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-primary\">Deslogar</button>\r\n");
      out.write("\t        </a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-12 col-lg-3 ml-2\" id=\"mensagem2\">\r\n");
      out.write("            Aqui você encontra os melhores preços para viajar\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<form method=\"POST\" id=\"buscar-form\" >\r\n");
      out.write("    <div class=\"row mt-4\">\r\n");
      out.write("        <div class=\"col-2 col-lg-2 aeroporto mt-4 ml-4\">\r\n");
      out.write("            <div class=\"jss30\"><p>Origem</p></div>\r\n");
      out.write("            <div class=\"jss35\">GRU - Aeroporto</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"col-3 col-lg-3 buscarlocalizacao mt-4 ml-5\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 out.print(localizacao); 
      out.write("\r\n");
      out.write("            \t<div class=\"jss30\"><p>Buscar Localização</p></div>\r\n");
      out.write("            \t<div class=\"jss31\">Qual país você deseja viajar ?</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-3 col-lg-3 classe mt-4 ml-5\">\r\n");
      out.write("\t\t\t\t\t<select multiple class=\"form-control buscarclasse\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"1\" class=\"jss32\">Classe Econômica</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"2\"  class=\"jss32\">Classe Executiva</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("            \t\t<div class=\"jss30\"><p>Seleciona a classe</p></div>\r\n");
      out.write("            \t\t<div class=\"jss33\">Qual classe você deseja viajar ?</div>\r\n");
      out.write("        \t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"col-1 col-lg-1 mt-4 ml-5\">\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-success buscarlinha\">Buscar</button>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("       \r\n");
      out.write("      </div>\r\n");
      out.write("      </form>\r\n");
      out.write("      \r\n");
      out.write("      <div class=\"row justify-content-center mt-5\" id=\"errobuscalinha\">\r\n");
      out.write("        \t<div class=\"col-3 text-center\" id=\"errobusca\"></div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("      <div class=\"row mt-5\">\r\n");
      out.write("        <div class=\"col-6 col-lg-6 jss37 mt-5\" id=\"titulo\">\r\n");
      out.write("           <div class=\"row justify-content-center mt-5\" id=\"mensagem\"\">\r\n");
      out.write("          \t\tPassagens na promoção\r\n");
      out.write("           </div>\r\n");
      out.write("           \r\n");
      out.write("\t\t\t<div class=\"row justify-content-center\" id=\"mensagem\"\">\r\n");
      out.write("          \t\tBasta clicar na imagem ao lado\r\n");
      out.write("          \t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"col-6 col-lg-5 mt-5\">\r\n");
      out.write("\t\t\t");
 out.print(carousel); 
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t        <div class=\"col-12 col-lg-12 \">\r\n");
      out.write("            <div class=\"mx-auto msg mt-4\" style=\"width: 500px;\">\r\n");
      out.write("  \t\t\t\tPassagens com preços imbatíveis\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("         </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row mt-4\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 out.print(carouselcards); 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
