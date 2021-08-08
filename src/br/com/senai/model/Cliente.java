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
			//Mostrando uma lista de itens cadastrados, permitindo o usuário escolher o item que deseja remover através do id.
			//Obs. o usuário irá sair do aplicativo se digitar um número maior do que o tamanho do Array do banco ou valor inválido.
			BancoCliente.listaUsers();
			System.out.println("------------------------------------------|");
			System.out.print("Informe o funcionario que deseja remover: ");
			try {
				int remove = Integer.parseInt(read.next());
				if(remove <= BancoCliente.clientes.size() && remove > 0) {
					BancoCliente.removerUser(remove);
					System.out.println("Usuário removido com Sucesso!");
				}
				else if(remove == (BancoCliente.clientes.size()+1)) {
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

}
