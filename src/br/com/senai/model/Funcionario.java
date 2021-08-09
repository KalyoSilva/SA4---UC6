package br.com.senai.model;

import java.util.Scanner;

import br.com.senai.persistence.BancoFuncionario;

public class Funcionario extends Pessoa {
	
	public static  BancoFuncionario banco = new BancoFuncionario();
	
	private int idFuncionario;
	
	private static Scanner read = new Scanner(System.in);
	
	public Funcionario() {
		super(true);
	}
	
	public static void addFuncionario() {
		
		Funcionario funcio = new Funcionario();
		
		System.out.print("Informe o nome do funcionário: ");
		funcio.setNome(read.nextLine());
		System.out.print("Informe a senha do funcionário: ");
		funcio.setSenha(read.nextLine());
		funcio.setPermissoes(true);
		int idFuncio = (BancoFuncionario.funcionarios.size()+1);
		funcio.setIdFuncionario(idFuncio);
		BancoFuncionario.adicionaFuncionario(funcio);
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public static void removeFuncio() {
		if(BancoFuncionario.funcionarios.size() > 0) {
			//Mostrando uma lista de itens cadastrados, permitindo o usuário escolher o item que deseja remover através do id.
			//Obs. o usuário irá sair do aplicativo se digitar um número maior do que o tamanho do Array do banco ou valor inválido.
			BancoFuncionario.listaFuncio();
			System.out.println("------------------------------------------|");
			System.out.print("Informe o funcionario que deseja remover: ");
			try {
				int remove = Integer.parseInt(read.next());
				if(remove <= BancoFuncionario.funcionarios.size() && remove > 0) {
					BancoFuncionario.removerFuncio(remove);
					System.out.println("Usuário removido com Sucesso!");
				}
				else if(remove == (BancoFuncionario.funcionarios.size()+1)) {
				}
				else {
					System.out.print("Comando inválido, tente novamente. \n");		
				}
			}catch(Exception e){
				
				System.out.print("Comando inválido, tente novamente. \n");
				
			}
			} else {
				System.out.println("------------------------------------------|");
				System.out.print("Nenhum funcionário cadastrado no estoque!\n");	
			}
	}

}
