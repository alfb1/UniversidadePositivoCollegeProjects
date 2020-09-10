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
 * Classe view para a intera��o com o usu�rio e as opera��es de cadastro,
 * listagem e sele��o de funcion�rio.
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
	 * necess�rio para pegar informa��es das vendas do funcion�rio ).
	 * 
	 * @param pessoaController controller de pessoa
	 * @param vendaController  controller de venda
	 */
	public FuncionarioView(PessoaController pessoaController, VendaController vendaController) {
		funcionarioController = new FuncionarioController(pessoaController);
		this.vendaController = vendaController;
	}

	/**
	 * Metodo para receber informa��es do usu�rio para nome, cpf e salario de um
	 * funcion�rio
	 * 
	 * @return Funcionario
	 */
	public Funcionario getFuncionario() {
		String nome, cpf;
		double salario;

		nome = Console.lerTexto("Nome :");
		cpf = Console.lerTexto("Cpf  :");
		salario = Console.lerDecimal("Sal�rio  :");

		Funcionario funcionario = new Funcionario(nome, cpf, salario);

		return funcionario;
	}

	/**
	 * Metodo para cadastro de um funcion�rio na lista de funcion�rios atrav�s do
	 * controller funcionarioController
	 * 
	 */
	public void cadastrar() {

		MenuUtil.showTitle("Cadastro de Funcion�rios");
		Funcionario funcionario = getFuncionario();

		boolean resp = funcionarioController.cadastrar(funcionario);

		MenuUtil.msgCadastro("Funcion�rio", resp);

		if (MenuUtil.continuar())
			cadastrar();
	}

	/**
	 * M�todo que lista na tela os funcion�rios cadastrados ou uma mensagem caso
	 * ainda n�o existam cadastros
	 * 
	 */
	public void listar() {

		MenuUtil.showTitle("Listagem de funcion�rios");

		if (estaVazio()) {
			MenuUtil.showText("N�o existem funcion�rios cadastrados ainda...");
			return;
		}

		List<Funcionario> funcionarios = funcionarioController.listar();

		System.out.printf("%s%10s%20s%20s%17s%20s%15s\n", "Codigo", "Nome", "Cpf", "Sal�rio", "Vendas",
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
	 * M�todo para testar se existem funcion�rios na lista
	 * 
	 * @return boolean true se a lista estiver vazia
	 */
	public boolean estaVazio() {
		return funcionarioController.listar().size() == 0;
	}

	/**
	 * M�todo que exibe uma lista de funcion�rios cadastrados e aguarda pela sele��o
	 * do usu�rio pelo �ndice do funcion�rio na lista
	 * 
	 * @return funcion�rio selecionado
	 */
	public Funcionario selecionar() {
		Funcionario funcionario;
		Integer codigo;

		MenuUtil.showText("Selecione o funcion�rio : ");
		listar();

		// pega o produto na lista
		do {
			// selecao do produto pelo codigo
			codigo = Console.lerInteiro("Informe o C�digo  : ");
			funcionario = funcionarioController.get(codigo);

			if (funcionario == null)
				MenuUtil.showText("Funcion�rio inv�lido, tente novamente...");

		} while (funcionario == null);

		return funcionario;
	}

}
