package br.com.aulasfj95.investimento;


public class InvestimentoModerado implements Investimento {

	@Override
	public double calculaRetorno(Conta conta) {

		boolean escolhido = Math.random() > 0.50;
		double retornoInvestimento = conta.getSaldo();
		
		if (escolhido) {
			retornoInvestimento *= 0.025;
		} else {
			retornoInvestimento *= 0.007;
		}
		return retornoInvestimento;
	}

}
