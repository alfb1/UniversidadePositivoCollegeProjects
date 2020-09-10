package views;

import controllers.PessoaController;
import controllers.ProdutoController;
import controllers.VendaController;
import views.utils.MenuUtil;

/**
 * Classe Menu Responsável montar os menus principal e de vendas e as interações
 * com o usuario
 *
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */

public class MenuView {
	private ClienteView clienteView;
	private FuncionarioView funcionarioView;
	private ProdutoView produtoView;
	private FormaPagamentoView formaPagamentoView;
	private VendaView vendaView;

	// compartilhando o mesmo controller entre a clienteView e funcionarioView
	private PessoaController pessoaController;

	// utilizado pelo funcionario para calcular o total da venda
	private VendaController vendaController;

	private ProdutoController produtoController;

	/**
	 * Construtor cria os controllers : VendaController, PessoaController. Cria as
	 * views : ClientView, FuncionarioView, FormaPagamentoView, ProdutoView e
	 * VendaView.
	 * 
	 */
	public MenuView() {
		vendaController = new VendaController();
		pessoaController = new PessoaController();
		produtoController = new ProdutoController();

		clienteView = new ClienteView(pessoaController);
		funcionarioView = new FuncionarioView(pessoaController, vendaController);
		formaPagamentoView = new FormaPagamentoView();

		produtoView = new ProdutoView(produtoController);
		vendaView = new VendaView(vendaController);

		vendaView.setProdutoController(produtoController);
		vendaView.setClienteView(clienteView);
		vendaView.setFormaPagamentoView(formaPagamentoView);
		vendaView.setFuncionarioView(funcionarioView);
		vendaView.setProdutoView(produtoView);
	}

	/**
	 * Metodo para exibir o menu principal
	 * 
	 */
	public void displayMenuPrincipal() {
		Integer result = MenuUtil.showMenuPrincipal();

		if (result != MenuUtil.menuPrincipal.length) {
			switch (result) {
			case 1:
				clienteView.cadastrar();
				break;
			case 2:
				clienteView.listar();
				break;
			case 3:
				funcionarioView.cadastrar();
				break;
			case 4:
				funcionarioView.listar();
				break;
			case 5:
				produtoView.cadastrar();
				break;
			case 6:
				vendaCadastrar();
				break;
			case 7:
				vendaListar();
			}
		} else {
			return;
		}

		displayMenuPrincipal();
	}

	/**
	 * Método para testar se existem cadastros necessários para começar a venda
	 */
	public void vendaCadastrar() {
		if (!cadastroVazio())
			vendaView.cadastrar();
	}

	/**
	 * Método para testar se existem vendas para listar
	 */
	public void vendaListar() {
		if (!cadastroVazio())
			vendaView.listar();

	}

	/**
	 * Metodo para veficar se existem clientes, funcionarios, produtos e formas de
	 * pagamento cadastrados se existirem retorna true senão false
	 * 
	 * @return true se houverem cadastros para a venda
	 */
	public boolean cadastroVazio() {

		boolean clienteVazio = (clienteView.estaVazio());
		boolean produtoVazio = (produtoView.estaVazio());
		boolean formaPgtoVazio = (formaPagamentoView.estaVazio());
		boolean funcionarioVazio = (funcionarioView.estaVazio());

		MenuUtil.clearMsgs();

		if (clienteVazio)
			MenuUtil.addMsg("Não existem clientes cadastrados até o momento.");

		if (funcionarioVazio)
			MenuUtil.addMsg("Não existem funcionários cadastradas até o momento.");

		if (produtoVazio)
			MenuUtil.addMsg("Não existem produtos cadastrados até o momento.");

		if (formaPgtoVazio)
			MenuUtil.addMsg("Não existem formas de pagamento cadastradas até o momento.");

		boolean problemaVenda = (clienteVazio || produtoVazio || formaPgtoVazio || funcionarioVazio);

		if (problemaVenda) {
			MenuUtil.showErrorMgs("Foram encontrados problemas que impedem prosseguir para vendas : ");
			return problemaVenda;
		}

		return problemaVenda;
	}

}
