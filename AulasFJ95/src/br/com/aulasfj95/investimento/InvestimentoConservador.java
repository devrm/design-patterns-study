package br.com.aulasfj95.investimento;

public class InvestimentoConservador implements Investimento {

	@Override
	public double calculaRetorno(Conta conta) {
		
		return conta.getSaldo()*0.008;
	}

}
