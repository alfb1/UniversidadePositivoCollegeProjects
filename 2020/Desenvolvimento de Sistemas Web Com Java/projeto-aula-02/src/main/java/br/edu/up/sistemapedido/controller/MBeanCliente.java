package br.edu.up.sistemapedido.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.up.sistemapedido.dao.ClienteDao;
import br.edu.up.sistemapedido.entity.Cliente;

@ManagedBean(name = "mbeanCliente")
public class MBeanCliente {

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	
	@PostConstruct
	public void listar() {
		ClienteDao clienteDao = new ClienteDao();
		clientes = clienteDao.listar();
	}
	
	public String salvar() {

		if (cliente.getId() == null) {
			new ClienteDao().salvar(cliente);
		} else {
			new ClienteDao().alterar(cliente);
		}
		
		cliente  = new Cliente();
		clientes = null;
		
		return "listaCliente.jsf";
	}
	
	public String carregar(Cliente cliente) {
		this.cliente = cliente;
		return "cadastroCliente.jsf";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		
		if ( clientes == null ) { listar(); }
		 
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	public String editar(Cliente cliente) {
		this.cliente = cliente;
		return "cadastroCliente.jsf";
	}
	
	public String deletar(Cliente cliente) {
		
		new ClienteDao().excluir(cliente);
		clientes = null;
		return "listaCliente.jsf";
	}
}
