package br.com.aulasfj95.calculoimposto;

public class EnviadorDeEmail implements AcaoAposGerarNota {

	@Override
	public void executar(NotaFiscal nf) {

		System.out.println("Enviando email...");
		
	}

}
