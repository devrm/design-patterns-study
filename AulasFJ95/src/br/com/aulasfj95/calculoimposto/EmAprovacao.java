package br.com.aulasfj95.calculoimposto;

public class EmAprovacao implements EstadoDeUmOrcamento {

	private boolean isDescontoExtraAplicado;
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		
		if (! isDescontoExtraAplicado) {
			
			orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.05));
			isDescontoExtraAplicado = true;
			
		} else {
			throw new RuntimeException("Desconto extra ja aplicado");
		}
		
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.estado = new Aprovado();
	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.estado = new Reprovado();
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		// TODO Auto-generated method stub

	}

}
