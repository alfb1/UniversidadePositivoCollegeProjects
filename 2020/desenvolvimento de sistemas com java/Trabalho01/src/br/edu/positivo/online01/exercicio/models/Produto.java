package br.edu.positivo.online01.exercicio.models;

/**
 * Classe Produto
 * 
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */
public class Produto {
	private String nome;
	private Double quantidadeEmEstoque;
	private Double preco ;

	public Produto(String nome) {
		this.nome = nome ;
		preco = 0.0;
		quantidadeEmEstoque = 0.0;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(Double quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	public void baixarEstoque(Double qtd) {
		this.quantidadeEmEstoque -= qtd; 
	}

}
