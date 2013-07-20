package br.com.aulasfj95.chain;

public class CalculadoraDeDescontos {
	
	public double calcularDesconto(Orcamento orcamento) {
		
		Desconto d1 = new DescontoMaisDeCincoItens();
		Desconto d2 = new DescontoMaiorQueQuinhentos();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new NenhumDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		return d1.calculaDesconto(orcamento);
	}
	
	
}
