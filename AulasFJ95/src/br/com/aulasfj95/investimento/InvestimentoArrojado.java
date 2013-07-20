package br.com.aulasfj95.investimento;

public class InvestimentoArrojado implements Investimento {

	@Override
	public double calculaRetorno(Conta conta) {
		
		double retornoInvestimento = 0;
		double chance = Math.random();
		if (chance > 0.50) {
			retornoInvestimento = conta.getSaldo()* 0.007;
		} else if (chance> 0.30) {
			retornoInvestimento = conta.getSaldo()* 0.03;
		} else if (chance > 0.20) {
			retornoInvestimento = conta.getSaldo()* 0.05;
		}
		return retornoInvestimento;
	}

}
