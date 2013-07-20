package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscal {
	
	
	private String razaoSocial;
	private String cnpj;
	private double valorBruto;
	private double impostos;
	private Calendar dataEmissao;
	private String observacoes;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	
	public NotaFiscal(String razaoSocial, String cnpj, double valorBruto,
			double impostos, Calendar dataEmissao, String observacoes,
			List<ItemDaNota> todosItens) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.valorBruto = valorBruto;
		this.impostos = impostos;
		this.dataEmissao = dataEmissao;
		this.observacoes = observacoes;
		this.todosItens = todosItens;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public double getValorBruto() {
		return valorBruto;
	}
	public double getImpostos() {
		return impostos;
	}
	public Calendar getDataEmissao() {
		return dataEmissao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public List<ItemDaNota> getTodosItens() {
		return todosItens;
	}
	
	
	
	
}
