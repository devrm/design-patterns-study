package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.List;

public class AulasTemplate {
	
	public static void main(String[] args) {
		
		Orcamento orcamento1 = new Orcamento(510);
		orcamento1.adicionarItem(new Item("CPU", 150 ));
		orcamento1.adicionarItem(new Item("MEMORIA", 150 ));
		orcamento1.adicionarItem(new Item("CPU", 210 ));
		
		
		Orcamento orcamento2 = new Orcamento(510);
		orcamento2.adicionarItem(new Item("VGA", 250));
		orcamento2.adicionarItem(new Item("HD", 260));
		
		Imposto icpp = new ICPP(new Iss());
		Imposto ikcv = new IKCV(new IHIT());
		Imposto ihit = new IHIT();
		
		System.out.println("Maxima taxacao: "+ihit.calcularImposto(orcamento1));
		System.out.println("Minima taxacao: "+ihit.calcularImposto(orcamento2));
		
		
		System.out.println("O valor da taxacao do imposto ICPP para o orcamento e: "+icpp.calcularImposto(orcamento1));
		System.out.println("O valor da taxacao do imposto IKCV para o orcamento e: "+ikcv.calcularImposto(orcamento2));
		
	}
}
abstract class TemplateCalculoImposto extends Imposto {
	
	public double calcularImposto(Orcamento orcamento) {
		
		if (isDeveCalcularMaximaTaxacao(orcamento)) {
			return aplicarMaximaTaxacao(orcamento) + calculaImpostoComposto(orcamento);
		} else {
			return aplicarMinimaTaxacao(orcamento) + calculaImpostoComposto(orcamento);
		}
		
		
	}

	public abstract double aplicarMinimaTaxacao(Orcamento orcamento);

	public abstract double aplicarMaximaTaxacao(Orcamento orcamento);

	public abstract boolean isDeveCalcularMaximaTaxacao(Orcamento orcamento);
	
	
}


class ICPP extends TemplateCalculoImposto {

	public ICPP(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}
	
	public ICPP(){}
	
	
	@Override
	public double aplicarMinimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double aplicarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public boolean isDeveCalcularMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 ;
	}
	
}

class IKCV extends TemplateCalculoImposto {

	public IKCV(){}
	
	
	public IKCV(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}
	
	@Override
	public double aplicarMinimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	public double aplicarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

	@Override
	public boolean isDeveCalcularMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && isPossuiItemValorSuperior100(orcamento);
	}

	private boolean isPossuiItemValorSuperior100(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() > 100) {
				return true;
			}
		}
		return false;
	}
	
}

class IHIT extends TemplateCalculoImposto {

	public IHIT(){}
	
	public IHIT(Imposto outroImposto) {
		super.outroImposto = outroImposto;
	}
	
	@Override
	public double aplicarMinimaTaxacao(Orcamento orcamento) {
		return (orcamento.getValor() * 0.01) * orcamento.getItens().size();
	}

	@Override
	public double aplicarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	public boolean isDeveCalcularMaximaTaxacao(Orcamento orcamento) {
		List<String> nomeItens = new ArrayList<String>();
		for (Item item : orcamento.getItens()) {
			if (nomeItens.contains(item.getNome())) {
				return true;
			}
			nomeItens.add(item.getNome());
		}
		return false;
	}
	
}




