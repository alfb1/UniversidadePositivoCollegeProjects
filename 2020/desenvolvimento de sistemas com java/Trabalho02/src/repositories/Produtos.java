package repositories;

import java.util.ArrayList;

import models.Produto;

/**
 * Classe responsável por guardar em memória uma lista de todos os produtos
 * cadastrados; Gera uma lista dos produtos armazenados.
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class Produtos implements IRepository<Produto> {
	ArrayList<Produto> produtos;

	/**
	 * Construtor instancia a lista de produtos
	 */
	public Produtos() {
		produtos = new ArrayList<>();
	}

	/**
	 * Verifica a lista pelo nome do produto
	 * 
	 * @param produto produto a ser localizado
	 * @return true se o nome do produto já estiver cadastrado
	 */
	public boolean temProdutoCadastrado(Produto produto) {
		if (produtos.size() > 0)
			for (Produto item : produtos) {
				if (item.getNome().equals(produto.getNome())) {
					return true;
				}
			}
		return false;
	}

	/**
	 * Diminui a quantidade em estoque de um produto
	 * 
	 * @param produto    o produto a ser alterado
	 * @param quantidade quantidade a ser baixada do estoque
	 */
	public void baixarEstoque(Produto produto, double quantidade) {

		for (Produto item : produtos) {
			if (item.equals(produto)) {
				double qtdEstoque = item.getQuantidadeEmEstoque() - quantidade;
				item.setQuantidadeEmEstoque(qtdEstoque);
			}
		}
	}

	/**
	 * Cadastra um produto na lista de produtos
	 */
	@Override
	public void cadastrar(Produto produto) {
		this.produtos.add(produto);
	}

	/**
	 * Retorna a lista de produtos
	 */
	@Override
	public ArrayList<Produto> listar() {
		return produtos;
	}

	/**
	 * Altera um item da lista de produtos
	 */
	@Override
	public void alterar(Produto produto) {
	}

	/**
	 * Remove um item da lista de produtos
	 */
	@Override
	public void remover(Produto produto) {
		produtos.remove(produto);
	}

	/**
	 * Retorna um item da lista de produtos
	 */
	@Override
	public Produto get(Integer index) {
		if (index < produtos.size())
			return produtos.get(index);
		else
			return null;
	}

}
