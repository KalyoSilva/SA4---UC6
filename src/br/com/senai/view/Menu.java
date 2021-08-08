package br.com.senai.view;

import java.util.Scanner;

public class Menu {


	public void menu() {
		
		// utilizando StringBuilder por pura estética.
		StringBuilder builder = new StringBuilder();
		Scanner read = new Scanner(System.in);
		builder.append("------------------------------------------|\n");
		builder.append("                  MENU                    |\n");
		builder.append("------------------------------------------|\n");
		builder.append("(1) Gerenciamento de Produtos \n");
		builder.append("(2) Gerenciamento de Compra e Venda \n");
		builder.append("(3) Sair \n");
		builder.append("------------------------------------------|\n");
		builder.append("Escolha uma op��o: ");
		System.out.print(builder.toString());
		
		
		// Switch utilizado para as opções do menu
		switch(read.nextInt()) {
		case 1:
			GerenciamentoDeProduto ger = new GerenciamentoDeProduto();
			ger.menuGerenciamento();
			break;
		case 2:
			//Case 2 para pr�xima atividade utilizando banco de dados e interface. 
			break;
		case 3:
			break;
		default:
			break;
		}
		
		read.close();
	}
}
	
