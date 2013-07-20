package br.com.aulasfj95.calculoimposto;

public class TesteImpostoComposto {
	
	
	public static void main(String[] args) {
		
		Imposto issMaisIcms = new Iss(new Icms());
		Imposto iss = new Iss();
		Orcamento orcamento = new Orcamento(1000);
		
		
		System.out.println("O valor do imposto composto ISS e de : "+issMaisIcms.calcularImposto(orcamento));
		System.out.println("O valor do imposto simples ISS e de : "+iss.calcularImposto(orcamento));
		
		
		
	}
	
	
	
}
