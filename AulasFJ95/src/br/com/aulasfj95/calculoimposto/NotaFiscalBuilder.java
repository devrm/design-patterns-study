package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
	
	private String razaoSocial;
	private String cnpj;
	private double valorBruto;
	private double impostos;
	private Calendar dataEmissao = Calendar.getInstance();
	private String observacoes;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	
	public NotaFiscalBuilder paraRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}
	
	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	
	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		
		this.valorBruto += item.getValor();
		this.impostos   += item.getValor() * 0.05;
		return this;
	}
	
	
	public NotaFiscalBuilder naData(Calendar calendar) {
		this.dataEmissao = calendar;
		return this;
	}
	
	public NotaFiscalBuilder comAsObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}
	
	public NotaFiscal construir() {
		return new NotaFiscal(razaoSocial, cnpj, valorBruto, impostos, dataEmissao, observacoes, todosItens);
	}
	

}
