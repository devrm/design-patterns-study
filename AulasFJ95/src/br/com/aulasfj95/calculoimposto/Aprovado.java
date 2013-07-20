package br.com.aulasfj95.calculoimposto;


public class Aprovado implements EstadoDeUmOrcamento {

	private boolean isDescontoExtraAplicado;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
		if (! isDescontoExtraAplicado) {
			orcamento.setValor(orcamento.getValor() - (orcamento.getValor()* 0.02));
			isDescontoExtraAplicado = true;
		} else {
			throw new RuntimeException("Desconto extra ja aplicado");
		}
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja aprovado!");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orcamento ja aprovado nao pode ser reprovado!");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estado = new Finaliza();
	}

}
