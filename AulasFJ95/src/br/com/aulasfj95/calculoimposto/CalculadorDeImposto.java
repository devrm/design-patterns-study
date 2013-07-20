package br.com.aulasfj95.calculoimposto;

public class CalculadorDeImposto {

	
	public double calcularImposto(Imposto imposto, Orcamento orcamento) {
		return imposto.calcularImposto(orcamento);
	}
	
	
	public static void main(String[] args) {
		
		CalculadorDeImposto calculador = new CalculadorDeImposto();
		Orcamento orcamento = new Orcamento(1000);
		Orcamento orcamentoIntermediario = new Orcamento(2223);
		Orcamento orcamentoSuperior = new Orcamento(5000);
		Imposto iccc = new Iccc();
		
		System.out.println("O valor do iccc de "+orcamento.getValor()+": "+calculador.calcularImposto(iccc, orcamento));
		System.out.println("O valor do iccc de "+orcamentoIntermediario.getValor()+": "+calculador.calcularImposto(iccc, orcamentoIntermediario));
		System.out.println("O valor do iccc de "+orcamentoSuperior.getValor()+": "+calculador.calcularImposto(iccc, orcamentoSuperior));
	}
	
}
