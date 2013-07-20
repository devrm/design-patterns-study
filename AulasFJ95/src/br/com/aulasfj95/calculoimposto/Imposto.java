package br.com.aulasfj95.calculoimposto;

public abstract class Imposto {
	
	protected Imposto outroImposto;

	public Imposto(){}
	
	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}
	
	
	public abstract double calcularImposto(Orcamento orcamento);
	
	public double calculaImpostoComposto(Orcamento orcamento) {
		if (outroImposto == null) return 0;
		return outroImposto.calcularImposto(orcamento);
	}
	
	
}
