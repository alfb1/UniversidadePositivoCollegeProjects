package br.edu.positivo.online01.exercicio.controllers;

import br.edu.positivo.online01.exercicio.models.Cliente;
import br.edu.positivo.online01.exercicio.models.FormaPagamento;
import br.edu.positivo.online01.exercicio.models.ItemVenda;
import br.edu.positivo.online01.exercicio.models.Produto;
import br.edu.positivo.online01.exercicio.models.Venda;
import br.edu.positivo.online01.exercicio.repositories.Clientes;
import br.edu.positivo.online01.exercicio.repositories.Console;
import br.edu.positivo.online01.exercicio.repositories.FormasPagamento;
import br.edu.positivo.online01.exercicio.repositories.Produtos;
import br.edu.positivo.online01.exercicio.repositories.Vendas;
import br.edu.positivo.online01.exercicio.view.Menu;

/**
 * Classe para vendas, sendo necessário também clientes, produtos e formas de pagamento cadastrados antes
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 */

public class VendaController {
	Clientes clientes  = new Clientes();
	FormasPagamento fp = new FormasPagamento();
	Produtos produtos  = new Produtos();
	Vendas vendas      = new Vendas();

	/**
	 * Metodo para exibir o menu principal
	 * 
	 */
	public void displayMenuPrincipal() {
		Integer result = Menu.showMenuPrincipal();

		if (result != Menu.menuPrincipal.length) {
			switch (result) {
			case 1:
				cadastroClientes();
				break;
			case 2:
				clientes.listar();
				break;
			case 3:
				cadastroProdutos();
				break;
			case 4:
				produtos.listar();
				break;
			case 5:
				cadastroFormasPagamento();
				break;
			case 6:
				fp.listar();
				break;
			case 7:
				if (podeVender())
					displayMenuVendas();
				break;
			}
		} else {
			return;
		}

		displayMenuPrincipal();
	}

	/**
	 * Metodo para exibir o menu de vendas
	 * 
	 */
	public void displayMenuVendas() {

		Integer result = Menu.showMenuVendas();

		if (result != Menu.menuVendas.length) {
			switch (result) {
			case 1:
				cadastroVendas();
				break;
			case 2:
				vendas.listar();
				break;
			case 3:
				listarVendasFormaPagamento();
				break;
			}
		} else {
			return;
		}

		displayMenuVendas();
	}

	/**
	 * Metodo para solicitar ao usuario que escolha uma forma de pagamento para a venda
	 * 
	 * @return FormaPagamento
	 */
	
	public FormaPagamento infoFormaPagamento() {
		Integer codigo;
		FormaPagamento pgto = null;

		Menu.showText("Selecione a forma de pagamento ");
		// lista as opções de pagamento disponíveis
		fp.listar();
		do {
			// selecao da forma de pagamento pelo codigo
			codigo = Console.lerInteiro("Código da forma de pagamento : ");
			pgto = fp.get(codigo);

			if (pgto == null)
				Menu.showText("Forma de pagamento inválida, tente novamente...");

		} while (pgto == null);

		return pgto;
	}

	/**
	 * Metodo para cadastro de clientes
	 * 
	 */
	public void cadastroClientes() {
		String nome;
		String cpf;

		Menu.showText("Cadastro de clientes");

		nome = Console.lerTexto("Nome :");
		cpf = Console.lerTexto("Cpf  :");

		clientes.salvar(nome, cpf);

		if (Menu.continuar())
			cadastroClientes();
	}

	/**
	 * Metodo para cadastro de produtos
	 * 
	 */
	public void cadastroProdutos() {
		Menu.showText("Cadastro de Produtos");
		produtos.cadastrar();
		if (Menu.continuar())
			cadastroProdutos();
	}

	/**
	 * Metodo para cadastro das formas de pagamento
	 * 
	 */
	public void cadastroFormasPagamento() {
		System.out.println("Cadastro de Forma de Pagamento");
		fp.cadastrar();
		if (Menu.continuar())
			cadastroFormasPagamento();
	}

