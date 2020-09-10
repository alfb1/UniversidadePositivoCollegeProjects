package controllers;

import java.util.List;

import models.Comissao;
import models.FormaPagamento;
import models.Funcionario;
import models.ItemVenda;
import models.Venda;
import repositories.Vendas;

/**
 * Classe controladora para a venda, reponsável por fazer a conexão entre a
 * classe VendaView e Vendas ( repositório )
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 */
public class VendaController {
	Vendas vendas;

	/**
	 * Constructor instancia um objeto vendas do repositório Vendas
	 * 
	 */
	public VendaController() {
		vendas = new Vendas();
	}

	/**
	 * Metodo para cadastrar um objeto Venda
	 * 
	 * @param venda do tipo Venda
	 */
	public void cadastrar(Venda venda) {
		vendas.cadastrar(venda);
	}

	/**
	 * Metodo para listagem de vendas
	 * 
	 * @return lista de vendas
	 */
	public List<Venda> listar() {
		return vendas.listar();
	}

	/**
	 * Metodo para listagem de vendas pela forma de pagamento
	 *
	 * @param formaPagamento filtro forma de pagamento
	 * @return lista de vendas filtrada pela forma de pagamento
	 */
	public List<Venda> listar(FormaPagamento formaPagamento) {
		return vendas.listar(formaPagamento);
	}

	/**
	 * Metodo para listagem de vendas pelo funcionario
	 * 
	 * @param funcionario filtro funcionario
	 * @return lista de vendas filtrada pelo funcionario
	 */
	public List<Venda> listar(Funcionario funcionario) {
		return vendas.listar(funcionario);
	}

	/**
	 * Metodo para aplicar o valor da comissão do funcionario
	 * 
	 * @param valor o valor para o cálculo
	 * @return resultado do cálculo
	 */
	public double calcularComissao(double valor) {
		return Comissao.FUNIONARIO * valor;
	}

	/**
	 * Metodo para calcular o total de vendas de um funcionário
	 * 
	 * @param funcionario funcionario do calculo
	 * @return soma de todas as vendas
	 */
	public double calcularVendas(Funcionario funcionario) {
		double total = 0.0;

		List<Venda> vendas = listar(funcionario);

		for (Venda venda : vendas) {
			total += somarItems(venda.getItems());
		}

		return total;
	}

	/**
	 * Metodo para somar os itens de uma venda
	 * 
	 * @param items lista de ItemVenda
	 * @return soma de todos os itens
	 */

	private double somarItems(List<ItemVenda> items) {
		double total = 0.0;

		for (ItemVenda item : items) {
			total += item.getTotal();
		}

		return total;
	}

}
