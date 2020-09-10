package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Pessoa;

/**
 * Classe controladora para o cliente, repons�vel por fazer a conex�o entre a
 * classe ClienteView e Clientes ( reposit�rio )
 * 
 * @author Andr� Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class ClienteController {
	private List<Cliente> clientes;
	private PessoaController pessoaController;

	/**
	 * Construtor recebe um objeto PessoaController para armazenar as informa��es da
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
	 * M�todo que retorna uma lista do tipo Cliente
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
	 * M�todo que retorna um cliente pelo �ndice da lista
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
