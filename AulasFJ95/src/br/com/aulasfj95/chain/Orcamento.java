package br.com.aulasfj95.chain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {
	private List<Item> listaItem = new ArrayList<Item>();
	private double valor;
	
	public Orcamento(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void adicionarItem(Item item) {
		listaItem.add(item);
	}
	
	
	public List<Item> getItens() {
		return Collections.unmodifiableList(listaItem);
	}
	
}
