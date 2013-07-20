package br.com.aulasfj95.calculoimposto;

public class ImpostoMuitoAlto extends Imposto {

	
	public ImpostoMuitoAlto(){}
	
	
	public ImpostoMuitoAlto(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}


	@Override
	public double calcularImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.2 + calculaImpostoComposto(orcamento);
	}
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(1000);
		Imposto impostoMuitoAlto = new ImpostoMuitoAlto(new Icms());
		
		System.out.println("Imposto muito alto: "+impostoMuitoAlto.calcularImposto(orcamento));
	}
}
