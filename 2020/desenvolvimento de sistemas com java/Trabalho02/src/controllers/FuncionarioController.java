package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Funcionario;
import models.Pessoa;

/**
 * Classe controladora para o funcionario, reponsável por fazer a conexão entre
 * a classe FuncionarioView e Funcionarios ( repositório )
 * 
 * @author André Brito
 *
 */
public class FuncionarioController {
	private List<Funcionario> funcionarios;
	private PessoaController pessoaController;

	/**
	 * Construtor recebe um objeto PessoaController para armazenar as informações da
	 * classe Cliente. Instancia uma lista de funcionarios
	 * 
	 * @param pessoaController o controller
	 */
	public FuncionarioController(PessoaController pessoaController) {
		funcionarios = new ArrayList<Funcionario>();
		this.pessoaController = pessoaController;
	}

	/**
	 * Metodo para cadastro de Funcionario
	 * 
	 * @param funcionario do tipo Funcionario
	 * @return boolean true em caso de sucesso no cadastro
	 */
	public boolean cadastrar(Funcionario funcionario) {
		return pessoaController.cadastrar(funcionario);
	}

	/**
	 * Método que retorna uma lista do tipo Funcionario
	 * 
	 * @return lista de funcionarios
	 */
	public List<Funcionario> listar() {

		funcionarios.clear();

		for (Pessoa pessoa : pessoaController.listar()) {
			if (pessoa instanceof Funcionario)
				funcionarios.add((Funcionario) pessoa);
		}

		return funcionarios;
	}

	/**
	 * Método que retorna um funcionario pelo índice da lista
	 * 
	 * @param index indice da lista
	 * @return Funcionario
	 */
	public Funcionario get(Integer index) {
		if (index >= 0 && index < funcionarios.size())
			return funcionarios.get(index);
		else
			return null;
	}
}
