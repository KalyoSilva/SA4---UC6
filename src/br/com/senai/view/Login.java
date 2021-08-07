package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Funcionario;
import br.com.senai.persistence.BancoFuncionario;

public class Login {

	public static void main(String[] args) {

		// Input de usu�rio e senha.
		Scanner read = new Scanner(System.in);
		System.out.print("Informe o usu�rio:");
		String user = read.next();
		System.out.print("Informe a senha:");
		String senha = read.next();
		
		// Por enquanto n�o existe sistema de cadastro e login, por isso s� estamos utilizando administrador.
		
		BancoFuncionario banco = new BancoFuncionario(); // Declarando banco na classe BancoFuncionario.
		List<Funcionario> lista = new ArrayList<>(); // Declarando lista de funcion�rios com o tipo arraylist.
		lista = banco.getFuncionario(); // Lista est� pegando os funcion�rios cadastrados.
		
		boolean flag = true; // Declarando variavel flag.
		
		// For each
		for (Funcionario funcionario : lista) {
			
			// Condi��o para valida��o de usu�rio Administrador.			
			if(funcionario.getNome().equals(user) && funcionario.getSenha().equals(senha)) {
				System.out.println("Usu�rio Validado \n\n");
				Menu menu = new Menu();
				menu.menu();
				flag = false;
				break;
			}
		}
		
		// Condi��o para usu�rio administrador inv�lido (Utilizando flag).
		
		if(flag) {
			System.out.println("Usu�rio ou senha incorreto");
		}
		
		read.close();
	}
	

	
}
