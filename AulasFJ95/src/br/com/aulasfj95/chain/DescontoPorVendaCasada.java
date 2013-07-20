package br.com.aulasfj95.chain;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto desconto;

	@Override
	public double calculaDesconto(Orcamento orcamento) {
		
		if (itemExiste("lapis", orcamento) && itemExiste("caneta", orcamento)) {
			return orcamento.getValor() * 0.05;
		} else {
			return this.desconto.calculaDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.desconto = desconto;
	}
	
	private boolean itemExiste(String nomeItem, Orcamento orcamento) {
		boolean isExiste = false;
		for (Item item : orcamento.getItens()) {
			if (nomeItem.equalsIgnoreCase(item.getNome())) {
				isExiste = true;
			}
		}
		return isExiste;
	}
	

}
