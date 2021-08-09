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
		
		// Op��es de gerenciamento.
		
		StringBuilder builder = new StringBuilder();
		System.out.print("------------------------------------------|\n");
		builder.append("(1) Adicionar Item \n");
		builder.append("(2) Remover Item\n");
		builder.append("(3) Consultar Item\n");
		builder.append("(4) Voltar \n");
		builder.append(" \nEscolha uma op��o: ");
		System.out.print(builder);
		
		// Switch utilizado para as op��es de gerenciamento.
		switch (read.nextInt()) {
		case 1:
			adicionarProduto();
			menuGerenciamento();
			break;
		case 2:
			removerProduto();
			menuGerenciamento();
			break;
		case 3:
			listarProduto();
			menuGerenciamento();
			break;
		case 4:
			Menu.menu();
			break;
		default:
			System.out.println("Comando inv�lido, tente novamente!");
			break;
		}

	}
	
	// Adiciona um novo produto do tipo item.
	
	private void adicionarProduto() {
		try {
			// Nome, quantidade, valor, descri��o e id sendo adicionados ao item.
			System.out.print("------------------------------------------|");
			Item item = new Item();
			System.out.print("\nInforme o nome do produto: ");
			read.nextLine();
			item.setNome(read.nextLine());
			System.out.print("Informe a quantidade do produto: ");
			item.setQtd(read.nextInt());
			System.out.print("Informe o valor do produto: ");
			item.setValorUnidade(read.nextFloat());
			read.nextLine();
			System.out.print("Informe a descri��o do produto: ");
			item.setDesc(read.nextLine());
			item.setId(BancoItem.itens.size()+1);
			// Item sendo adicionado ao banco
			banco.adicionarItem(item);
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inv�lido
		}
	}

	private void removerProduto() {
		
		if(BancoItem.itens.size() > 0) {
		//Mostrando uma lista de itens cadastrados, permitindo o usu�rio escolher o item que deseja remover atrav�s do id.
		//Obs. o usu�rio ir� sair do aplicativo se digitar um n�mero maior do que o tamanho do Array do banco ou valor inv�lido.
		banco.getItens();
		System.out.println("------------------------------------------|");
		System.out.print("Informe o item que deseja remover: ");
		try {
			int remove = Integer.parseInt(read.next());
			if(remove <= BancoItem.itens.size() && remove > 0) {
				BancoItem.removerItem(remove);
				System.out.println("item removido com Sucesso!");
			}
			else if(remove == (BancoItem.itens.size()+1)) {
			}
			else {
				System.out.print("Comando inv�lido, tente novamente. \n");		
			}
		}catch(Exception e){
			
			System.out.print("Comando inv�lido, tente novamente. \n");
			
		}
		} else {
			System.out.println("------------------------------------------|");
			System.out.print("Nenhum item cadastrado no estoque!\n");	
		}
	}


	private void listarProduto() {
		if(BancoItem.itens.size() > 0) {
		//Mostrando uma lista de itens cadastrados, permitindo o usu�rio escolher o item que deseja expandir atrav�s do id.
		banco.getItens();
		banco.ExpandItem();
		}
		else {
			System.out.println("------------------------------------------|");
			System.out.print("Nenhum item cadastrado no estoque!\n");	
		}
		
	}

}
