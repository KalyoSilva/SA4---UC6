package br.com.senai.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.model.Item;

public class BancoItem {

	private static List<Item> itens = new ArrayList<>();
	
	public static void removerItem(Item item) {
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getId() == item.getId()) { // Metodo utilizado para remover item do estoque. 
				itens.remove(i);						// Obs. Opção remover ainda não criada.
			}
		}
	}

	public void adicionarItem(Item item) {
		itens.add(item); // Adicionar um item na lista itens
	}

	public List<Item> getItens() {
		return itens;
	}

}
