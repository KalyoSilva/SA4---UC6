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
		System.out.print("------------------------------------------|\n");
		builder.append("(1) Adicionar Item \n");
		builder.append("(2) Remover Item\n");
		builder.append("(3) Consultar Item\n");
		builder.append("(4) Voltar \n");
		builder.append(" \nEscolha uma opção: ");
		System.out.print(builder);
		
		// Switch utilizado para as opções de gerenciamento.
		switch (read.nextInt()) {
		case 1:
			if(Login.flag == false) {
				adicionarProduto();
				menuGerenciamento();
			break;
			}
			else {
				System.out.println("Usuário inválido.");
				menuGerenciamento();
				break;
			}
		case 2:
			if(Login.flag == false) {
			removerProduto();
			menuGerenciamento();
			break;
			}
			else {
				System.out.println("Usuário inválido.");
				menuGerenciamento();
				break;
			}
		case 3:
			listarProduto();
			menuGerenciamento();
			break;
		case 4:
			Menu.menu();
			break;
		default:
			System.out.println("Comando inválido, tente novamente!");
			break;
		}

	}
	
	// Adiciona um novo produto do tipo item.
	
	private void adicionarProduto() {
		try {
			// Nome, quantidade, valor, descrição e id sendo adicionados ao item.
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
			System.out.print("Informe a descrição do produto: ");
			item.setDesc(read.nextLine());
			conexao con = new conexao();
			String sql = "INSERT INTO item (NomeItem, QtdItem, ValorItem, Descricaoitem)"+
					     "VALUES ('"+item.getNome()+"',"+item.getQtd()+","+item.getValorUnidade()+","+"'"+item.getDesc()+"')";
			con.executaSQL(sql);
			item.setId(BancoItem.itens.size()+1);

			// Item sendo adicionado ao banco
			banco.adicionarItem(item);
		} catch (InputMismatchException ex) {
			System.out.println("Um erro ocorreu, tente novamente."); // Caso de valor inválido
		}
	}

	private void removerProduto() {
		
		if(BancoItem.itens.size() > 0) {
		//Mostrando uma lista de itens cadastrados, permitindo o usuário escolher o item que deseja remover através do id.
		//Obs. o usuário irá sair do aplicativo se digitar um número maior do que o tamanho do Array do banco ou valor inválido.
		banco.getItens();
		System.out.println("------------------------------------------|");
		System.out.print("Informe o item que deseja remover: ");
		try {
			int remove = Integer.parseInt(read.next());
			if(remove <= BancoItem.itens.size() && remove > 0) {
				conexao con = new conexao();
				String sql = "DELETE FROM item WHERE iditem ="+remove;
				con.executaSQL(sql);
				BancoItem.removerItem(remove);
				System.out.println("item removido com Sucesso!");
			}
			else if(remove == (BancoItem.itens.size()+1)) {
			}
			else {
				System.out.print("Comando inválido, tente novamente. \n");		
			}
		}catch(Exception e){
			
			System.out.print("Comando inválido, tente novamente. \n");
			
		}
		} else {
			System.out.println("------------------------------------------|");
			System.out.print("Nenhum item cadastrado no estoque!\n");	
		}
	}


	private void listarProduto() {
		if(BancoItem.itens.size() > 0) {
		//Mostrando uma lista de itens cadastrados, permitindo o usuário escolher o item que deseja expandir através do id.
		banco.getItens();
		banco.ExpandItem();
		}
		else {
			System.out.println("------------------------------------------|");
			System.out.print("Nenhum item cadastrado no estoque!\n");	
		}
		
	}

}
