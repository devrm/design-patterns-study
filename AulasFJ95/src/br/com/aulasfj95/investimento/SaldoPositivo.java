package br.com.aulasfj95.investimento;

public class SaldoPositivo implements EstadoConta {

	@Override
	public void saque(Conta conta, double valor) {
		
		conta.saldo -= valor;

		if (conta.saldo < 0) {
			conta.estado = new SaldoNegativo();
		}
		
		System.out.println("Realizando o saque no valor de: "+valor);
	}

	@Override
	public void deposito(Conta conta, double valor) {

		valor = valor * 0.98;
		
		System.out.println("Realizando o deposito no valor de: "+valor);
		
		conta.saldo += valor;
		
	}

}
