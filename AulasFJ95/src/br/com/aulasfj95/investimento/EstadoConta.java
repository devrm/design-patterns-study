package br.com.aulasfj95.investimento;

public interface EstadoConta {

	void saque(Conta conta, double valor);
	
	void deposito(Conta conta, double valor);
	
}
