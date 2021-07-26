package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import database.DBQuery;

public class Passagem {
	private int idPassagem;
	private int idLocalizacao;
	private int promocao;

	private String tableName = "";
	private String fieldsName = "";
	private String keyField = "";
	private DBQuery dbQuery = null;
	
	Locale ptBr = new Locale("pt", "BR");
	
	public Passagem() {
		this.tableName = "passagem";
		this.fieldsName = "idLocalizacao, promocao";
		this.keyField = "idPassagem";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	public Passagem(String idLocalizacao, String promocao) {
		this.tableName = "passagem";
		this.fieldsName = "idLocalizacao, promocao";
		this.keyField = "idPassagem";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
		
		this.setIdLocalizacao(Integer.parseInt(idLocalizacao));
		this.setPromocao(Integer.parseInt(promocao));
	}
	
	public String[] toArray() {
		return(
			new String[] {
				""+this.getIdLocalizacao(),
				""+this.getPromocao()
			}
		);
	}

	public boolean save() {
		ResultSet rs = this.dbQuery.select("idLocalizacao = '"+this.getIdLocalizacao()+"'");
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {

		}
		this.dbQuery.insert(this.toArray());
		return false;
	}

	
	public String CarouselPromocao() {
		ResultSet rss = this.dbQuery.selectPromocao("PROMOCAO = 1 group by lo.nome");
		String saida = "<div id=\"indicador\" class=\"carousel slide\" data-ride=\"carousel\">";
		
		int i = 0;
		saida += "<ol class=\"carousel-indicators\">";
		try {
			while(rss.next()) {
				if(i == 0) {
					saida += "<li data-target=\"#indicador\" data-slide-to="+i+" class=\"active\"></li>";
				}
				else {
					saida += "<li data-target=\"#indicador\" data-slide-to="+i+"></li>";
				}
				i++;
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		saida += "</ol>";
		

		ResultSet rs = this.dbQuery.selectPromocao("PROMOCAO = 1 group by lo.nome");
		saida += "<div class=\"carousel-inner\">";
		i = 0;
		try {
			while(rs.next()) {
				if(i == 0) {
				saida += "<div class=\"carousel-item active\">\r\n" + 
						"<a href=passagens.jsp?idpassagem="+rs.getString("passagem")+">"+
						"  <img class=\"d-block w-100\" src=" + rs.getString("URL") + " style=\"height:380px; width:350px;\">\r\n" + 
						"</a>" +
						" <div class=\"carousel-caption d-none d-md-block\">" +
						"<h4>" + rs.getString("nome") + "</h4>" +
						"<p>" + "preço a partir de: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) + "<p>" +
						" </div> </div>";
				}
				else {
					saida += "<div class=\"carousel-item\">\r\n" + 
							"<a href=passagens.jsp?idpassagem="+rs.getString("passagem")+">"+
							"  <img class=\"d-block w-100\" src=" + rs.getString("URL") + " style=\"height:380px; width:350px;\">\r\n" + 
							"</a>" +
							" <div class=\"carousel-caption d-none d-md-block\">" +
							"<h4>" + rs.getString("nome") + "</h4>" +
							"<p>" + "preço a partir de: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) + "<p>" +
							" </div> </div>";
				}
				i++;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		saida +="</div>";
	
		saida += "  <a class=\"carousel-control-prev\" href=\"#indicador\" role=\"button\" data-slide=\"prev\">\r\n" + 
				"    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n" + 
				"    <span class=\"sr-only\">Previous</span>\r\n" + 
				"  </a>\r\n" + 
				"  <a class=\"carousel-control-next\" href=\"#indicador\" role=\"button\" data-slide=\"next\">\r\n" + 
				"    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n" + 
				"    <span class=\"sr-only\">Next</span>\r\n" + 
				"  </a>\r\n" + 
				"</div>";
		
		return (saida);
	}
	
	
	public String CarouselCards() {
		ResultSet rs = this.dbQuery.selectPromocao("PROMOCAO = 0 group by lo.nome");
		
		String saida = "<div id=\"inam\" class=\"carousel slide\" data-ride=\"carousel\">"; 
		saida += "	<div class=\"carousel-inner\">\r\n";
		
		
		int i = 0;
		try {
			while(rs.next()) {
				if(i == 0) {
					saida += "<div class=\"carousel-item active dr\">\r\n" + 
							"	<div class=\"container\">\r\n" + 
							"		<div class=\"row\">";
				}else if(i % 3 == 0) {
					saida += "<div class=\"carousel-item dr\">\r\n" + 
							"	<div class=\"container\">\r\n" + 
							"		<div class=\"row\">";
				}
				i++;
				saida += "<div class=\"col-3 col-lg-3\">\r\n" + 
						"	<div class=\"card\" style=\"width: 100%;height: 100%;margin: auto;\">\r\n" + 
						"	<img src=" + rs.getString("URL") + " class=\"card-img-top\">\r\n" + 
						"	<div class=\"card-body\">\r\n" + 
						"		<h2 class=\"card-title\">" + rs.getString("nome") + "</h2>" + 
						"		<p class=\"card-text\">" +"<h6>Preço a partir de: "+ NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) +"</h6></p>\r\n" +
						"			<a href=passagens.jsp?idpassagem=" + rs.getString("passagem") + ">" +
						"		<button type=\"button\" class=\"btn btn-warning\">Detalhes</button>\r\n" + 
						"			</a>" +
						"		</div>" + 
						"	</div>" + 
						"</div>";
				
				if(i % 3 == 0) {
					saida += "</div>\r\n" + 
							"</div>\r\n" + 
							"</div>";
				}
			}
		saida += "</div></div></div>";
			
			
		saida += "<a href=\"#inam\" class=\"carousel-control-prev\" data-slide=\"prev\">\r\n" + 
					"<span class=\"carousel-control-prev-icon\"></span>\r\n" + 
				"</a>\r\n" + 
				"<a href=\"#inam\" class=\"carousel-control-next\" data-slide=\"next\">\r\n" + 
				"	<span class=\"carousel-control-next-icon\"></span>\r\n" + 
				"</a>\r\n" + 
				"</div>";	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (saida);
	}

	public String destino (String idpassagem) {
		ResultSet rs = this.dbQuery.destino ("passagem.idPassagem = '" + idpassagem + "'");
		String saida = null;

		try {
			while (rs.next ()) {
				saida = rs.getString ("nome");
			}
		} catch (SQLException e) {
			// TODO bloco de captura gerado automaticamente
			e.printStackTrace ();
		}

		return (saida);
	}
	
	public String passagemDisponivel() {
		ResultSet rs = this.dbQuery.selectPassagem("");
		String saida = "<select id=\"cxpassagem\" name=\"cxpassagem\" class=\"form-control\">";
		try {
			while(rs.next()) {
				saida += "<option value="+ rs.getInt("idPassagem")+">"+ rs.getString("nome") + "</option>";
			}
			saida += "</select>";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return(saida);
	}
	
	
	public String selectPassagem() {
		ResultSet rs = this.dbQuery.selectPassagem("");
		String saida = "";

		try {
			while(rs.next()) {
				saida += "<div class=\"col-md-3 mt-3\">\r\n" + 
						"		<div class=\"card\">\r\n" + 
						"		  <div class=\"card-body\">\r\n" + 
						"		<div class=\"col text-center\">" +
						"			<img src=\"img/globo.png\" class=\"bloco\" >" +
						"		</div>" + 
						"		<div class=\"row mt-1\">\r\n" + 
						"			<div class=\"col-md-12\">" +
						"		    <h6 class=\"card-text\">Nome do lugar: "+rs.getString("nome")+ "</h6>\r\n" + 
						"			</div>" +
						"		</div>" +
						"		<div class=\"row mt-1\">\r\n" + 
						"			<div class=\"col-md-12\">" +
						"		    	<h6 class=\"card-text\">Promoção (destaque index): "+(rs.getInt("promocao")==0?"Não":"Sim")+ "</h6>\r\n" + 
						"			</div>" +
						"		</div>" +
						"		<div class=\"row justify-content-center mt-2 \">" +
						"			<div class=\"col-3 text-center\">\r\n" + 
						"				<a href="+"excluirpassagem.jsp?idpassagem="+rs.getInt("id")+">" +
						"					<button type=\"button\" class=\"btn btn-primary excluirpassagem\" data-toggle=\"modal\" data-target=\"#myModal\">\r\n" + 
						"						Excluir" +
						"					</button>\r\n"+
						"				</a>" +
						"		</div></div>  </div>\r\n" + 
						"		</div>\r\n" + 
						"</div>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		saida += "</div>";
		return(saida);
	}
	

	public void deletePassagem() {
		ResultSet rs = this.dbQuery.quantidadePassagem("passagem.idPassagem="+this.getIdPassagem());
		int qntd = 0;
		try {
			while(rs.next()) {
				qntd = rs.getInt("qntd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(qntd >= 1) {
			this.dbQuery.deleteLinha("idPassagem="+ "" + this.getIdPassagem());
			this.dbQuery.deletePassagem("idPassagem=" + "" + this.getIdPassagem());
		}else {
			this.dbQuery.deletePassagem("idPassagem=" + "" + this.getIdPassagem());
		}

	}
	
	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public int getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(int idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public int getPromocao() {
		return promocao;
	}

	public void setPromocao(int promocao) {
		this.promocao = promocao;
	}
	
}
