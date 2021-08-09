package br.com.senai.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Funcionario;

public class BancoFuncionario {

	public static List<Funcionario> funcionarios = new ArrayList<>();
	private static Scanner read = new Scanner(System.in);
	
	// Criação do usuário admin.
	// obs. não implementado registro de mais usuários.
	static {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("admin");
		funcionario.setSenha("123");
		funcionario.setPermissoes(true);
		funcionario.setIdFuncionario(BancoFuncionario.funcionarios.size()+1);
		adicionaFuncionario(funcionario);
	}
	
	// Adicionar funcionário a lista de funcionários.
	
	public static void adicionaFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public List<Funcionario> getFuncionario(){
		return funcionarios;
	}
	
	public static void listaFuncio() { // Mostra os itens cadastrados em um formato de lista
		System.out.println("------------------------------------------|");
		System.out.println("        FUNCIONÁRIOS CADASTRADOS          |");
		System.out.println("------------------------------------------|");
		for(int i = 0; i < funcionarios.size() && funcionarios.size() > 0; i++) {
			System.out.println("["+funcionarios.get(i).getIdFuncionario()+"]"+"->"+funcionarios.get(i).getNome());
		}
		System.out.println("["+(funcionarios.size()+1)+"]->Sair");
			
	}

	public static void expandFuncio() {
		System.out.println("------------------------------------------|");
		System.out.print("Deseja Expandir algum item? (S/N): ");
		String cmdExpand = read.nextLine();
		System.out.println("------------------------------------------|");
		if(cmdExpand.equals("s") || cmdExpand.equals("S")) {
			System.out.println("------------------------------------------|");
			System.out.print("Expandir item: ");
			try {
				int expand = Integer.parseInt(read.next());
				if(expand <= funcionarios.size() && expand > 0) {
					System.out.println("------------------------------------------|");
					System.out.println("Nome: "+funcionarios.get(expand-1).getNome());
					System.out.println("Senha: "+funcionarios.get(expand-1).getSenha());
					System.out.println("Admin: "+funcionarios.get(expand-1).isPermissoes());
				}
				else if(expand == (funcionarios.size()+1)) {
						
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
		else {}
	}


	public static void removerFuncio(int remove) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (funcionarios.get(i).getIdFuncionario() == remove) { // Metodo utilizado para remover item do estoque. 
				funcionarios.remove(i);
			}
		}
	}
	
	
	
}
