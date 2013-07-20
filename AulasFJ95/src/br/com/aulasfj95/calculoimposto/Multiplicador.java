package br.com.aulasfj95.calculoimposto;

public class Multiplicador implements AcaoAposGerarNota {

	
	private double multiplicador;

	public Multiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}
	
	@Override
	public void executar(NotaFiscal nf) {
		
		System.out.println(nf.getValorBruto() * multiplicador);
		
	}

}
