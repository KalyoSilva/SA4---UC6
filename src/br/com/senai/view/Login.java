package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Funcionario;
import br.com.senai.persistence.BancoFuncionario;

public class Login {

	public static void main(String[] args) {
		
			conexao con = new conexao();
			String sql = "INSERT INTO item (idItem, NomeItem, QtdItem, ValorItem, Descricaoitem)"+
					     "VALUES (1,'Mesa',30,200,'Leve')";
			con.executaSQL(sql);
			boolean flag = true; // Flag para verificar Admin.
		
			// Input de usu�rio e senha.
			Scanner read = new Scanner(System.in);
			System.out.print("------------------------------------------|");
			System.out.print("\n                  LOGIN                   |");
			System.out.print("\n------------------------------------------|");
			while(true) {
				System.out.print("\nInforme o usu�rio:");
				String user = read.next();
				System.out.print("Informe a Senha:");
				String senha = read.next();
				// Por enquanto n�o existe sistema de cadastro e login, por isso s� estamos utilizando administrador.
			
				BancoFuncionario banco = new BancoFuncionario(); // Declarando banco na classe BancoFuncionario.
				List<Funcionario> lista = new ArrayList<>(); // Declarando lista de funcion�rios com o tipo arraylist.
				lista = banco.getFuncionario(); // Lista est� pegando os funcion�rios cadastrados.
				
				
				// For each
				for (Funcionario funcionario : lista) {
					
					// Condi��o para valida��o de usu�rio Administrador.			
					if(funcionario.getNome().equals(user) && funcionario.getSenha().equals(senha)) {
						System.out.println("\nAdministrador Logado!\n");
						Menu.menu();
						flag = false;
						break;
					}
				}
				
				// Condi��o para usu�rio administrador inv�lido (Utilizando flag).
				
				if(flag) {
					System.out.println("\nUsu�rio ou senha incorreto");
				}
				else {
					break;
				}
				
		}
			read.close();
	}
	
}
