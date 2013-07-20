package br.com.aulasfj95.chain;

public class DescontoMaiorQueQuinhentos implements Desconto {

	private Desconto desconto;

	@Override
	public double calculaDesconto(Orcamento orcamento) {

		if (orcamento.getValor() > 500.0) {
			return orcamento.getValor() * 0.07;
		} else {
			return this.desconto.calculaDesconto(orcamento);
		}
		
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.desconto = desconto;
		
	}

}
