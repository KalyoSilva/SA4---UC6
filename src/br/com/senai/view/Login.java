package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Funcionario;
import br.com.senai.persistence.BancoFuncionario;

public class Login {

	public static void main(String[] args) {

		// Input de usuário e senha.
		Scanner read = new Scanner(System.in);
		System.out.print("Informe o usuário:");
		String user = read.next();
		System.out.print("Informe a senha:");
		String senha = read.next();
		
		// Por enquanto não existe sistema de cadastro e login, por isso só estamos utilizando administrador.
		
		BancoFuncionario banco = new BancoFuncionario(); // Declarando banco na classe BancoFuncionario.
		List<Funcionario> lista = new ArrayList<>(); // Declarando lista de funcionários com o tipo arraylist.
		lista = banco.getFuncionario(); // Lista está pegando os funcionários cadastrados.
		
		boolean flag = true; // Declarando variavel flag.
		
		// For each
		for (Funcionario funcionario : lista) {
			
			// Condição para validação de usuário Administrador.			
			if(funcionario.getNome().equals(user) && funcionario.getSenha().equals(senha)) {
				System.out.println("Usuário Validado \n\n");
				Menu menu = new Menu();
				menu.menu();
				flag = false;
				break;
			}
		}
		
		// Condição para usuário administrador inválido (Utilizando flag).
		
		if(flag) {
			System.out.println("Usuário ou senha incorreto");
		}
		
		read.close();
	}
	

	
}
