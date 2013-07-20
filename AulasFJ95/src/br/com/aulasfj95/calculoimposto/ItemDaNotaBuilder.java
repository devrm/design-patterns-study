package br.com.aulasfj95.calculoimposto;

public class ItemDaNotaBuilder {

	private String descricao;
	private double valor;
	
	public ItemDaNotaBuilder comDescricao(String desc) {
		this.descricao = desc;
		return this;		
	}
	
	
	public ItemDaNotaBuilder valor(double valor) {
		this.valor = valor;
		return this;
	}
	
	public ItemDaNota construir() {
		return new ItemDaNota(descricao, valor);
	}
	
	public static void main(String[] args) {
		ItemDaNotaBuilder builder = new ItemDaNotaBuilder();
		
		ItemDaNota item = builder.comDescricao("ItemBuilder").valor(100).construir();
		
		System.out.println(item.getValor());
		
	}
}
