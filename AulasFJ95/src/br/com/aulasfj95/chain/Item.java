package br.com.aulasfj95.chain;

public class Item {

	private String nome;
	private double valor;
	
	
	public Item(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	
}
