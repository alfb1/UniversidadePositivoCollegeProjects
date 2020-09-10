package br.edu.positivo.online01.exercicio.models;

/**
 * Classe ItemVenda
 * 
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */

public class ItemVenda {
	Double quantidade;
	Double preco;

	Venda venda;
	Produto produto;

	public ItemVenda(Venda venda, Produto produto, Double qtd) {
		this.venda = venda;
		this.produto = produto;
		this.preco   = produto.getPreco();
		this.quantidade = qtd;
	}
	
	public ItemVenda(Produto produto, Double qtd) {
		this.produto = produto;
		this.preco   = produto.getPreco();
		this.quantidade = qtd;
	}
	
	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
