package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class Localizacao {
	private String nome;
	private int promocao;
	
	
	
	
	public int getPromocao() {
		return promocao;
	}

	public void setPromocao(int promocao) {
		this.promocao = promocao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private String where = "";
	private DBQuery dbQuery = null;
	
	
	public Localizacao() {
		this.tableName = "Localizacao";
		this.fieldsName = "idLocalizacao, nome, URL";
		this.keyField = "idLocalizacao";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	public Localizacao(String nome, int promocao) {
		this.tableName = "passagens";
		this.fieldsName = "localizacao, preco, promocao";
		this.keyField = "idPassagem";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);

		this.setNome(nome);
		this.setPromocao(promocao);
	}
	

	
	
	public void save() {
		this.dbQuery.insert(this.toArray());
	}
	
	public String[] toArray() {
		return(
			new String[] {
				""+this.getNome()
			}
		);
	}

	

	
	
	public String idPassagem() {
		ResultSet rs = this.dbQuery.selectID("NOT EXISTS (SELECT passagem.idLocalizacao FROM passagem WHERE localizacao.idLocalizacao = passagem.idLocalizacao)");
		String nome = "<br>";
		try {
			while(rs.next()) {
				nome += "<img src='" + rs.getString("URL") + "'>";
				nome += rs.getString("nome");
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return (nome);
	}
	
	

	
	
}
