package br.com.aulasfj95.chain;

public class ExercicioRequisicao {


	
	public static void main(String[] args) {
		
		Conta conta = new Conta("Astolfo", 50.0);
		
		Requisicao requisicaoXml = new Requisicao(Formato.XML, conta);
		Requisicao requisicaoCsv = new Requisicao(Formato.CSV, conta);
		Requisicao requisicaoPorcento = new Requisicao(Formato.PORCENTO, conta);
		Requisicao requisicaoDesconhecido = new Requisicao(Formato.XPTO, conta);
		
		ProcessadorDeRequisicao processador = new ProcessadorDeRequisicao();
		
		System.out.println("Formato csv: "+processador.formatarConta(requisicaoXml));
		System.out.println("Formato xml: "+processador.formatarConta(requisicaoCsv));
		System.out.println("Formato porcento: "+processador.formatarConta(requisicaoPorcento));
		System.out.println(processador.formatarConta(requisicaoDesconhecido));
	}
	
	
}

enum Formato {
	XML,
	CSV,
	PORCENTO,
	XPTO
}
class ProcessadorDeRequisicao {
	
	public String formatarConta(Requisicao requisicao) {
		
		Processa proc1 = new ProcessaCSV();
		Processa proc2 = new ProcessaXML();
		Processa proc3 = new ProcessaPorcento();
		Processa proc4 = new FormatoDesconhecido();
		
		proc1.setProximo(proc2);
		proc2.setProximo(proc3);
		proc3.setProximo(proc4);
		
		return proc1.efetuarProcessamento(requisicao);
		
	}
	
	
}
class Requisicao {
	private Formato formato;
	private Conta conta;
	public Requisicao(Formato formato, Conta conta) {
		this.formato = formato;
		this.conta = conta;
	}
	public Formato getFormato() {
		return formato;
	}
	public Conta getConta() {
		return conta;
	}
}

class Conta {
	private String nomeTitular;
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public Conta(String nomeTitular, double saldo) {
		super();
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
	}
	private double saldo;
}

interface Processa {
	String efetuarProcessamento(Requisicao requisicao);
	void setProximo(Processa processa);
}

class ProcessaXML implements Processa {
	
	private Processa processa;
	
	@Override
	public String efetuarProcessamento(Requisicao requisicao) {
		
		if (Formato.XML.equals(requisicao.getFormato())) {
			return "XML";
		} else {
			return this.processa.efetuarProcessamento(requisicao);
		}
	}
	
	@Override
	public void setProximo(Processa processa) {
		this.processa = processa;
	}
	
}

class ProcessaCSV implements Processa {
	
	private Processa processa;
	
	@Override
	public String efetuarProcessamento(Requisicao requisicao) {
		
		if (Formato.CSV.equals(requisicao.getFormato())) {
			return "CSV";
		} else {
			return this.processa.efetuarProcessamento(requisicao);
		}
		
	}
	
	@Override
	public void setProximo(Processa processa) {
		this.processa = processa;
		
	}
}

class ProcessaPorcento implements Processa {
	
	
	@Override
	public String efetuarProcessamento(Requisicao requisicao) {
		
		if (Formato.PORCENTO.equals(requisicao.getFormato())) {
			return "PORCENTO";
		} else {
			return "FORMATODESCONHECIDO";
		}
		
	}
	
	@Override
	public void setProximo(Processa processa) {
	}
	
}

class FormatoDesconhecido implements Processa {
	
	@Override
	public String efetuarProcessamento(Requisicao requisicao) {
		return "FORMATO DESCONHECIDO";
	}
	
	@Override
	public void setProximo(Processa processa) {
		
	}
	
}