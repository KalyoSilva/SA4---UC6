package br.com.senai.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.model.Item;

public class BancoItem {
	
	private Scanner input = new Scanner(System.in);
	
	public static List<Item> itens = new ArrayList<>();
	
	public static void removerItem(int id) {
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getId() == id) { // Metodo utilizado para remover item do estoque. 
				itens.remove(i);
			}
		}
	}

	public void adicionarItem(Item item) {
		itens.add(item); // Adicionar um item na lista itens
	}

	public void getItens() { // Mostra os itens cadastrados em um formato de lista
		for(int i = 0; i < itens.size() && itens.size() > 0; i++) {
			System.out.println("------------------------------------------|");
			System.out.println("             ITENS CADASTRADOS            |");
			System.out.println("------------------------------------------|");
			System.out.println("["+itens.get(i).getId()+"]"+"->"+itens.get(i).getNome());
		}
		System.out.println("["+(itens.size()+1)+"]->Sair");
			
	}
	
	public void ExpandItem(){ // seleciona um item da lista e mostra seus detalhes
		System.out.println("------------------------------------------|");
		System.out.print("Expandir item: ");
		try {
			int expand = Integer.parseInt(input.next());
			if(expand <= itens.size() && expand > 0) {
				System.out.println("------------------------------------------|");
				System.out.println("Nome: "+itens.get(expand-1).getNome());
				System.out.println("Quantidade: "+itens.get(expand-1).getQtd());
				System.out.println("Valor p/Unidade: "+itens.get(expand-1).getValorUnidade());
				System.out.println("DescriÁ„o Item: "+itens.get(expand-1).getDesc());
			}
			else if(expand == (itens.size()+1)) {
					
			}
			else {
				System.out.println("------------------------------------------|");
				System.out.print("Comando inv√°lido, tente novamente. \n");		
			}
		}catch(Exception e) {
			System.out.println("------------------------------------------|");
			System.out.print("Comando inv√°lido, tente novamente. \n");		
		}
	}
}
