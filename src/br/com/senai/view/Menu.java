package br.com.senai.view;

import java.util.Scanner;

public class Menu {


	public static void menu() {
		
		// utilizando StringBuilder por pura est�tica.
		StringBuilder builder = new StringBuilder();
		Scanner read = new Scanner(System.in);
		builder.append("------------------------------------------|\n");
		builder.append("                  MENU                    |\n");
		builder.append("------------------------------------------|\n");
		builder.append("(1) Gerenciamento de Produtos \n");
		builder.append("(2) Gerenciamento de Usu�rios \n");
		builder.append("(3) Sair \n");
		builder.append("\n");
		builder.append("Escolha uma op��o: ");
		System.out.print(builder.toString());
		
		
		// Switch utilizado para as op��es do menu
		switch(read.nextInt()) {
		case 1:
			GerenciamentoDeProduto ger = new GerenciamentoDeProduto();
			ger.menuGerenciamento();
			break;
		case 2:
			if(Login.flag == false) {
				GerenciamentoDePessoa gerPes = new GerenciamentoDePessoa();
				gerPes.menuPessoa();
				break;
			}
			else {
				System.out.println("Usu�rio inv�lido.");
				menu();
			}
		case 3:
			break;
		default:
			menu();
		}
		read.close();
	}
}
	
