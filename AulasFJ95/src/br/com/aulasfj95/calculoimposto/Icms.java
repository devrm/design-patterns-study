package br.com.aulasfj95.calculoimposto;

public class Icms extends Imposto {

	
	public Icms(){}
	
	public Icms(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}
	
	
	@Override
	public double calcularImposto(Orcamento orcamento) {
		return ((orcamento.getValor()*0.05)+50.0) + calculaImpostoComposto(orcamento);
	}

}
