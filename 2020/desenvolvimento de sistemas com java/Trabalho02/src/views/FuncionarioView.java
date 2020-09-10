package views;

import java.util.List;

import controllers.FuncionarioController;
import controllers.PessoaController;
import controllers.VendaController;
import models.Comissao;
import models.Funcionario;
import utils.Console;
import views.utils.MenuUtil;

/**
 * Classe view para a interação com o usuário e as operações de cadastro,
 * listagem e seleção de funcionário.
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class FuncionarioView {
	private FuncionarioController funcionarioController;
	private VendaController vendaController;

	/**
	 * Construtor recebe um objeto da classe PessoaController e VendaController (
	 * necessário para pegar informações das vendas do funcionário ).
	 * 
	 * @param pessoaController controller de pessoa
	 * @param vendaController  controller de venda
	 */
	public FuncionarioView(PessoaController pessoaController, VendaController vendaController) {
		funcionarioController = new FuncionarioController(pessoaController);
		this.vendaController = vendaController;
	}

	/**
	 * Metodo para receber informações do usuário para nome, cpf e salario de um
	 * funcionário
	 * 
	 * @return Funcionario
	 */
	public Funcionario getFuncionario() {
		String nome, cpf;
		double salario;

		nome = Console.lerTexto("Nome :");
		cpf = Console.lerTexto("Cpf  :");
		salario = Console.lerDecimal("Salário  :");

		Funcionario funcionario = new Funcionario(nome, cpf, salario);

		return funcionario;
	}

	/**
	 * Metodo para cadastro de um funcionário na lista de funcionários através do
	 * controller funcionarioController
	 * 
	 */
	public void cadastrar() {

		MenuUtil.showTitle("Cadastro de Funcionários");
		Funcionario funcionario = getFuncionario();

		boolean resp = funcionarioController.cadastrar(funcionario);

		MenuUtil.msgCadastro("Funcionário", resp);

		if (MenuUtil.continuar())
			cadastrar();
	}

	/**
	 * Método que lista na tela os funcionários cadastrados ou uma mensagem caso
	 * ainda não existam cadastros
	 * 
	 */
	public void listar() {

		MenuUtil.showTitle("Listagem de funcionários");

		if (estaVazio()) {
			MenuUtil.showText("Não existem funcionários cadastrados ainda...");
			return;
		}

		List<Funcionario> funcionarios = funcionarioController.listar();

		System.out.printf("%s%10s%20s%20s%17s%20s%15s\n", "Codigo", "Nome", "Cpf", "Salário", "Vendas",
				"Comissao(" + Comissao.FUNIONARIO + ")", "Sal. Total");

		funcionarios.forEach(item -> {

			double totalVendas = vendaController.calcularVendas(item);
			double comissao = vendaController.calcularComissao(totalVendas);
			double salTotal = comissao + item.getSalario();
			System.out.printf("%5d       %-15s      %-10s  %12.2f  %12.2f  %12.2f  %20.2f\n",
					funcionarios.indexOf(item), item.getNome(), item.getCpf(), item.getSalario(), totalVendas, comissao,
					salTotal);
		});

		MenuUtil.showText("");

	}

	/**
	 * Método para testar se existem funcionários na lista
	 * 
	 * @return boolean true se a lista estiver vazia
	 */
	public boolean estaVazio() {
		return funcionarioController.listar().size() == 0;
	}

	/**
	 * Método que exibe uma lista de funcionários cadastrados e aguarda pela seleção
	 * do usuário pelo índice do funcionário na lista
	 * 
	 * @return funcionário selecionado
	 */
	public Funcionario selecionar() {
		Funcionario funcionario;
		Integer codigo;

		MenuUtil.showText("Selecione o funcionário : ");
		listar();

		// pega o produto na lista
		do {
			// selecao do produto pelo codigo
			codigo = Console.lerInteiro("Informe o Código  : ");
			funcionario = funcionarioController.get(codigo);

			if (funcionario == null)
				MenuUtil.showText("Funcionário inválido, tente novamente...");

		} while (funcionario == null);

		return funcionario;
	}

}
