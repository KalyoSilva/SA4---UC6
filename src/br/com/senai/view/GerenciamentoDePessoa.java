package br.com.senai.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.senai.model.Cliente;
import br.com.senai.model.Funcionario;
import br.com.senai.persistence.BancoCliente;
import br.com.senai.persistence.BancoFuncionario;

public class GerenciamentoDePessoa {
	private Scanner read = new Scanner(System.in);

	public void menuPessoa() {
		
		// Opções de gerenciamento.
		
		StringBuilder builder = new StringBuilder();
		System.out.print("------------------------------------------|\n");
		builder.append("(1) Cadastrar Usuário \n");
		builder.append("(2) Remover Usuário\n");
		builder.append("(3) Consultar Usuários\n");
		builder.append("(4) Logar Usuário\n");
		builder.append("(5) Voltar \n");
		builder.append(" \nEscolha uma opção: ");
		System.out.print(builder);
		
		// Switch utilizado para as opções de gerenciamento.
		switch (read.nextInt()) {
		case 1:
			addPessoa();
			break;
		case 2:
			removePessoa();
			break;
		case 3:
			consultaPessoa();
			break;
		case 4:
			System.out.println("essa função irá ser adicionada quando\nimplementarmos o banco de dados.");
			break;
		case 5:
			Menu menu = new Menu();
			menu.menu();
			break;
		default:
			System.out.println("Comando inválido, tente novamente!");
			break;
		}
		menuPessoa();
		read.nextLine();

	}
	
	private void removePessoa() {
		try {
			// Selecionando entre criar um cliente ou funcinário
			System.out.print("------------------------------------------|\n");
			System.out.print("tipo (C - Cliente / F - Funcionário): ");
			read.nextLine();
			String tipoUser = read.nextLine();
			if(tipoUser.equals("C") || tipoUser.equals("c")){
				Cliente.removeCliente();
			}
			else if(tipoUser.equals("F") || tipoUser.equals("f")) {
				Funcionario.removeFuncio();
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inválido
		}
	}

	public void addPessoa() {
		
		try {
			// Selecionando entre criar um cliente ou funcinário
			System.out.print("------------------------------------------|\n");
			System.out.print("tipo (C - Cliente / F - Funcionário): ");
			read.nextLine();
			String tipoUser = read.nextLine();
			if(tipoUser.equals("C") || tipoUser.equals("c")){
				Cliente.addCliente();
			}
			else if(tipoUser.equals("F") || tipoUser.equals("f")) {
				Funcionario.addFuncionario();
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inválido
		}
		
	}
	
	public void consultaPessoa() {
		
		try {
			// Selecionando entre criar um cliente ou funcinário
			System.out.print("------------------------------------------|\n");
			System.out.print("tipo (C - Cliente / F - Funcionário): ");
			read.nextLine();
			String tipoUser = read.nextLine();
			if(tipoUser.equals("C") || tipoUser.equals("c")){
				BancoCliente.listaUsers();
				BancoCliente.expandUsers();
			}
			else if(tipoUser.equals("F") || tipoUser.equals("f")) {
				BancoFuncionario.listaFuncio();
				BancoFuncionario.expandFuncio();
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inválido
		}
		
	}
}
