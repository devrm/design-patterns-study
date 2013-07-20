package br.com.aulasfj95.calculoimposto;

public class TesteDescontoJaAplicado {

	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(1000);
		orcamento.aplicaDescontoExtra();
		System.out.println("Valor orcamento: "+orcamento.getValor());
		orcamento.aprova();
		orcamento.aplicaDescontoExtra();
		System.out.println("Mais desconto..." + orcamento.getValor());
	}
	
}
