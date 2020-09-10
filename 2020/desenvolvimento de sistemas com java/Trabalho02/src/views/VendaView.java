package views;

import java.util.List;

import controllers.ProdutoController;
import controllers.VendaController;
import models.Cliente;
import models.FormaPagamento;
import models.Funcionario;
import models.ItemVenda;
import models.Venda;
import views.utils.MenuUtil;

/**
 * Classe view para a venda, reponsável por fazer a conexão entre a classe
 * VendaView e a as VendaController
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class VendaView {
	private ClienteView clienteView;
	private FuncionarioView funcionarioView;
	private FormaPagamentoView formaPagamentoView;
	private ItemVendaView itemVendaView;

	private VendaController vendaController;
	private ProdutoController produtoController;

	/**
	 * Construtor instancia um objeto vendaController da classe VendaController e a
	 * view itemVendaView da classe ItemVendaView
	 * 
	 * @param vendaController controller da venda
	 */
	public VendaView(VendaController vendaController) {
		this.vendaController = vendaController;
		itemVendaView = new ItemVendaView();
	}

	public void setProdutoController(ProdutoController produtoController) {
		this.produtoController = produtoController;
	}

	/**
	 * Metodo set para o atributo clienteView
	 * 
	 * @param clienteView view do cliente
	 */
	public void setClienteView(ClienteView clienteView) {
		this.clienteView = clienteView;
	}

	/**
	 * Metodo set para atributo funcionarioView
	 * 
	 * @param funcionarioView view do funcionario
	 */
	public void setFuncionarioView(FuncionarioView funcionarioView) {
		this.funcionarioView = funcionarioView;
	}

	/**
	 * Metodo set para atributo formaPagamentoView
	 * 
	 * @param formaPagamentoView view da forma de pagamento
	 */
	public void setFormaPagamentoView(FormaPagamentoView formaPagamentoView) {
		this.formaPagamentoView = formaPagamentoView;
	}

	/**
	 * Metodo set para atributo produtoView
	 * 
	 * @param produtoView view do produto
	 */
	public void setProdutoView(ProdutoView produtoView) {
		this.itemVendaView.setProdutoView(produtoView);
	}

	/**
	 * Metodo para listar as vendas - todas
	 * 
	 */
	public void listar() {
		List<Venda> vendas = vendaController.listar();

		MenuUtil.showTitle("Relatório de Vendas - Todos");

		if (vendas.size() > 0) {
			vendas.forEach(item -> {
				VendaUtilView.listarVenda(item, vendas.indexOf(item));
			});
		}
	}

	/**
	 * Metodo para listar as vendas - pela forma de pagamento
	 * 
	 * @param formaPagamento da venda
	 */
	public void listar(FormaPagamento formaPagamento) {

		List<Venda> vendas = vendaController.listar(formaPagamento);
		MenuUtil.showTitle("Relatório de Vendas - Forma de Pagamento");

		if (vendas.size() > 0) {
			vendas.forEach(item -> {
				VendaUtilView.listarVenda(item, vendas.indexOf(item));
			});
		} else {
			MenuUtil.showText("Não há vendas cadastradas no momento para a forma de pagamento : ["
					+ formaPagamento.getNome() + "] no momento...");
		}

	}

	/**
	 * Metodo set para cadastro das vendas
	 * 
	 */
	public void cadastrar() {
		Venda venda;
		Funcionario funcionario;
		Cliente cliente;
		ItemVenda item;
		FormaPagamento formaPagamento;

		MenuUtil.showTitle("Cadastro de vendas");

		// selecionar o funcionario
		funcionario = funcionarioView.selecionar();

		// seleciona o cliente
		cliente = clienteView.selecionar();

		// nova venda
		venda = new Venda(cliente);
		venda.setFuncionario(funcionario);
		venda.setCliente(cliente);

		// venda dos itens
		do {
			item = itemVendaView.cadastrar();
			if (item != null) {
				// abate o estoque
				produtoController.baixarEstoque(item.getProduto(), item.getQuantidade());
				venda.addItem(item);
			}

		} while (MenuUtil.continuar());

		// seleciona a forma de pagamento
		formaPagamento = formaPagamentoView.selecionar();

		// insere a forma de pagamento na venda
		venda.setFormaPagamento(formaPagamento);
		// adiciona a lista de vendas
		vendaController.cadastrar(venda);

	}

}
