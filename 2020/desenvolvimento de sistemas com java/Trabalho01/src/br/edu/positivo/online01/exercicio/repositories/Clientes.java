package br.edu.positivo.online01.exercicio.repositories;

/**
 * Classe Clientes - Responsável por guardar em memória  uma lista de todos os clientes cadastrados; 
 * 
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */

import java.util.ArrayList;
import java.util.List;

import br.edu.positivo.online01.exercicio.models.Cliente;

public class Clientes {
	List<Cliente> clientes = new ArrayList<Cliente>();

	public void salvar(String nome, String cpf) {

		if (!temCpfCadastrado(cpf)) {
			Cliente cliente = new Cliente(nome, cpf);
			clientes.add(cliente);
		}
	}

	public boolean temCpfCadastrado(String cpf) {
		if (clientes.size() > 0)
			for (Cliente cli : clientes) {
				if (cli.getCpf().contentEquals(cpf)) {
					return true;
				}
			}
		return false;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void listar() {
		if (clientes.size() > 0) {
			System.out.printf("%s%10s%20s\n", "Codigo", "Nome", "Cpf");
			for (Cliente item : clientes) {
				System.out.printf("%5d       %-15s      %-20s\n", clientes.indexOf(item), item.getNome(), item.getCpf());
			}
			System.out.println("");
		}
	}

	public Cliente get(int index) {
		if (index < clientes.size())
			return clientes.get(index);
		else
			return null;
	}

}
