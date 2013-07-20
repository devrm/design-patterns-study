package br.com.aulasfj95.calculoimposto;

public class NotaFiscalDao implements AcaoAposGerarNota {

	@Override
	public void executar(NotaFiscal nf) {
		System.out.println("Salvando no banco de dados...");
	}
	
	

}
