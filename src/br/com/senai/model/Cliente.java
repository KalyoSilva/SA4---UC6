package br.com.senai.model;

import java.util.Scanner;

import br.com.senai.persistence.BancoCliente;

public class Cliente extends Pessoa {
	
	public Cliente() {
		super(false);
	}
	
	public static BancoCliente banco = new BancoCliente();
	
	private int idCliente;
	private static Scanner read = new Scanner(System.in);
	
	public static void addCliente() {
		
		Cliente client = new Cliente();
		
		System.out.print("Informe o nome do Cliente: ");
		client.setNome(read.nextLine());
		System.out.print("Informe a senha do Cliente: ");
		client.setSenha(read.nextLine());
		client.setPermissoes(false);
		int idCliente = (BancoCliente.clientes.size()+1);
		client.setIdCliente(idCliente);
		BancoCliente.adicionaCliente(client);
		
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public static void removeCliente() {
		if(BancoCliente.clientes.size() > 0) {
			//Mostrando uma lista de itens cadastrados, permitindo o usu�rio escolher o item que deseja remover atrav�s do id.
			//Obs. o usu�rio ir� sair do aplicativo se digitar um n�mero maior do que o tamanho do Array do banco ou valor inv�lido.
			BancoCliente.listaUsers();
			System.out.println("------------------------------------------|");
			System.out.print("Informe o funcionario que deseja remover: ");
			try {
				int remove = Integer.parseInt(read.next());
				if(remove <= BancoCliente.clientes.size() && remove > 0) {
					BancoCliente.removerUser(remove);
					System.out.println("Usu�rio removido com Sucesso!");
				}
				else if(remove == (BancoCliente.clientes.size()+1)) {
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

}
