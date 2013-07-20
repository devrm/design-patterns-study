package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.aulasfj95.investimento.Conta;

public abstract class Filtro {
	
	private Filtro outroFiltro;
	
	public Filtro(){}
	
	public Filtro(Filtro outroFiltro) {
		this.outroFiltro = outroFiltro;
	}
	
    public abstract List<Conta> filtra(List<Conta> contas);
    
    public final List<Conta> aplicaProximoFiltro(List<Conta> contas) {
    	
    	if (this.outroFiltro == null) return new ArrayList<Conta>();
    	
    	return this.outroFiltro.filtra(contas);
    }
    
    
	public static void main(String[] args) {
		
		List<Conta> contasParaAvaliar = new ArrayList<Conta>();
		
		contasParaAvaliar.add(new Conta(300, new Date()));
		contasParaAvaliar.add(new Conta(500001, new GregorianCalendar(2000, 3, 18).getTime()));
		contasParaAvaliar.add(new Conta(99, new GregorianCalendar(2000, 3, 18).getTime()));
		contasParaAvaliar.add(new Conta(300, new GregorianCalendar(2000, 3, 18).getTime()));
		contasParaAvaliar.add(new Conta(990, new GregorianCalendar(2000, 3, 18).getTime()));
		
		Filtro filtrosParaAplicar = new FiltroSaldoMenorQueCemReais(new FiltroSaldoMaiorQueQuinhentosMilReais(new ContasComDataDeAberturaNoMesCorrente()));
		
		
		
		List<Conta> contasSuspeitas = filtrosParaAplicar.filtra(contasParaAvaliar);
		
		System.out.println("Existem "+contasSuspeitas.size()+" contas suspeitas.");
		
		
		
	}

    
}

class FiltroSaldoMenorQueCemReais extends Filtro {

	public FiltroSaldoMenorQueCemReais(){ }
	
	public FiltroSaldoMenorQueCemReais(Filtro outroFiltro) {
		super(outroFiltro);
	}
	
	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> contasSuspeitas = new ArrayList<Conta>();
		for (Conta conta : contas) {
			
			if (conta.getSaldo() < 100) {
				contasSuspeitas.add(conta);
			}
			
		}
		contasSuspeitas.addAll(aplicaProximoFiltro(contas));
		return contasSuspeitas;
	}
}

class FiltroSaldoMaiorQueQuinhentosMilReais extends Filtro {
	
	public FiltroSaldoMaiorQueQuinhentosMilReais() {
	}

	
	public FiltroSaldoMaiorQueQuinhentosMilReais(Filtro outroFiltro) {
		super(outroFiltro);
	}


	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> contasSuspeitas = new ArrayList<Conta>();
		
		for (Conta conta : contas) {
			if (conta.getSaldo() > 500000) {
				contasSuspeitas.add(conta);
			}
		}
		
		contasSuspeitas.addAll(aplicaProximoFiltro(contas));
		
		return contasSuspeitas;
	}
}

class ContasComDataDeAberturaNoMesCorrente extends Filtro {

	public ContasComDataDeAberturaNoMesCorrente(){}
	
	public ContasComDataDeAberturaNoMesCorrente(Filtro outroFiltro) {
		super(outroFiltro);
	}
	
	
	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> contasSuspeitas = new ArrayList<Conta>();
		Calendar dataCorrente = Calendar.getInstance();
		
		int mesCorrente = dataCorrente.get(Calendar.MONTH);
		int anoCorrente = dataCorrente.get(Calendar.YEAR);
		
		for (Conta conta : contas) {
			
			Calendar dataAberturaConta = Calendar.getInstance();
			
			dataAberturaConta.setTime(conta.getDataAbertura());
			
			int mesAbertura = dataAberturaConta.get(Calendar.MONTH);
			int anoAbertura = dataAberturaConta.get(Calendar.YEAR);
			
			if (anoCorrente == anoAbertura) {
				if (mesCorrente == mesAbertura) {
					contasSuspeitas.add(conta);
				}
			}
			
		}
		contasSuspeitas.addAll(aplicaProximoFiltro(contas));
		
		return contasSuspeitas;
	}
	
}




