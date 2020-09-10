package br.edu.positivo.online01.exercicio.models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Venda 
 * 
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */

public class Venda {
	int codigo;
	LocalDateTime data;
	Cliente cliente;
	List<ItemVenda> items = new ArrayList<ItemVenda>();
	FormaPagamento formaPagamento;
	
	public Venda(Cliente cliente) {
		this.data = LocalDateTime.now();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ItemVenda> getItems() {
		return items;
	}

	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}
	
	public void addItem(ItemVenda item) {
		this.items.add(item);
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
	

}
