package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String login;
	private String senha;
	private String telefone;
	private String estado;
	private int nivelusuario;
	
	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private DBQuery dbQuery = null;
	
	public Usuario() {
		this.tableName = "usuario";
		this.fieldsName = "idUsuario, nome, login, senha, telefone, estado, nivelusuario";
		this.keyField = "idUsuario";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
	}
	
	
	
	public Usuario(String nome, String login, String senha, String telefone, String estado) {
		this.tableName = "usuario";
		this.fieldsName = "nome, login, senha, telefone, estado";
		this.keyField = "idUsuario";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setNome(nome);
		this.setLogin(login);
		this.setSenha(senha);
		this.setTelefone(telefone);
		this.setEstado(estado);
	}


	
	public String[] toArray() {
		return(
			new String[] {
					""+this.getNome(),
					""+this.getLogin(),
					""+this.getSenha(),
					""+this.getTelefone(),
					""+this.getEstado(),
			}
		);
	}
	
	public int convert(String nivelusuario) {
		int value = 2;
		if(nivelusuario == null) {
			value = 0;
		}else if(nivelusuario.equals("1")) {
			value = 1;
		}
		return (value);
	}
	
	
	public boolean save() {
		ResultSet rs = this.dbQuery.select("nome = '"+this.getNome()+"' and login='"+this.getLogin()+"'");
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {

		}
		this.dbQuery.insert(this.toArray());
		return false;
	}
	

	
	public String usuarios() {
		ResultSet rs = this.dbQuery.select("");
		String saida = "<div class=\"row\">";
		try {
			while(rs.next()) {
				saida += "	<div class=\"col-md-3 mt-2\">\r\n" + 
						"		<div class=\"card\">\r\n" + 
						"		  <div class=\"card-body\">\r\n" + 
						"		<div class=\"col text-center\">" +
						"			<img src=\"img/perfil.png\" class=\"perfil\" >" +
						"		</div>" + 
						"		<div class=\"row mt-1\">\r\n" + 
						"			<div class=\"col-md-12\">" +
						"		    	<h6 class=\"card-text\">Nome Completo: "+rs.getString("nome")+ "</h6>\r\n" + 
						"			</div>" +
						"		</div>" +
						"<div class=\"row mt-1\">\r\n" + 
						"	<div class=\"col-md-12\">" +
						"		<h6 class=\"card-text\">Login: "+rs.getString("login")+ "</h6>\r\n" + 
						"	</div>" +
						"</div>" +
						"	<div class=\"row mt-1\">\r\n" + 
						"		<div class=\"col-md-12\">" +
						"			<h6 class=\"card-text\">Senha: "+rs.getString("senha")+ "</h6>\r\n" + 
						"		</div>" +
						"	</div>" +
						"<div class=\"row mt-1\">\r\n" + 
						"	<div class=\"col-md-12\">" +
						"		<h6 class=\"card-text\">Telefone: "+rs.getString("telefone")+ "</h6>\r\n" + 
						"	</div>" +
						"</div>" +
						"<div class=\"row mt-1\">\r\n" + 
						"	<div class=\"col-md-12\">" +
						"		<h6 class=\"card-text\">UF: "+rs.getString("estado")+ "</h6>\r\n" + 
						"	</div>" +
						"</div>" +
						"<div class=\"row mt-1\">\r\n" + 
						"	<div class=\"col-md-12\">" +
						"		<h6 class=\"card-text\">N�vel Usu�rio: "+ (rs.getInt("nivelusuario")==1?"Usu�rio comum":"Administrador") + "</h6>\r\n" + 
						"	</div>" +
						"</div>" +
						"<div class=\"row justify-content-end mt-2\">\r\n" + 
						"   <div class=\"col-4\">\r\n" + 
						"		<a href=excluirusuario.jsp?idusuario=" + rs.getString("idUsuario") + ">" +
						"			<button type=\"button\" class=\"btn btn-primary excluirusuario\">Excluir</button>\r\n" + 
						"		</a>" +
						"    </div>\r\n" + 
						"<div class=\"col-4\">\r\n" + 
						"	<a href=alterarusuario.jsp?idusuario=" + rs.getString("idUsuario") + "&nivelusuario=" + rs.getString("nivelusuario") + ">" +
						"		<button type=\"button\" class=\"btn btn-primary alterarusuario\">N�vel</button>\r\n" + 
						"	</a>" +
						"</div>\r\n" + 
						"</div>" +
						"</div>\r\n" + 
						"</div>\r\n" + 
						"</div>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		saida += "</div>";
		return (saida);
	}
	
	public void alterarUsuario() {
		this.dbQuery.alterarUsuario("" + this.getNivelusuario(), "" + this.getIdUsuario());
	}
	
	public void deleteUsuario() {
		ResultSet rs = this.dbQuery.selectCompraUsuario("usuario.idUsuario="+this.getIdUsuario());
		int qntd = 0;
		
		try {
			while(rs.next()) {
				qntd = rs.getInt("qntd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(qntd >= 1) {
			this.dbQuery.deleteCompraUsuario("" + this.getIdUsuario());
			this.dbQuery.deleteUsuario("" + this.getIdUsuario());
		}else {
			this.dbQuery.deleteUsuario("" + this.getIdUsuario());
		}	
	}
	

	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getNivelusuario() {
		return nivelusuario;
	}


	public void setNivelusuario(int nivelusuario) {
		this.nivelusuario = nivelusuario;
	}


	public DBQuery getDbQuery() {
		return dbQuery;
	}


	public void setDbQuery(DBQuery dbQuery) {
		this.dbQuery = dbQuery;
	}
	
	
	
	

	
}
