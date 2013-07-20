package br.com.aulasfj95.calculoimposto;

public class Finaliza implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
		throw new RuntimeException("Orcamento finalizado nao recebe desconto!");
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja finalizado!");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja finalizado!");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja finalizado!");
	}

}
