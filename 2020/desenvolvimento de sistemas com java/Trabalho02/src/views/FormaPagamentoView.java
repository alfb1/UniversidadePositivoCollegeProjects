package views;

import java.util.List;

import controllers.FormaPagamentoController;
import models.FormaPagamento;
import utils.Console;
import views.utils.MenuUtil;

/**
 * Classe view para a interação com o usuário e as operações de cadastro,
 * listagem e seleção de forma de pagamento.
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class FormaPagamentoView {
	private FormaPagamentoController formaPagamentoController;

	/**
	 * Construtor recebe um objeto da classe FormaPagamentoController
	 * 
	 */
	public FormaPagamentoView() {
		formaPagamentoController = new FormaPagamentoController();
	}

	/**
	 * Metodo para cadastro das formas de pagamento
	 * 
	 */
	public void cadastrar() {
		MenuUtil.showTitle("Cadastro de formas de pagamento");

		String nome = Console.lerTexto("Nome :");
		FormaPagamento formaPagamento = new FormaPagamento(nome);

		boolean resp = formaPagamentoController.cadastrar(formaPagamento);

		MenuUtil.msgCadastro("Forma de pagamento", resp);

		if (MenuUtil.continuar())
			cadastrar();
	}

	/**
	 * Método que lista na tela as formas de pagamento cadastradas ou uma mensagem
	 * caso ainda não existam cadastros
	 * 
	 */
	public void listar() {

		MenuUtil.showTitle("Listagem de formas de pagamento");

		if (!estaVazio()) {
			List<FormaPagamento> formasPagamento = formaPagamentoController.listar();
			System.out.printf("%s%10s\n", "Código", "Nome");

			formasPagamento.forEach(item -> {
				System.out.printf("%5d  %-10s\n", formasPagamento.indexOf(item), item.getNome());
			});
		} else {
			MenuUtil.showText("Não existem formas de pagamento cadastradas até o momento.");
		}
	}

	/**
	 * Método para testar se existem formas de pagamento na lista
	 * 
	 * @return boolean true se a lista estiver vazia
	 */
	public boolean estaVazio() {
		return formaPagamentoController.listar().size() == 0;
	}

	/**
	 * Metodo para solicitar ao usuario que escolha uma forma de pagamento
	 * 
	 * @return FormaPagamento
	 */

	public FormaPagamento selecionar() {
		Integer codigo;
		FormaPagamento formaPagamento = null;

		MenuUtil.showTitle("Selecione a forma de pagamento ");

		// lista as opções de pagamento disponíveis
		listar();

		do {
			// selecao da forma de pagamento pelo codigo
			codigo = Console.lerInteiro("Código da forma de pagamento : ");
			formaPagamento = formaPagamentoController.get(codigo);

			if (formaPagamento == null)
				MenuUtil.showText("Forma de pagamento inválida, tente novamente...");

		} while (formaPagamento == null);

		return formaPagamento;
	}

}
