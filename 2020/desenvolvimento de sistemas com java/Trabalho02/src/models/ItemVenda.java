package models;

/**
 * Classe model de ItemVenda
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */

public class ItemVenda {
	Double quantidade;
	Double preco;

	Venda venda;
	Produto produto;

	/**
	 * Construtor recebe venda, produto e quantidade vendida
	 * 
	 * @param venda      venda relacionada ao ItemVenda
	 * @param produto    produto relacionato a ItemVenda
	 * @param quantidade vendida
	 */
	public ItemVenda(Venda venda, Produto produto, Double quantidade) {
		this.venda = venda;
		this.produto = produto;
		this.preco = produto.getPreco();
		this.quantidade = quantidade;
	}

	/**
	 * Construtor recebe produto e quantidade vendida
	 * 
	 * @param produto    produto do item da venda
	 * @param quantidade vendida
	 */
	public ItemVenda(Produto produto, Double quantidade) {
		this.produto = produto;
		this.preco = produto.getPreco();
		this.quantidade = quantidade;
	}

	/**
	 * Método para retornar o atributo quantidade
	 * 
	 * @return quantidade
	 */
	public Double getQuantidade() {
		return quantidade;
	}

	/**
	 * Método para setar o atributo quantidade
	 * 
	 * @param quantidade quantidade de ItemVenda
	 */
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Método para retornar o atributo preco
	 * 
	 * @return preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * Método para setar o atributo preco
	 * 
	 * @param preco preco do ItemVenda
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * Método para retornar o atributo venda
	 * 
	 * @return venda
	 */
	public Venda getVenda() {
		return venda;
	}

	/**
	 * Método para setar o atributo venda
	 * 
	 * @param venda informa a venda do item
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	/**
	 * Método para retornar o atributo produto
	 * 
	 * @return produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Método para setar o atributo produto
	 * 
	 * @param produto produto do item da venda
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * Método para imprimir um objeto funcionario
	 */
	@Override
	public String toString() {
		return "ItemVenda [quantidade=" + quantidade + ", preco=" + preco + ", venda=" + venda.getCodigo()
				+ ", produto=" + produto.getNome() + "]";
	}

	/**
	 * Método retornar o produto da quantidade e preço
	 * 
	 * @return valor total do item
	 */
	public double getTotal() {
		return quantidade * preco;
	}

}
