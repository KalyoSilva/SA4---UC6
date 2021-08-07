package br.com.senai.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.senai.model.Item;
import br.com.senai.persistence.BancoItem;

public class GerenciamentoDeProduto {
	
	// Criando banco na classe BancoItem.
	public static  BancoItem banco = new BancoItem();
	private Scanner read = new Scanner(System.in);

	public void menuGerenciamento() {
		
		// Opções de gerenciamento.
		
		StringBuilder builder = new StringBuilder();
		builder.append("(1) Adicionar \n");
		builder.append("(2) Remover \n");
		builder.append("(3) Consultar \n");
		builder.append("(4) Voltar \n");
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
			listarProduto();
			break;
		case 4:
			Menu menu = new Menu();
			menu.menu();
			break;
		default:
			System.out.println("Comando inválido, tente novamente.");
			break;
		}
		menuGerenciamento();
		

	}
	
	// Adiciona um novo produto do tipo item.
	
	private void adicionarProduto() {
		try {
			// Nome, quantidade, valor, descrição e id sendo adicionados ao item.
			Item item = new Item();
			System.out.print("Informe o nome do produto: ");
			item.setNome(read.next());
			read.nextLine();
			System.out.print("\nInforme a quantidade do produto: ");
			item.setQtd(read.nextInt());
			System.out.print("\nInforme o valor do produto: ");
			item.setValorUnidade(read.nextFloat());
			read.nextLine();
			System.out.print("\nInforme a descrição do produto: ");
			item.setDesc(read.nextLine());
			item.setId(BancoItem.itens.size()+1);
			// Item sendo adicionado ao banco
			banco.adicionarItem(item);
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inválido
			ex.printStackTrace();
		}
	}

	private void removerProduto() {
		
		//Mostrando uma lista de itens cadastrados, permitindo o usuário escolher o item que deseja remover através do id.
		//Obs. o usuário irá sair do aplicativo se digitar um número maior do que o tamanho do Array do banco ou valor inválido.
		banco.getItens();
		System.out.print("Remover item: ");
		try {
			int remove = Integer.parseInt(read.next());
			if(remove <= BancoItem.itens.size() && remove > 0) {
				BancoItem.removerItem(remove);
			}
			else if(remove == (BancoItem.itens.size()+1)) {
			}
			else {
				System.out.print("Comando inválido, tente novamente. \n");		
			}
		}catch(Exception e){
			
			System.out.print("Comando inválido, tente novamente. \n");
			
		}
	}


	private void listarProduto() {
		//Mostrando uma lista de itens cadastrados, permitindo o usuário escolher o item que deseja expandir através do id.
		banco.getItens();
		banco.ExpandItem();
		
	}

}
