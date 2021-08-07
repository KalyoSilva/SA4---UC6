package br.com.senai.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.model.Funcionario;

public class BancoFuncionario {

	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	// Criação do usuário admin.
	// obs. não implementado registro de mais usuários.
	static {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("admin");
		funcionario.setSenha("123");
		adicionaFuncionario(funcionario);
	}
	
	// Adicionar funcionário a lista de funcionários.
	
	public static void adicionaFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public List<Funcionario> getFuncionario(){
		return funcionarios;
	}
	
	
	
}
