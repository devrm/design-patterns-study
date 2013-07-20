package br.com.aulasfj95.calculoimposto;

public class Iccc extends Imposto {

	public Iccc(){}
	
	public Iccc(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}
	
	
	@Override
	public double calcularImposto(Orcamento orcamento) {
		double total = 0;
		if (orcamento.getValor() <= 1000) {
			total = orcamento.getValor()*0.05;
		} else if(orcamento.getValor() <= 3000) {
			total = orcamento.getValor()*0.07;
		} else {
			total = (orcamento.getValor()*0.08)+30;
		}
		return total + calculaImpostoComposto(orcamento);
	}

}
