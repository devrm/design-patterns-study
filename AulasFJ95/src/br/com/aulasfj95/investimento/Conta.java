package br.com.aulasfj95.investimento;

import java.util.Date;

public class Conta {
	
	protected double saldo;
	private String nomeTitular;
	private String agencia;
	private String numeroConta;
	private Date dataAbertura;
	protected EstadoConta estado = new SaldoPositivo();;
	
	
	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Conta(double saldo, String nomeTitular) {
		this.saldo = saldo;
		this.nomeTitular = nomeTitular;
	}
	
	public Conta(double saldo, Date dataAbertura) {
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
	}
	

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public void saque(double valor) {
		estado.saque(this, valor);
	}
	
	public void deposito(double valor) {
		estado.deposito(this, valor);
	}
	
	
	
}
