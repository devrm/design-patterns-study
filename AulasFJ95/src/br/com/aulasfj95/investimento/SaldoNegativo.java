package br.com.aulasfj95.investimento;

public class SaldoNegativo implements EstadoConta {

	@Override
	public void saque(Conta conta, double valor) {
		throw new RuntimeException("Nao e possivel realizar saques com o saldo negativo!");
	}

	@Override
	public void deposito(Conta conta, double valor) {

		valor = valor * 0.95;
		conta.saldo += valor;
		System.out.println("Realizando o deposito no valor de: "+valor);
		if (conta.saldo > 0) {
			conta.estado = new SaldoPositivo();
		}
		
		
	}

}
