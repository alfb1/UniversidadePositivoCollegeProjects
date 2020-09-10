package controllers;

import java.util.List;

import models.Pessoa;
import repositories.Pessoas;

/**
 * Classe controladora para a Pessoa, repons�vel por fazer a conex�o entre as
 * classes ClienteControler, FuncionarioController e Pessoas ( reposit�rio )
 * 
 * @author Andr� Brito
 * @author Franccescoly Emmanuel Camargo
 *
 */
public class PessoaController {

	private Pessoas pessoas;

	/**
	 * Constructor instancia um objeto pessoas do reposit�rio Pessoas.
	 * 
	 */
	public PessoaController() {
		pessoas = new Pessoas();
	}

	/**
	 * Metodo para cadastro de Pessoa no reposit�rio pessoas
	 * 
	 * @param pessoa do tipo Pessoa
	 * @return boolean true em caso de sucesso no cadastro
	 */
	public boolean cadastrar(Pessoa pessoa) {

		if (temCpfCadastrado(pessoa.getCpf())) {
			return false;
		}

		pessoas.cadastrar(pessoa);
		return true;
	}

	/**
	 * M�todo que retorna uma lista do tipo Pessoa
	 * 
	 * @return lista de pessoas
	 */
	public List<Pessoa> listar() {
		return pessoas.listar();
	}

	/**
	 * M�todo que retorna uma Pessoa pelo �ndice da lista
	 * 
	 * @param index indice da lista
	 * @return Pessoa
	 */
	public Pessoa get(Integer index) {
		return pessoas.get(index);
	}

	/**
	 * Metodo para checar se existe uma cpf j� cadastrado
	 * 
	 * @param cpf do tipo String
	 * @return boolean true se houver item cadastrado
	 */
	public boolean temCpfCadastrado(String cpf) {
		if (pessoas.listar().size() > 0)
			for (Pessoa pessoa : pessoas.listar()) {
				if (pessoa.getCpf().equals(cpf)) {
					return true;
				}
			}
		return false;
	}

}
