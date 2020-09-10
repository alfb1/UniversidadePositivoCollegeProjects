package controllers;

import java.util.List;

import models.Produto;
import repositories.Produtos;

/**
 * Classe controladora para Produto, repons�vel por fazer a conex�o entre as
 * classes ProdutoView, e Produtos ( reposit�rio )
 * 
 * @author Andr� Brito
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
	 * M�todo que retorna uma lista do tipo Produto
	 * 
	 * @return lista de produtos
	 */
	public List<Produto> listar() {
		return this.produtos.listar();
	}

	/**
	 * M�todo que retorna um produto pelo �ndice da lista
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
	 * M�todo que atualiza a quantidade em estoque da lista
	 * 
	 * @param produto    a ser atualizado a quantidade em estoque
	 * @param quantidade quantidade a ser baixada do estoque
	 */
	public void baixarEstoque(Produto produto, double quantidade) {

		produtos.baixarEstoque(produto, quantidade);

	}

}
