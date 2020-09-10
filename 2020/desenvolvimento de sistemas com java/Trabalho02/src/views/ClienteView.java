package views;

import java.util.List;

import controllers.ClienteController;
import controllers.PessoaController;
import models.Cliente;
import utils.Console;
import views.utils.MenuUtil;

/**
 * Classe view para a intera��o com o usu�rio e as opera��es de cadastro,
 * listagem e sele��o de cliente.
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class ClienteView {
	private ClienteController clienteController;

	/**
	 * Construtor recebe um objeto da classe PessoaController
	 * 
	 * @param pessoaController controller da pessoa
	 */
	public ClienteView(PessoaController pessoaController) {
		clienteController = new ClienteController(pessoaController);
	}

	/**
	 * Metodo para receber informa��es do usu�rio para nome, cpf e email de um
	 * cliente
	 * 
	 * @return Cliente
	 */
	public Cliente getCliente() {
		String nome, cpf, email;

		nome = Console.lerTexto("Nome :");
		cpf = Console.lerTexto("Cpf  :");
		email = Console.lerTexto("Email  :");

		Cliente cliente = new Cliente(nome, cpf, email);

		return cliente;
	}

	/**
	 * Metodo para cadastro de um cliente na lista de clientes atrav�s do controller
	 * clienteController
	 * 
	 */
	public void cadastrar() {

		MenuUtil.showTitle("Cadastro de clientes");
		Cliente cliente = getCliente();

		boolean resp = clienteController.cadastrar(cliente);

		MenuUtil.msgCadastro("Cliente", resp);

		if (MenuUtil.continuar())
			cadastrar();
	}

	/**
	 * M�todo que lista na tela os clientes cadastrados ou uma mensagem caso ainda
	 * n�o existam cadastros
	 * 
	 */
	public void listar() {

		MenuUtil.showTitle("Listagem de clientes");

		if (estaVazio()) {
			MenuUtil.showText("N�o existem clientes cadastrados ainda...");
			return;
		}

		List<Cliente> clientes = clienteController.listar();

		System.out.printf("%s%10s%20ss%30s\n", "Codigo", "Nome", "Cpf", "Email");
		for (Cliente item : clientes) {
			System.out.printf("%5d       %-15s      %-20s      %-20s\n", clientes.indexOf(item), item.getNome(),
					item.getCpf(), item.getEmail());
		}
		MenuUtil.showText("");

	}

	/**
	 * M�todo para testar se existem clientes na lista
	 * 
	 * @return boolean true se a lista estiver vazia
	 */
	public boolean estaVazio() {
		return clienteController.listar().size() == 0;
	}

	/**
	 * M�todo que exibe uma lista de clientes cadastrados e aguarda pela sele��o do
	 * usu�rio pelo �ndice do cliente na lista
	 * 
	 * @return cliente selecionado
	 */
	public Cliente selecionar() {
		Cliente cliente = null;
		Integer codigo = 0;

		MenuUtil.showTitle("Selecione o cliente : ");
		listar();
		// seleciona o cliente
		do {
			// selecao do codigo do cliente pelo usu�rio
			codigo = Console.lerInteiro("Informe o c�digo : "); // busca o cliente da lista pelo codigo
			cliente = clienteController.get(codigo);
			if (cliente == null)
				MenuUtil.showText("Cliente inv�lido, tente novamente...");
		} while (cliente == null);

		return cliente;

	}
}
