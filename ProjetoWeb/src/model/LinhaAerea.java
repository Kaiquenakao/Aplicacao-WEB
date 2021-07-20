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
	
	public String quantidadeocaLinhaAerea(String idpassagem, String id, String classe) {
		String saida = "Foram encontrados: ";
		if(idpassagem != null) {
			ResultSet rs = this.dbQuery.linhasQuantidade("p.idPassagem ='"+idpassagem+"'");
			try {
				while(rs.next()) {
					saida += rs.getString("quantidade") + " elementos";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			ResultSet rs = this.dbQuery.linhasQuantidadeIdClasse("p.idPassagem ='"+id+"' and li.classe='"+classe+"'");
			try {
				while(rs.next()) {
					saida += rs.getString("quantidade") + " elementos";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		return(saida);
	}
	
	public String dadosLinha(String idpassagem, String nivelusuario, String idusuario) {
		ResultSet rs = this.dbQuery.dadosLinha("p.idPassagem ='"+idpassagem+"'");
		String saida = "<div class=\"teste\">";
		String tipoclasse;
		try {
			while(rs.next()) {
				int classe = rs.getInt("classe");
				if(classe == 1) {
					tipoclasse = "Classe Econ�mica";
				}else {
					tipoclasse = "Classe Executiva";
				}
				
				saida += "       <div class=\"row justify-content-center mt-2\">\r\n" + 
						"        	<div class=\"col-lg-8 mt-1\">\r\n" + 
						"            <div class=\"card\">\r\n" + 
						"			  <div class=\"card-body\">\r\n" + 
						"			    <h5 class=\"card-title\">\r\n" + 
						"					  <div class=\"row justify-content-between\">\r\n" + 
						"						<div class=\"col-4\">\r\n" + 
						"						  Origem: GRU - Aeroporto\r\n" + 
						"						</div>\r\n" + 
						"						<div class=\"col-4\">\r\n" + 
						"						  Destino: "+ rs.getString("nome")+"\r\n" + 
						"						</div>\r\n" + 
						"					  </div>\r\n" + 
						"				</h5>\r\n" + 
						"				<p class=\"card-text\">\r\n" + 
						"					<h6>\r\n" + 
						"	  					<div class=\"row justify-content-center\">\r\n" + 
						"							<div class=\"col-5\">\r\n" + 
						"		  						Nome da companhia a�rea: " + rs.getString("empresa") +
						"							</div>\r\n" + 
						"							<div class=\"col-4\">\r\n" + 
						"		  						Classe: " + tipoclasse + 
						"							</div>\r\n" + 
						"							<div class=\"col-3\">\r\n" + 
						"								Pre�o: " + rs.getFloat("preco") +
						"							</div>\r\n" + 
						"	  					</div>\r\n" + 
						"  				</h6>\r\n" + 
						"				</p>" +
						"<div class=\"row justify-content-center\">";
						if(nivelusuario == null) {
							saida += "<div class=\"col-2\">";
							saida += "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#buscanivel\">\r\n" + 
									"  Comprar\n" + 
									"</button>\r\n" + 
									"\r\n" + 
									"<!-- Modal -->\r\n" + 
									"<div class=\"modal fade\" id=\"buscanivel\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"buscanivel\" aria-hidden=\"true\">\r\n" + 
									"  <div class=\"modal-dialog\" role=\"document\">\r\n" + 
									"    <div class=\"modal-content\">\r\n" + 
									"      <div class=\"modal-header\">\r\n" + 
									"        <h5 class=\"modal-title\" id=\"buscanivel\">Erro</h5>\r\n" + 
									"        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n" + 
									"          <span aria-hidden=\"true\">&times;</span>\r\n" + 
									"        </button>\r\n" + 
									"      </div>\r\n" + 
									"      <div class=\"modal-body\">\r\n" + 
									"       Voc� precisa est� logado para efetuar uma compra\r\n" + 
									"      </div>\r\n" + 
									"      <div class=\"modal-footer\">\r\n" + 
									"        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Fechar</button>\r\n" + 
									"      </div>\r\n" + 
									"    </div>\r\n" + 
									"  </div>\r\n" + 
									"</div>";
							saida += "</div></div>";
	
						}
						else {
						saida += "<div class=\"col-2\">\r\n" + 
								"<a href="+"compra.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+">" +
								"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" id=\"comprarsucess\" data-target=\"#myModal\">\r\n" + 
								"Comprar" +
								"<input type=\"hidden\" id=\"teste\" value="+rs.getString("empresa")+">" +
								"</button>\r\n"+
								"</a>" +
								"</div></div>";
						}
						saida += "</div></div></div></div></div>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(saida);
	}
	
	public String dadosLinhabusca(String id, String classebusca, String nivelusuario, String idusuario) {
		ResultSet rs = this.dbQuery.dadosLinha("p.idPassagem ='"+id+"' and classe ='"+classebusca+"'");
		String saida = "<div class=\"teste\">";
		String tipoclasse;
		try {
			while(rs.next()) {
				int classe = rs.getInt("classe");
				if(classe == 1) {
					tipoclasse = "Classe Econ�mica";
				}else {
					tipoclasse = "Classe Executiva";
				}
				
				saida += "       <div class=\"row justify-content-center mt-2\">\r\n" + 
						"        	<div class=\"col-lg-8 mt-1\">\r\n" + 
						"            <div class=\"card\">\r\n" + 
						"			  <div class=\"card-body\">\r\n" + 
						"			    <h5 class=\"card-title\">\r\n" + 
						"					  <div class=\"row justify-content-between\">\r\n" + 
						"						<div class=\"col-4\">\r\n" + 
						"						  Origem: GRU - Aeroporto\r\n" + 
						"						</div>\r\n" + 
						"						<div class=\"col-4\">\r\n" + 
						"						  Destino: "+ rs.getString("nome")+"\r\n" + 
						"						</div>\r\n" + 
						"					  </div>\r\n" + 
						"				</h5>\r\n" + 
						"				<p class=\"card-text\">\r\n" + 
						"					<h6>\r\n" + 
						"	  					<div class=\"row justify-content-center\">\r\n" + 
						"							<div class=\"col-5\">\r\n" + 
						"		  						Nome da companhia a�rea: " + rs.getString("empresa") +
						"							</div>\r\n" + 
						"							<div class=\"col-4\">\r\n" + 
						"		  						Classe: " + tipoclasse + 
						"							</div>\r\n" + 
						"							<div class=\"col-3\">\r\n" + 
						"								Pre�o: " + rs.getFloat("preco") +
						"							</div>\r\n" + 
						"	  					</div>\r\n" + 
						"  				</h6>\r\n" + 
						"				</p>" +
						"<div class=\"row justify-content-center\">";
						if(nivelusuario == null) {
							saida += "<div class=\"col-2\">";
							saida += "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#buscanivel\">\r\n" + 
									"  Comprar\n" + 
									"</button>\r\n" + 
									"\r\n" + 
									"<!-- Modal -->\r\n" + 
									"<div class=\"modal fade\" id=\"buscanivel\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"buscanivel\" aria-hidden=\"true\">\r\n" + 
									"  <div class=\"modal-dialog\" role=\"document\">\r\n" + 
									"    <div class=\"modal-content\">\r\n" + 
									"      <div class=\"modal-header\">\r\n" + 
									"        <h5 class=\"modal-title\" id=\"buscanivel\">Erro</h5>\r\n" + 
									"        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n" + 
									"          <span aria-hidden=\"true\">&times;</span>\r\n" + 
									"        </button>\r\n" + 
									"      </div>\r\n" + 
									"      <div class=\"modal-body\">\r\n" + 
									"       Voc� precisa est� logado para efetuar uma compra\r\n" + 
									"      </div>\r\n" + 
									"      <div class=\"modal-footer\">\r\n" + 
									"        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Fechar</button>\r\n" + 
									"      </div>\r\n" + 
									"    </div>\r\n" + 
									"  </div>\r\n" + 
									"</div>";
							saida += "</div></div>";
	
						}
						else {
						saida += "<div class=\"col-2\">\r\n" + 
								"<a href="+"compra.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+">" +
								"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" id=\"comprarsucess\" data-target=\"#myModal\">\r\n" + 
								"Comprar" +
								"<input type=\"hidden\" id=\"teste\" value="+rs.getString("empresa")+">" +
								"</button>\r\n"+
								"</a>" +
								"</div></div>";
						}
						saida += "</div></div></div></div></div>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(saida);
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
		String saida = "<select multiple class=\"form-control buscarloca\">";
		
		try {
			while(rs.next()) {
				saida += "<option value="+ rs.getInt("id")+" name=\"opcaoid\" class=\"jss32\" id=\"opcaoid\">"+ rs.getString("nome") + "</option>";
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
