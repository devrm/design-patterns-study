package br.com.aulasfj95.calculoimposto;

public class TestaBuilder {
	
	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		
		NotaFiscal nota = builder.paraRazaoSocial("Empresa XPTO").
				comCnpj("44.444.444.0001/00").
				comItem(new ItemDaNota("Item1", 100)).
				comItem(new ItemDaNota("Item2", 200)).comAsObservacoes("OBS").construir();
		
		System.out.println(nota.getValorBruto());
		
	}
}
