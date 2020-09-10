package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Pessoa;

/**
 * Classe controladora para o cliente, reponsável por fazer a conexão entre a
 * classe ClienteView e Clientes ( repositório )
 * 
 * @author André Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class ClienteController {
	private List<Cliente> clientes;
	private PessoaController pessoaController;

	/**
	 * Construtor recebe um objeto PessoaController para armazenar as informações da
	 * classe Cliente. Instancia uma lista de clientes.
	 * 
	 * @param pessoaController o controller
	 */
	public ClienteController(PessoaController pessoaController) {
		clientes = new ArrayList<Cliente>();
		this.pessoaController = pessoaController;
	}

	/**
	 * Metodo para cadastro de Cliente
	 * 
	 * @param cliente do tipo Cliente
	 * @return boolean true em caso de sucesso no cadastro
	 */
	public boolean cadastrar(Cliente cliente) {
		return pessoaController.cadastrar(cliente);
	}

	/**
	 * Método que retorna uma lista do tipo Cliente
	 * 
	 * @return lista de clientes
	 */
	public List<Cliente> listar() {

		clientes.clear();

		for (Pessoa pessoa : pessoaController.listar()) {
			if (pessoa instanceof Cliente)
				clientes.add((Cliente) pessoa);
		}
		return clientes;
	}

	/**
	 * Método que retorna um cliente pelo índice da lista
	 * 
	 * @param index indice da lista
	 * @return cliente
	 */
	public Cliente get(Integer index) {
		if ( index >= 0 && index < clientes.size())
		  return clientes.get(index);
		else
			return null;
	}
}
