package br.com.senai.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.senai.model.Item;
import br.com.senai.persistence.BancoItem;

public class GerenciamentoDeProduto {
	
	// Criando banco na classe BancoItem.
	private BancoItem banco = new BancoItem();
	private Scanner read = new Scanner(System.in);

	public void menu() {
		
		// Opções de gerenciamento.
		
		StringBuilder builder = new StringBuilder();
		builder.append("(1) Adicionar \n");
		builder.append("(2) Remover \n");
		builder.append("(3) Consultar \n");
		builder.append("(4) Listar \n");
		builder.append("(5) Voltar \n");
		builder.append("Escolha uma opção: ");
		System.out.println(builder);
		
		// Switch utilizado para as opções de gerenciamento.
		switch (read.nextInt()) {
		case 1:
			adicionarProduto();
			break;
		case 2:
			removerProduto();
			break;
		case 3:
			consultarProduto();
			
			break;
		case 4:
			listarProduto();
			break;
		case 5:
			Menu menu = new Menu();
			menu.menu();
			break;
		default:
			System.out.println("Comando inválido, tente novamente.");
			break;
		}
		menu();
		

	}
	
	// Adiciona um novo produto do tipo item.
	
	private void adicionarProduto() {
		try {
			// Nome, quantidade, valor, descrição, sendo adicionados ao item.
			Item item = new Item();
			System.out.print("Informe o nome do produto: ");
			item.setNome(read.next());
			System.out.print("\nInforme a quantidade do produto: ");
			item.setQtd(read.nextInt());
			System.out.print("\nInforme o valor do produto: ");
			item.setValorUnidade(read.nextFloat());
			System.out.print("\nInforme a descrição do produto: ");
			item.setDesc(read.next());
			// Item sendo adicionado ao banco
			banco.adicionarItem(item);
			
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inválido
			ex.printStackTrace();
		}
	}

	private void removerProduto() {
		// Precisa ser feito.
	}

	private void consultarProduto() {
		// Precisa ser feito.
	}

	private void listarProduto() {
		// Precisa ser feito.
	}

}
