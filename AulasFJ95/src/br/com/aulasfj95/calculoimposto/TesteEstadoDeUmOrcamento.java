package br.com.aulasfj95.calculoimposto;

public class TesteEstadoDeUmOrcamento {
	
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(1000);
		
		orcamento.aplicaDescontoExtra();
		
		System.out.println("Desconto em aprovacao: "+orcamento.getValor());
		
		orcamento.aprova();
		
		orcamento.aplicaDescontoExtra();
		
		System.out.println("Desconto em aprovado: "+orcamento.getValor());
		
		orcamento.finaliza();
		
		System.out.println("Orcamento finalizado");
		
		System.out.println("Tentativa de reprovacao do mesmo orcamento...");
		
		orcamento.reprova();
	}

}
