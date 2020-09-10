package views;

import java.util.List;

import controllers.ProdutoController;
import models.Produto;
import utils.Console;
import views.utils.MenuUtil;

/**
 * Classe view para Produto, repons�vel pela intera��o do usu�rio com as
 * funcionalidades do programa para cadastro de produtos atrav�s da classe
 * ProdutoController
 * 
 * @author Andr� Brito
 * @author Franccescoly Emmanuel Camargo
 */
public class ProdutoView {

	private ProdutoController produtoController;

	/**
	 * Construtor instancia um objeto produtoController da classe ProdutoController
	 * 
	 * @param produtoController controller do produto
	 */
	public ProdutoView(ProdutoController produtoController) {
		this.produtoController = produtoController;
	}

	/**
	 * Metodo para receber informa��es do usu�rio para nome, quantidade e pre�o de
	 * um produto
	 * 
	 * @return Produto
	 */
	public Produto getProduto() {
		String nome;
		Double qtd;
		Double preco;

		nome = Console.lerTexto("Nome :");
		qtd = Console.lerDecimal("Qtd em estoque :");
		preco = Console.lerDecimal("Preco de venda :");

		Produto produto = new Produto(nome);

		produto.setQuantidadeEmEstoque(qtd);
		produto.setPreco(preco);

		return produto;
	}

	/**
	 * Metodo para cadastro de produto na lista de produtos atav�s do controller
	 * produtoController
	 * 
	 */
	public void cadastrar() {
		MenuUtil.showTitle("Cadastro de Produtos");
		Produto produto = getProduto();

		boolean resp = produtoController.cadastrar(produto);

		MenuUtil.msgCadastro("Produto", resp);

		if (MenuUtil.continuar())
			cadastrar();
	}

	/**
	 * M�todo que lista na tela os produtos cadastrados ou uma mensagem caso ainda
	 * n�o existam produtos cadastrados
	 * 
	 */
	public void listar() {

		MenuUtil.showTitle("Listagem de produtos");

		if (estaVazio()) {
			MenuUtil.showText("N�o existem produtos cadastrados ainda...");
			return;
		}

		List<Produto> produtos = produtoController.listar();

		System.out.printf("%s%10s%22s%23s\n", "Codigo", "Nome", "Estoque", "Pre�o de venda");
		produtos.forEach(item -> {
			System.out.printf("%5d       %-15s      %5.2f      %15.2f\n", produtos.indexOf(item), item.getNome(),
					item.getQuantidadeEmEstoque(), item.getPreco());
		});
	}

	/**
	 * M�todo para testar se existem produtos na lista
	 * 
	 * @return boolean true se a lista estiver vazia
	 */
	public boolean estaVazio() {
		return produtoController.listar().size() == 0;
	}

	/**
	 * M�todo que exibe uma lista de produtos cadastrados e aguarda pela sele��o do
	 * usu�rio pelo �ndice do produto na lista
	 * 
	 * @return produto selecionado
	 */
	public Produto selecionar() {
		Produto produto;
		Integer codigo;

		MenuUtil.showTitle("Selecione o produto ");
		listar();

		// pega o produto na lista
		do {
			// selecao do produto pelo codigo
			codigo = Console.lerInteiro("Inform o c�digo : ");
			produto = produtoController.get(codigo);

			if (produto == null)
				MenuUtil.showText("Produto inv�lido, tente novamente...");

		} while (produto == null);

		return produto;
	}

	/**
	 * M�todo que aguarda por uma quantidade informada pelo usu�rio, verifica a
	 * disponibilidade e avisa se a quantidade informada for acima da dispon�vel.
	 * 
	 * @param produto produto da venda
	 * @return quantidade informada pelo usu�rio
	 */
	public Double getQuantidade(Produto produto) {
		Double qtd = 0.0;
		boolean qtdOk = false;

		do {
			// Solicita a quantidade desejada do usu�rio
			qtd = Console.lerDecimal("Informe a quantidade : ");

			// usuario cancela a compra
			if (qtd == 0) {
				break;
			}

			if (qtd > produto.getQuantidadeEmEstoque()) {
				MenuUtil.showText("Quantidade solicitada [" + qtd + "] maior do que a dispon�vel : "
						+ produto.getQuantidadeEmEstoque());
			} else {
				qtdOk = true;
			}

		} while (!qtdOk);

		return qtd;
	}

}
