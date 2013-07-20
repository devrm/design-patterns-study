package br.com.aulasfj95.chain;

public class DescontoMaisDeCincoItens implements Desconto {

	private Desconto desconto;

	@Override
	public double calculaDesconto(Orcamento orcamento) {
		
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.10;
		} else {
			return this.desconto.calculaDesconto(orcamento);
		}
		
		
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.desconto = desconto;
		
	}

}
