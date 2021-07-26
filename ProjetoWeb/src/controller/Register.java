package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import model.Usuario;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE="text/html;charset=UTF-8";
	private String mensagem;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType(CONTENT_TYPE);
		
		Gson gson = new Gson();
		JSONObject jo = new JSONObject();
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String estado = request.getParameter("estado");
		
		if(nome.equals("") || login.equals("") || senha.equals("") || telefone.equals("") || estado.equals("")) {
			jo.put("status", false);
			jo.put("mensagem", "Algum campo est� v�zio");
			mensagem = gson.toJson(jo);
			out.print(mensagem);
		}else {
			Usuario usuario = new Usuario(nome, login, senha, telefone, estado);
			if(usuario.save()) {
				jo.put("status", false);
				jo.put("mensagem", "O Nome ou Usu�rio j� cadastrado");
				mensagem = gson.toJson(jo);
				out.print(mensagem);
			}else {
				jo.put("status", true);
				jo.put("mensagem", "Usu�rio cadastrado com sucesso!");
				mensagem = gson.toJson(jo);
				out.print(mensagem);
			}
		}
	}
}
