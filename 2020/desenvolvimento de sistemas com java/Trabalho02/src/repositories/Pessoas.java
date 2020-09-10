package repositories;

import java.util.ArrayList;

import models.Pessoa;

/**
 * Classe responsável por guardar em memória uma lista tanto de clientes como de
 * funcionários
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class Pessoas implements IRepository<Pessoa> {
	private ArrayList<Pessoa> pessoas;

	/**
	 * Construtor instancia a lista de Pessoa
	 */
	public Pessoas() {
		pessoas = new ArrayList<Pessoa>();
	}

	/**
	 * Cadastra uma pessoa na lista
	 * 
	 * @param pessoa item a ser cadastrado
	 */
	@Override
	public void cadastrar(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	/**
	 * Listagem de pessoas
	 * 
	 * @return lista de pessoas cadastradas
	 */
	@Override
	public ArrayList<Pessoa> listar() {
		return pessoas;
	}

	/**
	 * Altera uma pessoa da lista
	 * 
	 * @param pessoa pessoa a ser alterada
	 */
	@Override
	public void alterar(Pessoa pessoa) {
		// TODO Auto-generated method stub

	}

	/**
	 * Exclui uma pessoa da lista
	 * 
	 * @param pessoa pessoa a ser excluida
	 */
	@Override
	public void remover(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}

	/**
	 * Retorna uma pessoa da lista
	 * 
	 * @param index indice da pessoa na lista
	 */
	@Override
	public Pessoa get(Integer index) {
		return pessoas.get(index);
	}

}
