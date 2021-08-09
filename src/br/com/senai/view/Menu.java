package br.com.senai.view;

import java.util.Scanner;

public class Menu {


	public static void menu() {
		
		// utilizando StringBuilder por pura est√©tica.
		StringBuilder builder = new StringBuilder();
		Scanner read = new Scanner(System.in);
		builder.append("------------------------------------------|\n");
		builder.append("                  MENU                    |\n");
		builder.append("------------------------------------------|\n");
		builder.append("(1) Gerenciamento de Produtos \n");
		builder.append("(2) Gerenciamento de Usu·rios \n");
		builder.append("(3) Sair \n");
		builder.append("\n");
		builder.append("Escolha uma opÁ„o: ");
		System.out.print(builder.toString());
		
		
		// Switch utilizado para as op√ß√µes do menu
		switch(read.nextInt()) {
		case 1:
			GerenciamentoDeProduto ger = new GerenciamentoDeProduto();
			ger.menuGerenciamento();
			break;
		case 2:
			GerenciamentoDePessoa gerPes = new GerenciamentoDePessoa();
			gerPes.menuPessoa();
			break;
		case 3:
			System.out.println("Programa Finalizado.");
			break;
		default:
			break;
		}
		read.close();
	}
}
	
