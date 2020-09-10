package repositories;

import java.util.ArrayList;

import models.FormaPagamento;

/**
 * Classe responsável por guardar em memória uma lista de todos as formas de
 * pagamento cadastradas;
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class FormasPagamento implements IRepository<FormaPagamento> {
	ArrayList<FormaPagamento> formasPagamento;

	public FormasPagamento() {
		formasPagamento = new ArrayList<FormaPagamento>();
	}

	/**
	 * Construtor recebe um objeto FormaPagamento para inserir na lista
	 * formasPagamento
	 * 
	 * @param formaPagamento objeto para inserir na lista
	 */
	@Override
	public void cadastrar(FormaPagamento formaPagamento) {
		formasPagamento.add(formaPagamento);
	}

	/**
	 * Listagem das formas de pagamento
	 * 
	 * @return a lista de FormasPagamento
	 */
	@Override
	public ArrayList<FormaPagamento> listar() {
		return this.formasPagamento;
	}

	/**
	 * Retorna um item FormaPagamento da lista interna formasPagamento
	 * 
	 * @param index índice na lista
	 * @return um objeto FormaPagamento
	 */
	@Override
	public FormaPagamento get(Integer index) {
		return formasPagamento.get(index);
	}

	/**
	 * Altera um item da forma de pagamento
	 */
	@Override
	public void alterar(FormaPagamento formaPagamento) {
		// TODO Auto-generated method stub

	}

	/**
	 * Remove uma forma de pagamento da lista
	 */
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formasPagamento.remove(formaPagamento);
	}

}
