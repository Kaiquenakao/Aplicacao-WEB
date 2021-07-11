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
	private String where = "";
	private DBQuery dbQuery = null;
	
	Locale ptBr = new Locale("pt", "BR");
	
	public Passagem() {
		this.tableName = "passagem";
		this.fieldsName = "idPassagem, idLocalizacao, promocao";
		this.keyField = "idPassagem";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);
	}
	
	public Passagem(String idLocalizacao, String Promocao) {
		this.tableName = "passagem";
		this.fieldsName = "idPassagem, idLocalizacao, promocao";
		this.keyField = "idPassagem";
		this.dbQuery = new DBQuery(this.tableName, this.fieldsName, this.keyField);


	}
	
	public void save() {
		this.dbQuery.insert(this.toArray());
	}
	
	public String[] toArray() {
		return(
			new String[] {
				""+this.getIdLocalizacao(),
				""+this.getPromocao()
			}
		);
	}

	
	public String CarouselPromocao() {
		ResultSet rss = this.dbQuery.selectPromocao("PROMOCAO = 1 and la.preco in (SELECT min(preco) from linha_aerea la group by la.idPassagem)");
		String saida = "<div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">";
		
		int i = 0;
		saida += "<ol class=\"carousel-indicators\">";
		try {
			while(rss.next()) {
				if(i == 0) {
					saida += "<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>";
				}
				else {
					saida += "<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>";
				}
				i++;
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		saida += "</ol>";
		

		ResultSet rs = this.dbQuery.selectPromocao("PROMOCAO = 1 and la.preco in (SELECT min(preco) from linha_aerea la group by la.idPassagem)");
		saida += "<div class=\"carousel-inner\">";
		i = 0;
		try {
			while(rs.next()) {
				if(i == 0) {
				saida += "<div class=\"carousel-item active\">\r\n" + 
						"  <img class=\"d-block w-100\" src=" + rs.getString("URL") + " style=\"height:380px; width:350px;\">\r\n" + 
						" <div class=\"carousel-caption d-none d-md-block\">" +
						"<h4>" + rs.getString("nome") + "</h4>" +
						"<p>" + "pre�o a partir de: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) + "<p>" +
						" </div> </div>";
				}
				else {
					saida += "<div class=\"carousel-item\">\r\n" + 
							"  <img class=\"d-block w-100\" src=" + rs.getString("URL") + " style=\"height:380px; width:350px;\">\r\n" + 
							" <div class=\"carousel-caption d-none d-md-block\">" +
							"<h4>" + rs.getString("nome") + "</h4>" +
							"<p>" + "pre�o a partir de: " + NumberFormat.getCurrencyInstance(ptBr).format(rs.getFloat("preco")) + "<p>" +
							" </div> </div>";
				}
				i++;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		saida +="</div>";
	
		saida += "  <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\r\n" + 
				"    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n" + 
				"    <span class=\"sr-only\">Previous</span>\r\n" + 
				"  </a>\r\n" + 
				"  <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\r\n" + 
				"    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n" + 
				"    <span class=\"sr-only\">Next</span>\r\n" + 
				"  </a>\r\n" + 
				"</div>";
		
		return (saida);
	}
	
	
	public String CarouselCards() {
		ResultSet rs = this.dbQuery.selectPromocao("PROMOCAO = 0 and la.preco in (SELECT min(preco) from linha_aerea la group by la.idPassagem)");
		
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
							"<div class=\"container\">\r\n" + 
							"<div class=\"row\">";
				}
				

				
				i++;
				saida += "<div class=\"col-3 col-lg-3\">\r\n" + 
						"	<div class=\"card\" style=\"width: 100%;height: 100%;margin: auto;\">\r\n" + 
						"	<img src=" + rs.getString("URL") + " class=\"card-img-top\">\r\n" + 
						"	<div class=\"card-body\">\r\n" + 
						"		<h2 class=\"card-title\">" + rs.getString("nome") + "</h2>" + 
						"		<p class=\"card-text\">Skin masks help us to make are skin fresh and also they protect our skin from the harm rays of sun</p>\r\n" +
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
		saida += "</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
			
			
		saida += "<a href=\"#inam\" class=\"carousel-control-prev\" data-slide=\"prev\">\r\n" + 
					"<span class=\"carousel-control-prev-icon\"></span>\r\n" + 
				"</a>\r\n" + 
				"<a href=\"#inam\" class=\"carousel-control-next\" data-slide=\"next\">\r\n" + 
				"<span class=\"carousel-control-next-icon\"></span>\r\n" + 
				"</a>\r\n" + 
				"</div>";
		

		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (saida);
	}
	
	
	
	public String idPassagem() {
		ResultSet rs = this.dbQuery.selectID("idPassagem=(select max(idPassagem) from passagens)");
		String id = "";
		try {
			while(rs.next()) {
				id = rs.getString("idPassagem");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return (id);
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