package repositories;

import java.util.ArrayList;

import models.ItemVenda;

/**
 * Classe responsável por guardar em memória uma lista de itens vendidos
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class ItensVenda implements IRepository<ItemVenda> {
	private ArrayList<ItemVenda> itensVenda;

	/**
	 * Construtor instancia uma lista de ItemVenda
	 */
	public ItensVenda() {
		itensVenda = new ArrayList<ItemVenda>();
	}

	/**
	 * Cadastra um item na lista
	 * 
	 * @param itemVenda item para o cadastro
	 */
	public void cadastrar(ItemVenda itemVenda) {
		itensVenda.add(itemVenda);
	}

	/**
	 * Listagem da lista de ItemVenda
	 * 
	 * @return a lista armazenada
	 */
	public ArrayList<ItemVenda> listar() {
		return itensVenda;
	}

	/**
	 * Altera um item da lista
	 */
	@Override
	public void alterar(ItemVenda itemVenda) {
		// TODO Auto-generated method stub

	}

	/**
	 * Remove um item da lista
	 */
	@Override
	public void remover(ItemVenda itemVenda) {
		itensVenda.remove(itemVenda);
	}

	/**
	 * Retorna um item da lista
	 * 
	 * @param index índice na lista
	 * @return objeto correspondente ao índice informado
	 */
	@Override
	public ItemVenda get(Integer index) {
		return itensVenda.get(index);
	}

}
