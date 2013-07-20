package br.com.aulasfj95.investimento;

public class RealizadorDeInvestimentos {

	
	public void calculaRetornoInvestimento(Investimento investimento, Conta conta) {
		
		double retorno = investimento.calculaRetorno(conta);
		
		conta.setSaldo(conta.getSaldo()+(retorno * 0.75));
		
	}
	public static void main(String[] args) {
		RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();
		Conta contaMafra = new Conta(10000, "Dunha");
		Investimento arrojado = new InvestimentoModerado();
		System.out.println("Saldo anterior: "+contaMafra.getSaldo());
		realizador.calculaRetornoInvestimento(arrojado, contaMafra);
		System.out.println("Saldo apos investimento: "+contaMafra.getSaldo());
		
		
	}
}
