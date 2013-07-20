package br.com.aulasfj95.calculoimposto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.aulasfj95.investimento.Conta;

interface Imprime {
	
	public void imprimirRelatorio(Banco banco, List<Conta> contas);
	
}


public abstract class ImpressaoRelatorio implements Imprime {

	
	public void imprimirRelatorio(Banco banco, List<Conta> contas) {
		
		imprimeCabecalho(banco);
		imprimeDetalhes(contas);
		imprimeRodape(banco);
		
	}

	protected abstract void imprimeCabecalho(Banco banco);

	protected abstract void imprimeDetalhes(List<Conta> contas);

	protected abstract void imprimeRodape(Banco banco);
	
	
	public static void main(String[] args) {
		
		Banco banco = new Banco("Banco Rico", "11-1111-1111", 
				"Rua dos muito ricos", "soumuitorico@rico.dinheiro");
		List<Conta> contas = new ArrayList<Conta>();
		
		Conta conta1 = new Conta(1000000, "Bilbo");
		conta1.setAgencia("123");
		conta1.setNumeroConta("111111111");
		
		
		Conta conta2 = new Conta(1000000, "Tony");
		conta2.setAgencia("999");
		conta2.setNumeroConta("888");
		
		contas.add(conta1);
		contas.add(conta2);
		
		Imprime relatorioSimples = new RelatorioSimples();
		Imprime relatorioDetalhado = new RelatorioDetalhado();
		
		System.out.println("imprimindo relatorio simples....");
		relatorioSimples.imprimirRelatorio(banco, contas);
		System.out.println("imprimindo relatorio detalhado....");
		relatorioDetalhado.imprimirRelatorio(banco, contas);
		
		
	}
	
}

class RelatorioDetalhado extends ImpressaoRelatorio {

	public void imprimirRelatorio(Banco banco, List<Conta> contas) {
		
	}
	
	@Override
	protected void imprimeCabecalho(Banco banco) {
		System.out.println("Nome banco: "+banco.getNome()+"Endereco: "+banco.getEndereco()+" Telefone: "+banco.getTelefone());
	}

	@Override
	protected void imprimeDetalhes(List<Conta> contas) {
		System.out.println("Dados correntistas");
		
		for (Conta conta : contas) {
			System.out.println("Titular: "+conta.getNomeTitular()+" Agencia: "+conta.getAgencia() + 
					" Numero da conta: "+conta.getNumeroConta()+ " Saldo: "+conta.getSaldo());
		}
		
	}

	@Override
	protected void imprimeRodape(Banco banco) {
		System.out.println("Email: "+banco.getEmail()+" Data atual: "+new Date());
	}
	
}

class RelatorioSimples extends ImpressaoRelatorio {

	@Override
	protected void imprimeCabecalho(Banco banco) {
		System.out.println("Nome banco: "+banco.getNome()+" Telefone: "+banco.getTelefone());
	}

	@Override
	protected void imprimeDetalhes(List<Conta> contas) {
		System.out.println("Dados correntistas");
		
		for (Conta conta : contas) {
			System.out.println("Titular: "+conta.getNomeTitular() + " Saldo: "+conta.getSaldo());
		}
		
	}

	@Override
	protected void imprimeRodape(Banco banco) {
		System.out.println("Nome banco: "+banco.getNome()+" Telefone: "+banco.getTelefone());
	}
	
	
}


