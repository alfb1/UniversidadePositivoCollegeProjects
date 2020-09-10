package controllers;

import java.util.List;

import models.Produto;
import repositories.Produtos;

/**
 * Classe controladora para Produto, reponsável por fazer a conexão entre as
 * classes ProdutoView, e Produtos ( repositório )
 * 
 * @author André Brito
 * @author Franccescoly Emmanuel Camargo
 *
 */
public class ProdutoController {
	private Produtos produtos;

	/**
	 * Construtor instancia um objeto produtos da classe Produtos
	 * 
	 */
	public ProdutoController() {
		produtos = new Produtos();
	}

	/**
	 * Metodo para cadastro de Produto
	 * 
	 * @param produto do tipo Produto
	 * @return boolean true em caso de sucesso no cadastro
	 */
	public boolean cadastrar(Produto produto) {

		if (produtos.temProdutoCadastrado(produto)) {
			return false;
		} else {
			produtos.cadastrar(produto);
			return true;
		}
	}

	/**
	 * Método que retorna uma lista do tipo Produto
	 * 
	 * @return lista de produtos
	 */
	public List<Produto> listar() {
		return this.produtos.listar();
	}

	/**
	 * Método que retorna um produto pelo índice da lista
	 * 
	 * @param index indice da lista
	 * @return produto da lista
	 */
	public Produto get(Integer index) {
		if (index >= 0 && index < produtos.listar().size())
			return this.produtos.get(index);
		else
			return null;
	}

	/**
	 * Método que atualiza a quantidade em estoque da lista
	 * 
	 * @param produto    a ser atualizado a quantidade em estoque
	 * @param quantidade quantidade a ser baixada do estoque
	 */
	public void baixarEstoque(Produto produto, double quantidade) {

		produtos.baixarEstoque(produto, quantidade);

	}

}
