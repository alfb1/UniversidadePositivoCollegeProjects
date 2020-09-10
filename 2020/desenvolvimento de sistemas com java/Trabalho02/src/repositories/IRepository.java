package repositories;

import java.util.ArrayList;

/**
 * Interface de repositório para as operações CRUD do sistema será utilizada por
 * todos os repositórios
 * 
 * @author André Brito
 * @author Franccescoly Emmanuel Camargo
 *
 * @param <T> Tipo de objeto do repositório a ser implementado
 */
public interface IRepository<T> {
	/**
	 * Cadastra um item na lista
	 * 
	 * @param object objeto a ser cadastrado
	 */
	void cadastrar(T object);

	/**
	 * Listagem dos itens
	 * 
	 * @return retorna a lista de itens
	 */
	ArrayList<T> listar();

	/**
	 * Altera um item da lista
	 * 
	 * @param object o item a ser alterado
	 */
	void alterar(T object);

	/**
	 * Remove um item da lista
	 * 
	 * @param object a ser removido
	 */
	void remover(T object);

	/**
	 * Retorna um item da lista
	 * 
	 * @param index indice do item
	 * @return o objeto da lista
	 */
	T get(Integer index);
}
