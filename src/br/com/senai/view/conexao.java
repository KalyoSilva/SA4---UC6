package br.com.senai.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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

}