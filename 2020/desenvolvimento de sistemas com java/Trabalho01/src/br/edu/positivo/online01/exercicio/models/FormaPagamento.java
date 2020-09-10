package br.edu.positivo.online01.exercicio.models;

/**
 * Classe FormaPagamento
 * 
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */

public class FormaPagamento {
	private String nome;
	
	public FormaPagamento() {}
	public FormaPagamento(String nome) {
		this.nome = nome ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
