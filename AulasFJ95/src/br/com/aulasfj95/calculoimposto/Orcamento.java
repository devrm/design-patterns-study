package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {
	private List<Item> listaItem = new ArrayList<Item>();
	private double valor;
	protected EstadoDeUmOrcamento estado = new EmAprovacao();
	
	public Orcamento(double valor) {
		this.setValor(valor);
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

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void aplicaDescontoExtra() {
		estado.aplicaDescontoExtra(this);
	}
	
	
	public void aprova() {
		this.estado.aprova(this);
	}
	
	public void reprova() {
		this.estado.reprova(this);
	}
	
	public void finaliza() {
		this.estado.finaliza(this);
	}

}
