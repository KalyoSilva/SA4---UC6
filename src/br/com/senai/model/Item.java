package br.com.senai.model;

public class Item {

	public  int id;
	public String nome;
	public int qtd;
	public float valorUnidade;
	public String desc;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public float getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(float valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}

