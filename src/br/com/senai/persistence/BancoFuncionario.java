package br.com.senai.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.model.Funcionario;

public class BancoFuncionario {

	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	// Cria��o do usu�rio admin.
	// obs. n�o implementado registro de mais usu�rios.
	static {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("admin");
		funcionario.setSenha("123");
		adicionaFuncionario(funcionario);
	}
	
	// Adicionar funcion�rio a lista de funcion�rios.
	
	public static void adicionaFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public List<Funcionario> getFuncionario(){
		return funcionarios;
	}
	
	
	
}
