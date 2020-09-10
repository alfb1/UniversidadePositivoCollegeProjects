package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Venda
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */

public class Venda {
	int codigo;
	LocalDateTime data;
	Cliente cliente;
	Funcionario funcionario;
	List<ItemVenda> items = new ArrayList<ItemVenda>();
	FormaPagamento formaPagamento;

	/**
	 * Construtor recebe um cliente e seta a data da venda
	 * 
	 * @param cliente da venda
	 */
	public Venda(Cliente cliente) {
		this.data = LocalDateTime.now();
		this.cliente = cliente;
	}

	/**
	 * Método para retornar o atributo cliente
	 * 
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método para setar o atributo cliente
	 * 
	 * @param cliente cliente da venda
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Método para retornar o atributo formaPagamento
	 * 
	 * @return formaPagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * Método para setar o atributo formaPagamento
	 * 
	 * @param formaPagamento formda de pagamento da venda
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	/**
	 * Método para retornar o atributo items
	 * 
	 * @return items
	 */
	public List<ItemVenda> getItems() {
		return items;
	}

	/**
	 * Método para setar o atributo items
	 * 
	 * @param items lista de ItemVenda
	 */
	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}

	/**
	 * Método para adicionar um item de venda
	 * 
	 * @param item item da venda
	 */
	public void addItem(ItemVenda item) {
		this.items.add(item);
	}

	/**
	 * Método para retornar o atributo data
	 * 
	 * @return data
	 */
	public LocalDateTime getData() {
		return data;
	}

	/**
	 * Método para setar o atributo data
	 * 
	 * @param data data da venda
	 */
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * Método para retornar o atributo codigo
	 * 
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Método para retornar o atributo funcionario
	 * 
	 * @return funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Método para setar o atributo funcionario
	 * 
	 * @param funcionario passa um funcionario para a venda
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Método para imprimir um objeto venda
	 */
	@Override
	public String toString() {
		return "Venda [data=" + data + ", cliente=" + cliente + ", funcionario=" + funcionario.getNome()
				+ ", qtd items=" + items.size() + ", formaPagamento=" + formaPagamento.getNome() + "]";
	}

}
