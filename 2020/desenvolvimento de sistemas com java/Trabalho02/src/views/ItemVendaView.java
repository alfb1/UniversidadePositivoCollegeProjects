package views;

import models.ItemVenda;
import models.Produto;
import views.utils.MenuUtil;

/**
 * Classe view para a intera��o com o usu�rio e as opera��es de cadastro de
 * itemVenda
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class ItemVendaView {
	private ProdutoView produtoView;
	// private ProdutoController produtoController;

	public ItemVendaView() {
	}

	/**
	 * Metodo set para o atributo produtoView
	 * 
	 * @param produtoView view do produto
	 */
	public void setProdutoView(ProdutoView produtoView) {
		this.produtoView = produtoView;
	}

	/**
	 * Metodo para cadastro de itens da venda
	 * 
	 * @return ItemVenda
	 */
	public ItemVenda cadastrar() {
		ItemVenda itemVenda = null;

		Produto produto = produtoView.selecionar();

		// Informa a qtd dispon�vel em estoque :
		MenuUtil.showText("Quantidade dispon�vel em estoque : " + produto.getQuantidadeEmEstoque());
		MenuUtil.showText("Obs.:  informe 0 para cancelar. ");

		Double qtd = produtoView.getQuantidade(produto);

		if (qtd > 0) {
			itemVenda = new ItemVenda(produto, qtd);
		}

		return itemVenda;
	}

}
