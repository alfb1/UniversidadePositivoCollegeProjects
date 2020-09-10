package br.edu.up.sistemapedido.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.sistemapedido.entity.Cliente;

@ManagedBean(name="mbeanCliente")
@SessionScoped()
public class MBeanCliente {

	  private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	  private Cliente cliente = new Cliente();
	  

	public String salvar() {
		
    	clientes.add(cliente);    	
		clientes.forEach(item-> System.out.println(item));
	    cliente = new Cliente();
		
		return "listaCliente.jsf";
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	  
	  
}
