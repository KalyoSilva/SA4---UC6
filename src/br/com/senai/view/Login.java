package br.com.senai.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Cliente;
import br.com.senai.model.Funcionario;
import br.com.senai.persistence.BancoCliente;
import br.com.senai.persistence.BancoFuncionario;

public class Login {

	public static boolean flag;
	public static boolean flag2;

	public static void main(String[] args) {
		
			conexao con = new conexao();
			con.getSQL();
			flag = true; // Flag para verificar Admin.
			flag2 = true;
		
			// Input de usuário e senha.
			Scanner read = new Scanner(System.in);
			System.out.print("------------------------------------------|");
			System.out.print("\n                  LOGIN                   |");
			System.out.print("\n------------------------------------------|");
			while(true) {
				System.out.print("\nInforme o usuário:");
				String user = read.next();
				System.out.print("Informe a Senha:");
				String senha = read.next();
				// Por enquanto não existe sistema de cadastro e login, por isso só estamos utilizando administrador.
			
				BancoFuncionario banco = new BancoFuncionario(); // Declarando banco na classe BancoFuncionario.
				List<Funcionario> lista = new ArrayList<>(); // Declarando lista de funcionários com o tipo arraylist.
				lista = banco.getFuncionario(); // Lista está pegando os funcionários cadastrados.
				
				
				// For each
				for (Funcionario funcionario : lista) {
					
					// Condição para validação de usuário Administrador.			
					if(funcionario.getNome().equals(user) && funcionario.getSenha().equals(senha)) {
						System.out.println("\nAdministrador Logado!\n");
						Menu.menu();
						flag = false;
						break;
					}
				}
				
				BancoCliente bancoC = new BancoCliente(); // Declarando banco na classe BancoFuncionario.
				List<Cliente> listaC = new ArrayList<>(); // Declarando lista de funcionários com o tipo arraylist.
				listaC = bancoC.getClientes(); // Lista está pegando os funcionários cadastrados.
				
				for (Cliente client : listaC) {
					
					// Condição para validação de usuário Administrador.			
					if(client.getNome().equals(user) && client.getSenha().equals(senha)) {
						System.out.println("\ncliente Logado!\n");
						Menu.menu();
						flag2 = false;
						break;
					}
				}
				
				// Condição para usuário administrador inválido (Utilizando flag).
				
				if(flag && flag2) {
					System.out.println("\nUsuário ou senha incorreto");
				}
				else {
					break;
				}
				
		}
			read.close();
	}
	
}
