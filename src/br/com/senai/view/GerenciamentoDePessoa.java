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
		
		// Op��es de gerenciamento.
		
		StringBuilder builder = new StringBuilder();
		System.out.print("------------------------------------------|\n");
		builder.append("(1) Cadastrar Usu�rio \n");
		builder.append("(2) Remover Usu�rio\n");
		builder.append("(3) Consultar Usu�rios\n");
		builder.append("(4) Logar Usu�rio\n");
		builder.append("(5) Voltar \n");
		builder.append(" \nEscolha uma op��o: ");
		System.out.print(builder);
		
		// Switch utilizado para as op��es de gerenciamento.
		switch (read.nextInt()) {
		case 1:
			addPessoa();
			menuPessoa();
			break;
		case 2:
			removePessoa();
			menuPessoa();
			break;
		case 3:
			consultaPessoa();
			menuPessoa();
			break;
		case 4:
			System.out.println("essa fun��o ir� ser adicionada quando\nimplementarmos o banco de dados.");
			menuPessoa();
			break;
		case 5:
			Menu.menu();
			break;
		default:
			System.out.println("Comando inv�lido, tente novamente!");
			break;
		}

	}
	
	private void removePessoa() {
		try {
			// Selecionando entre criar um cliente ou funcin�rio
			System.out.print("------------------------------------------|\n");
			System.out.print("tipo (C - Cliente / F - Funcion�rio): ");
			read.nextLine();
			String tipoUser = read.nextLine();
			if(tipoUser.equals("C") || tipoUser.equals("c")){
				Cliente.removeCliente();
			}
			else if(tipoUser.equals("F") || tipoUser.equals("f")) {
				Funcionario.removeFuncio();
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inv�lido
		}
	}

	public void addPessoa() {
		
		try {
			// Selecionando entre criar um cliente ou funcin�rio
			System.out.print("------------------------------------------|\n");
			System.out.print("tipo (C - Cliente / F - Funcion�rio): ");
			read.nextLine();
			String tipoUser = read.nextLine();
			if(tipoUser.equals("C") || tipoUser.equals("c")){
				if(BancoCliente.clientes.size() > 0) {
				Cliente.addCliente();
				}
				else {
					System.out.println("------------------------------------------|");
					System.out.print("Nenhum cliente cadastrado no sistema!\n");	
				}
			}
			else if(tipoUser.equals("F") || tipoUser.equals("f")) {
				if(BancoCliente.clientes.size() > 0) {
				Funcionario.addFuncionario();
				}
				else {
					System.out.println("------------------------------------------|");
					System.out.print("Nenhum funcion�rio cadastrado no sistema!\n");	
				}
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inv�lido
		}
		
	}
	
	public void consultaPessoa() {
		
		try {
			// Selecionando entre criar um cliente ou funcin�rio
			System.out.print("------------------------------------------|\n");
			System.out.print("tipo (C - Cliente / F - Funcion�rio): ");
			read.nextLine();
			String tipoUser = read.nextLine();
			if(tipoUser.equals("C") || tipoUser.equals("c")){
				if(BancoCliente.clientes.size() > 0) {
					BancoCliente.listaUsers();
					BancoCliente.expandUsers();
				}
				else {
					System.out.println("------------------------------------------|");
					System.out.print("Nenhum cliente cadastrado no sistema!\n");	
				}
			}
			else if(tipoUser.equals("F") || tipoUser.equals("f")) {
				if(BancoCliente.clientes.size() > 0) {
				BancoFuncionario.listaFuncio();
				BancoFuncionario.expandFuncio();
				}
				else {
					System.out.println("------------------------------------------|");
					System.out.print("Nenhum funcion�rio cadastrado no sistema!\n");	
				}
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Se der um valor inv�lido
		}
		
	}
}
