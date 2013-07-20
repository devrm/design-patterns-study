package br.com.aulasfj95.calculoimposto;

public class Banco {

	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	
	
	public Banco(String nome, String telefone, String endereco, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
	
	
	
}
