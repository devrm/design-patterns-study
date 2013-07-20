package br.com.aulasfj95.calculoimposto;

public class Iss extends Imposto {

	public Iss(){}
	
	public Iss(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}
	
	
	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor()*0.06 + calculaImpostoComposto(orcamento);
	}

}
