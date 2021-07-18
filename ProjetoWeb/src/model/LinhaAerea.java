package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuery;

public class LinhaAerea {
	private int idLinhaAerea;
	private int idPassagem;
	private String nomeEmpresa;
	private float preco;
	private int classe;
	
	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private String where = "";
	private DBQuery dbQuery = null;
	
	public LinhaAerea() {
		this.tableName = "linha_aerea";
		this.fieldsName = "idPassagem, nomeEmpresa, preco, classe";
		this.keyField = "idLinhaAerea";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	
	public LinhaAerea(int idPassagem, String nomeEmpresa, float preco, int classe) {
		this.tableName = "linha_aerea";
		this.fieldsName = "idPassagem, nomeEmpresa, preco, classe";
		this.keyField = "idLinhaAerea";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		/* Adicionar elementos com set aqui */
		
	}
	
	
	
	
	public String[] toArray() {
		return(
			new String[] {
					""+this.getIdPassagem(),
					""+this.getNomeEmpresa(),
					""+this.getPreco(),
					""+this.getClasse(),
			}
		);
	}
	
	
	public String localizacao() {
		ResultSet rs = this.dbQuery.selectLocalizacao("");
		String saida = "<select multiple class=\"form-control jss32 buscarloca\">";
		
		try {
			while(rs.next()) {
				saida += "<option value="+ rs.getInt("id")+" name=\"opcaoid\" id=\"opcaoid\">"+ rs.getString("nome") + "</option>";
			}
			saida += "</select>";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return(saida);
	}
	
	public String classes() {
		String saida = "<select multiple class=\"form-control jss32 buscarclasse\" name=\"classe\" id=\"classe\">";
		saida += "<option value=\"1\">Classe Econ�mica</option>\r\n" + 
				"<option value=\"2\">Classe Executiva</option>";
		saida += "</select>";
		
		return(saida);
	}
	
	

	
	
	
	
	public int getIdLinhaAerea() {
		return idLinhaAerea;
	}
	public void setIdLinhaAerea(int idLinhaAerea) {
		this.idLinhaAerea = idLinhaAerea;
	}
	public int getIdPassagem() {
		return idPassagem;
	}
	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	
	
}
