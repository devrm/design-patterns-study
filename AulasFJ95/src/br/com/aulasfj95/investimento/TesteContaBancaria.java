package br.com.aulasfj95.investimento;

import java.util.Date;

public class TesteContaBancaria {

	
	public static void main(String[] args) {
		Conta conta = new Conta(500, new Date());
		
		conta.saque(200);
		System.out.println("Saldo: "+conta.saldo);
		conta.deposito(200);
		System.out.println("Saldo: "+conta.saldo);
		conta.saque(500);
		System.out.println("Saldo: "+conta.saldo);
		conta.deposito(200);
		System.out.println("Saldo: "+conta.saldo);
		conta.saque(20);
		System.out.println("Saldo: "+conta.saldo);
		conta.saque(2000);
		System.out.println("Saldo: "+conta.saldo);
		conta.saque(1);
	}
}



