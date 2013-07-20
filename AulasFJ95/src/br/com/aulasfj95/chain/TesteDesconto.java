package br.com.aulasfj95.chain;

public class TesteDesconto {
	
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(300.0);
		
		orcamento.adicionarItem(new Item("LAPIS", 50));
		orcamento.adicionarItem(new Item("CANETA", 100));
		orcamento.adicionarItem(new Item("APONTADOR", 100));
		orcamento.adicionarItem(new Item("ESTILETE", 50));
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		
		System.out.println("O desconto e: "+calculadora.calcularDesconto(orcamento));
		
	}
}
