package br.com.senai.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.senai.model.Item;

public class conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	conexao(){
		url = "jdbc:postgresql://localhost:5432/estoque";
		usuario = "postgres";
		senha = "2322";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão Realizada com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao Conectar com o Banco!");
		}
	}
	
	public void executaSQL(String sql) {
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Erro ao Conectar com o Banco!");
			e.printStackTrace();
		}
	}
	public void getSQL() {
		try {
			PreparedStatement stm = con.prepareStatement("select * from item");
			ResultSet rs =  stm.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				
				item.setId(rs.getInt("iditem"));
				item.setNome(rs.getString("nomeitem"));
				item.setQtd(rs.getInt("qtditem"));
				item.setValorUnidade(rs.getInt("valoritem"));
				item.setDesc(rs.getString("descricaoitem"));	
				GerenciamentoDeProduto.banco.adicionarItem(item);
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Erro ao Conectar com o Banco!");
			e.printStackTrace();
		}
	}

}