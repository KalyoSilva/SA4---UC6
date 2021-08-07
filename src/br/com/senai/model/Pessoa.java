package br.com.senai.model;

public class Pessoa {

	private String nome;
	private String senha;
	private boolean permissoes;

	protected Pessoa(boolean perm) {
		permissoes = perm;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isPermissoes() {
		return permissoes;
	}

	public void setPermissoes(boolean permissoes) {
		this.permissoes = permissoes;
	}
	
	
	

}
