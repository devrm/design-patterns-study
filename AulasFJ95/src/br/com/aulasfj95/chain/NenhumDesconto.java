package br.com.aulasfj95.chain;

public class NenhumDesconto implements Desconto {

	@Override
	public double calculaDesconto(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto desconto) {
		
	}

}
