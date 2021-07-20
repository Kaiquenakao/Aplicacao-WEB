package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import database.DBQuery;

public class Compra {
	private int idCompra;
	private int idUsuario;
	private int idPassagem;
	private int idLinhaAerea;
	
	
	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private String where = "";
	private DBQuery dbQuery = null;
	
	
	public Compra(String idUsuario, String idPassagem, String idLinhaAerea) {
		this.tableName = "compra";
		this.fieldsName = "idUsuario, idPassagem, idLinhaAerea";
		this.keyField = "idCompra";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdUsuario(Integer.valueOf(idUsuario));
		this.setIdPassagem(Integer.valueOf(idPassagem));
		this.setIdLinhaAerea(Integer.valueOf(idLinhaAerea));
		this.setIdUsuario(Integer.valueOf(idUsuario));
	}
	
	
	
	public String[] toArray() {
		return(
			new String[] {
				""+this.getIdUsuario(),
				""+this.getIdPassagem(),
				""+this.getIdLinhaAerea()
			}
		);
	}
	
	
	public void save() {
		this.dbQuery.insert(this.toArray());
	}
	
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPassagem() {
		return idPassagem;
	}
	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}
	public int getIdLinhaAerea() {
		return idLinhaAerea;
	}
	public void setIdLinhaAerea(int idLinhaAerea) {
		this.idLinhaAerea = idLinhaAerea;
	}

}
