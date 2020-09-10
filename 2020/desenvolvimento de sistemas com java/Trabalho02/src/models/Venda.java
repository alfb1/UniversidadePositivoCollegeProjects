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
	 * M�todo para retornar o atributo cliente
	 * 
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * M�todo para setar o atributo cliente
	 * 
	 * @param cliente cliente da venda
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * M�todo para retornar o atributo formaPagamento
	 * 
	 * @return formaPagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * M�todo para setar o atributo formaPagamento
	 * 
	 * @param formaPagamento formda de pagamento da venda
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	/**
	 * M�todo para retornar o atributo items
	 * 
	 * @return items
	 */
	public List<ItemVenda> getItems() {
		return items;
	}

	/**
	 * M�todo para setar o atributo items
	 * 
	 * @param items lista de ItemVenda
	 */
	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}

	/**
	 * M�todo para adicionar um item de venda
	 * 
	 * @param item item da venda
	 */
	public void addItem(ItemVenda item) {
		this.items.add(item);
	}

	/**
	 * M�todo para retornar o atributo data
	 * 
	 * @return data
	 */
	public LocalDateTime getData() {
		return data;
	}

	/**
	 * M�todo para setar o atributo data
	 * 
	 * @param data data da venda
	 */
	public void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * M�todo para retornar o atributo codigo
	 * 
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * M�todo para retornar o atributo funcionario
	 * 
	 * @return funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * M�todo para setar o atributo funcionario
	 * 
	 * @param funcionario passa um funcionario para a venda
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * M�todo para imprimir um objeto venda
	 */
	@Override
	public String toString() {
		return "Venda [data=" + data + ", cliente=" + cliente + ", funcionario=" + funcionario.getNome()
				+ ", qtd items=" + items.size() + ", formaPagamento=" + formaPagamento.getNome() + "]";
	}

}
