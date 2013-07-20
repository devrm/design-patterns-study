package br.com.aulasfj95.chain;

public interface Desconto {
	double calculaDesconto(Orcamento orcamento);
	void setProximo(Desconto desconto);
}
