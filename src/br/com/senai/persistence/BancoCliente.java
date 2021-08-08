package br.com.senai.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Cliente;

public class BancoCliente {
	
	public static List<Cliente> clientes = new ArrayList<>();
	
	private static Scanner read = new Scanner(System.in);
	
	// Adicionar funcionário a lista de funcionários.
	public static void adicionaCliente(Cliente client) {
		clientes.add(client);
	}
		
	public List<Cliente> getFuncionario(){
		return clientes;
	}
	
	public static void listaUsers() { // Mostra os itens cadastrados em um formato de lista
		System.out.println("------------------------------------------|");
		System.out.println("          CLIENTES CADASTRADOS            |");
		System.out.println("------------------------------------------|");
		for(int i = 0; i < clientes.size() && clientes.size() > 0; i++) {
			System.out.println("["+clientes.get(i).getIdCliente()+"]"+"->"+clientes.get(i).getNome());
		}
		System.out.println("["+(clientes.size()+1)+"]->Sair");
			
	}
	
	public static void expandUsers() {
		
		System.out.println("------------------------------------------|");
		System.out.print("Expandir item: ");
		try {
			int expand = Integer.parseInt(read.next());
			if(expand <= clientes.size() && expand > 0) {
				System.out.println("------------------------------------------|");
				System.out.println("Nome: "+clientes.get(expand-1).getNome());
				System.out.println("Senha: "+clientes.get(expand-1).getSenha());
				System.out.println("Admin: "+clientes.get(expand-1).isPermissoes());
			}
			else if(expand == (clientes.size()+1)) {
					
			}
			else {
				System.out.println("------------------------------------------|");
				System.out.print("Comando inválido, tente novamente. \n");		
			}
		}catch(Exception e) {
			System.out.println("------------------------------------------|");
			System.out.print("Comando inválido, tente novamente. \n");		
		}
		
	}

	public static void removerUser(int remove) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getIdCliente() == remove) { // Metodo utilizado para remover item do estoque. 
				clientes.remove(i);
			}
		}
		
	}

}
