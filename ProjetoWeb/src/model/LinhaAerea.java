package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import database.DBQuery;

public class LinhaAerea {
	private int idLinhaAerea;
	private int idPassagem;
	private String nomeEmpresa;
	private float preco;
	private int classe;
	
	Locale ptBr = new Locale("pt", "BR");
	
	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private DBQuery dbQuery = null;
	
	public LinhaAerea() {
		this.tableName = "linha_aerea";
		this.fieldsName = "idPassagem, nomeEmpresa, preco, classe";
		this.keyField = "idLinhaAerea";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	
	public LinhaAerea(String idPassagem, String nomeEmpresa, String preco, String classe) {
		this.tableName = "linha_aerea";
		this.fieldsName = "idPassagem, nomeEmpresa, preco, classe";
		this.keyField = "idLinhaAerea";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdPassagem(Integer.parseInt(idPassagem));
		this.setNomeEmpresa(nomeEmpresa);
		this.setPreco(Float.parseFloat(preco));
		this.setClasse(Integer.parseInt(classe));
	}
	
	
	public String quantidadeocaLinhaAerea(String idpassagem, String id, String classe) {
		String saida = "Foram encontrado: ";
		int elem =0;
		if(idpassagem != null) {
			ResultSet rs = this.dbQuery.linhasQuantidade("p.idPassagem ='"+idpassagem+"'");
			try {
				while(rs.next()) {
					elem = rs.getInt("quantidade");
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			ResultSet rs = this.dbQuery.linhasQuantidadeIdClasse("p.idPassagem ='"+id+"' and li.classe='"+classe+"'");
			try {
				while(rs.next()) {
					elem = rs.getInt("quantidade");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(elem > 1 ) {
			saida += elem + " elementos";
		}else {
			saida += elem + " elemento";
		}
		
		
		return(saida);
	}
	

	
	
	public String dadosLinha(String idpassagem, int nivelusuario, String idusuario) {
		ResultSet rs = this.dbQuery.dadosLinha("p.idPassagem ='"+idpassagem+"'");
		String saida = "<div class=\"teste\">";
		try {
			while(rs.next()) {
				
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
						"		  						Classe: " + (rs.getInt("classe") == 1?"Classe Econ�mica" : "Classe Executiva") + 
						"							</div>\r\n" + 
						"							<div class=\"col-3\">\r\n" + 
						"								Pre�o: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) +
						"							</div>\r\n" + 
						"	  					</div>\r\n" + 
						"  				</h6>\r\n" + 
						"				</p>";
						
						if(nivelusuario == 0) {
							saida += "<div class=\"row justify-content-center\">" +
									"<div class=\"col-2\">";
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
							saida += "</div></div></div>";
	
						}
						else if(nivelusuario == 1){
						saida += "<div class=\"row justify-content-center\">" +
								"<div class=\"col-2\">\r\n" + 
								"<a href="+"compra.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+">" +
								"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" id=\"comprarsucess\" data-target=\"#myModal\">\r\n" + 
								"Comprar" +
								"<input type=\"hidden\" id=\"teste\" value="+rs.getString("empresa")+">" +
								"</button>\r\n"+
								"</a>" +
								"</div></div></div>";
						}else {
							saida += "<div class=\"row justify-content-end\">" +
									"<div class=\"col-2\">\r\n" + 
									"<a href="+"excluir.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+ "&classe=" +rs.getInt("classe") +">" + 
									"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" id=\"excluirsucess\">" +
									"Excluir" +
									"<input type=\"hidden\" id=\"teste\" value="+rs.getString("empresa")+">" +
									"</button>\r\n"+
									"</a>" +
									"</div>"+
									"<div class=\"col-2\">\r\n" + 
									"<a href="+"alterar.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+ "&classe=" +rs.getInt("classe") +">" +
									"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\">" +
									"Alterar\r\n" + 
									"</button>\r\n" + 
									"</a>" + 
									"</div></div>";
						}
						
						
						saida += "</div></div></div></div>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(saida);
	}
	
	public String dadosLinhabusca(String id, String classebusca, int nivelusuario, String idusuario) {
		ResultSet rs = this.dbQuery.dadosLinha("p.idPassagem ='"+id+"' and classe ='"+classebusca+"'");
		String saida = "<div class=\"teste\">";
		try {
			while(rs.next()) {
				
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
						"		  						Classe: " + (rs.getInt("classe") == 1?"Classe Econ�mica" : "Classe Executiva") + 
						"							</div>\r\n" + 
						"							<div class=\"col-3\">\r\n" + 
						"								Pre�o: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) +
						"							</div>\r\n" + 
						"	  					</div>\r\n" + 
						"  				</h6>\r\n" + 
						"				</p>";
				if(nivelusuario == 0) {
					saida += "<div class=\"row justify-content-center\">" +
							"<div class=\"col-2\">";
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
					saida += "</div></div></div>";

				}
				else if(nivelusuario == 1){
				saida += "<div class=\"row justify-content-center\">" +
						"<div class=\"col-2\">\r\n" + 
						"<a href="+"compra.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+">" +
						"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" id=\"comprarsucess\" data-target=\"#myModal\">\r\n" + 
						"Comprar" +
						"<input type=\"hidden\" id=\"teste\" value="+rs.getString("empresa")+">" +
						"</button>\r\n"+
						"</a>" +
						"</div></div></div>";
				}else {
					saida += "<div class=\"row justify-content-end\">" +
							"<div class=\"col-2\">\r\n" + 
							"<a href="+"excluir.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+ "&classe=" +rs.getInt("classe") +">" + 
							"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" id=\"excluirsucess\">" +
							"Excluir" +
							"<input type=\"hidden\" id=\"teste\" value="+rs.getString("empresa")+">" +
							"</button>\r\n"+
							"</a>" +
							"</div>"+
							"<div class=\"col-2\">\r\n" + 
							"<a href="+"alterar.jsp?idusuario="+idusuario+"&idpassagem="+rs.getString("id")+"&idlinha="+rs.getString("li.idLinhaAerea")+ "&classe=" +rs.getInt("classe") +">" +
							"<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\">" +
							"Alterar\r\n" + 
							"</button>\r\n" + 
							"</a>" + 
							"</div></div>";
				}
				
				
				saida += "</div></div></div></div>";
						
						saida += "</div></div></div></div></div>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(saida);
	}
	
	
	public String linhaAereaEspecifica(String idpassagem, String idlinha) {
		ResultSet rs = this.dbQuery.dadosLinha("p.idPassagem ='"+idpassagem+"' and li.idLinhaAerea ='"+idlinha+"'");
		String saida = "<div class=\"teste\">";
		try {
			while(rs.next()) {
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
						"		  						Classe: " + (rs.getInt("classe") == 1?"Classe Econ�mica" : "Classe Executiva") + 
						"							</div>\r\n" + 
						"							<div class=\"col-3\">\r\n" + 
						"								Pre�o: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) +
						"							</div>\r\n" + 
						"	  					</div>\r\n" + 
						"  				</h6>\r\n" + 
						"				</p></div></div></div></div>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return (saida);
	}
	
	public String alterarLinha(String idpassagem, String idlinha) {
		ResultSet rs = this.dbQuery.dadosLinha("p.idPassagem ='"+idpassagem+"' and li.idLinhaAerea ='"+idlinha+"'");
		String saida = "<div class=\"teste\">";
		try {
			while(rs.next()) {
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
						"					<form id=\"alterar-form\" method=\"POST\" >" +
						"	  					<div class=\"row justify-content-center\">\r\n" + 
						"							<div class=\"col-5\">\r\n" + 
						"		  						Nome da companhia a�rea: " + "<input type=\"text\" class=\"form-control\" placeholder=\"Digite o nome da companhia:\" name=\"cxnome\" id=\"cxnome\">" +
						"							</div>\r\n" + 
						"							<div class=\"col-4\">\r\n" + 
						"		  						Classe: " + "      <select id=\"cxclasse\" name=\"cxclasse\" class=\"form-control\">\r\n" + 
						"        						<option selected value=\"1\">Classe Econ�mica</option>\r\n" + 
						"        						<option value=\"2\">Classe Executiva</option>\r\n" + 
						"      							</select>" + 
						"							</div>\r\n" + 
						"							<div class=\"col-3\">\r\n" + 
						"								Pre�o: " + "<input type=\"text\" class=\"form-control\" placeholder=\"Digite o pre�o\" name=\"cxpreco\" id=\"cxpreco\">" +
						"							</div>\r\n" + 
						"	  					</div>\r\n" + 
						"  				</h6>\r\n" + 
						"<input type=\"hidden\" id=\"id\" name=\"id\" value="+idlinha+">" +
						"				</p><form>" +
						"<div class=\"row justify-content-center\">\r\n" + 
						"	<div class=\"col-2\">\r\n" + 
						"		<button type=\"submit\" class=\"btn btn-primary\">Alterar</button>\r\n" + 
						"	</div>\r\n" + 
						"</div>" +
						"</div></div></div></div>";
			}
		} catch (SQLException e) {
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
	
	

	
	public String classes() {
		String saida = "<select multiple class=\"form-control jss32 buscarclasse\" name=\"classe\" id=\"classe\">";
		saida += "<option value=\"1\">Classe Econ�mica</option>\r\n" + 
				"<option value=\"2\">Classe Executiva</option>";
		saida += "</select>";
		
		return(saida);
	}
	
	
	public void alterar(String idpassagem, String preco, String classe,String id) {
		this.dbQuery.update(idpassagem, preco, classe, id);
	}

	/**/
	public void save() {
		this.dbQuery.insert(this.toArray());
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
