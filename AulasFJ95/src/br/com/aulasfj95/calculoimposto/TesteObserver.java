package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TesteObserver {
	public static void main(String[] args) {
		List<AcaoAposGerarNota> acoes = new ArrayList<AcaoAposGerarNota>();
		
		acoes.add(new Multiplicador(5));
		acoes.add(new NotaFiscalDao());
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes);
		
		NotaFiscal nota = builder.paraRazaoSocial("Dunha").comCnpj("123").naData(Calendar.getInstance()).comItem(new ItemDaNota("item", 100)).construir();
		
		System.out.println("Valor nota "+nota.getValorBruto());
		
		
		
	}
}
