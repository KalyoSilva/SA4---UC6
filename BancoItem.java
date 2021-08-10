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
		System.out.println("------------------------------------------|");
		System.out.println("             ITENS CADASTRADOS            |");
		System.out.println("------------------------------------------|");
		for(int i = 0; i < itens.size() && itens.size() > 0; i++) {
			System.out.println("["+itens.get(i).getId()+"]"+"->"+itens.get(i).getNome());
		}
			
	}
	
	public void ExpandItem(){ // seleciona um item da lista e mostra seus detalhes
		System.out.println("------------------------------------------|");
		System.out.print("Deseja Expandir algum item? (S/N): ");
		String cmdExpand = input.nextLine();
		if(cmdExpand.equals("s") || cmdExpand.equals("S")) {
			System.out.println("------------------------------------------|");
			System.out.print("Expandir item: ");
			//Try pegando as informações dos itens para expandir. 
			try {
				int expand = Integer.parseInt(input.next());
				if(expand <= itens.size() && expand > 0) {
					System.out.println("------------------------------------------|");
					System.out.println("Nome: "+itens.get(expand-1).getNome());
					System.out.println("Quantidade: "+itens.get(expand-1).getQtd());
					System.out.println("Valor p/Unidade: "+itens.get(expand-1).getValorUnidade());
					System.out.println("Descrição Item: "+itens.get(expand-1).getDesc());
				}
				else if(expand == (itens.size()+1)) {
						
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
}
