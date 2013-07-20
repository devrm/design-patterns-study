package br.com.aulasfj95.calculoimposto;

public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento reprovado! Nao e possivel aprova-lo");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja reprovado! Nao e possivel reprovar novamente");

	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja reprovado!");
	}

}