	/**
	 * Metodo para veficar se existem clientes, produtos e formas de pagamento
	 * cadastrados se existirem retorna true senão false
	 * 
	 * @return boolean
	 */
	public boolean podeVender() {

		boolean temClientes = (clientes.getClientes().size() > 0);
		boolean temProdutos = (produtos.getProdutos().size() > 0);
		boolean temFormaPgtos = (fp.getFormaPagamentos().size() > 0);

		Menu.clearMsgs();

		if (!temClientes)
			Menu.addMsg("Não existem clientes cadastrados até o momento.");

		if (!temProdutos)
			Menu.addMsg("Não existem produtos cadastrados até o momento.");

		if (!temFormaPgtos)
			Menu.addMsg("Não existem formas de pagamento cadastradas até o momento.");

		if (!temClientes || !temProdutos || !temFormaPgtos) {
			Menu.showErrorMgs("Foram encontrados problemas que impedem o cadastro de vendas : ");
			return false;
		}

		return true;
	}

	/**
	 * Metodo para solicitar o cadastro da venda
	 * 
	 */
	public void cadastroVendas() {
		Cliente cliente;
		Venda venda;
		ItemVenda item;
		
		Menu.showText("Cadastro de vendas");
		Menu.showText("Selecione o cliente ");

		// exibe a lista de clientes disponíveis
		clientes.listar();

		// seleciona o cliente
		do {
			// selecao do codigo do cliente pelo usuário
			Integer codigo = Console.lerInteiro("Código do cliente : "); // busca o cliente da lista pelo codigo
			cliente = clientes.get(codigo);
			if (cliente == null)
				Menu.showText("Cliente inválido, tente novamente...");
		} while (cliente == null);

		// Cria uma venda para um cliente
		venda = new Venda(cliente);

		// venda dos itens
		do {
			item = venderItem();

			if (item != null) {
				item.setVenda(venda);
				venda.addItem(item);

			}
		} while (Menu.continuar());

		// encerra a venda solicitando a forma de pagamento
		FormaPagamento fp = infoFormaPagamento();

		// insere a forma de pagamento na venda
		venda.setFormaPagamento(fp);
		// adiciona a lista de vendas
		vendas.cadastrar(venda);

	}
	
	/**
	 * Metodo para proceder a venda de um produto
	 * 
	 * @return ItemVenda
	 */
	public ItemVenda venderItem() {
		ItemVenda item = null;
		Produto produto;
		Integer codProduto;

		Menu.showText("Selecione o produto ");
		// Exibe a lista dos produtos
		produtos.listar();

		// pega o produto na lista
		do {
			// selecao do produto pelo codigo
			codProduto = Console.lerInteiro("Código do produto : ");
			produto = produtos.get(codProduto);

			if (produto == null)
				Menu.showText("Produto inválido, tente novamente...");

		} while (produto == null);

		// Informa a qtd disponível em estoque :
		Menu.showText("Quantidade disponível em estoque : " + produto.getQuantidadeEmEstoque());
		Menu.showText("Obs.:  informe 0 para cancelar ");

		Boolean qtdOk = false;

		do {
			// Solicita a quantidade desejada do usuário
			Double qtd = Console.lerDecimal("Informe a quantidade : ");

			// usuario cancela a compra
			if (qtd == 0) {
				break;
			}

			if (qtd > produto.getQuantidadeEmEstoque()) {
				Menu.showText("Quantidade solicitada [" + qtd + "] maior do que a disponível : "
						+ produto.getQuantidadeEmEstoque());
			} else {
				qtdOk = true;
				produto.baixarEstoque(qtd);
				item = new ItemVenda(produto, qtd);
			}

		} while (!qtdOk);

		return item;
	}

	/**
	 * Metodo para listagem de vendas pela forma de pagamento
	 * 
	 */
	public void listarVendasFormaPagamento() {
		// seleção da forma de pagamento
		FormaPagamento fp = infoFormaPagamento();
		// listagem pela forma de pagamento
		vendas.listar(fp);
	}

}
