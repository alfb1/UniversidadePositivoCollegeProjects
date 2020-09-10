package repositories;

import java.util.ArrayList;

import models.FormaPagamento;
import models.Funcionario;
import models.Venda;

/**
 * Classe responsável por guardar em memória uma lista de todos as vendas
 * cadastrados; Gera uma lista das vendas simples e também pela forma de
 * pagamento
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class Vendas implements IRepository<Venda> {

	ArrayList<Venda> vendas;

	/**
	 * Construtor instancia uma lista de objetos Venda
	 */
	public Vendas() {
		vendas = new ArrayList<>();
	}

	/**
	 * Cadastra uma venda
	 * 
	 * @param venda item a ser cadastrado
	 */
	@Override
	public void cadastrar(Venda venda) {
		this.vendas.add(venda);
	}

	/**
	 * Listagem completa das vendas
	 * 
	 * @return listagem das vendas
	 */
	@Override
	public ArrayList<Venda> listar() {
		return vendas;
	}

	/**
	 * Listagem das vendas pela forma de pagamento
	 * 
	 * @param formaPagamento tipo de forma de pagamento da listagem
	 * @return lista filtrada pela forma de pagamento
	 */
	public ArrayList<Venda> listar(FormaPagamento formaPagamento) {
		ArrayList<Venda> vendasFormaPgto = new ArrayList<Venda>();
		vendas.forEach(venda -> {
			if (formaPagamento.getNome().equals(venda.getFormaPagamento().getNome())) {
				vendasFormaPgto.add(venda);
			}
		});

		return vendasFormaPgto;
	}

	/**
	 * Listagem das vendas do funcionário
	 * 
	 * @param funcionario funcionario das vendas
	 * @return lista filtrada pelo funcionario
	 */
	public ArrayList<Venda> listar(Funcionario funcionario) {
		ArrayList<Venda> vendasFuncionario = new ArrayList<Venda>();

		vendas.forEach(venda -> {
			if (venda.getFuncionario().getCpf().equals(funcionario.getCpf())) {
				vendasFuncionario.add(venda);
			}
		});

		return vendasFuncionario;
	}

	/**
	 * Verifica se a lista está vazia
	 * 
	 * @return false se estiver vazia, true caso contrario
	 */
	public boolean haVendas() {
		return (vendas.size() > 0);
	}

	/**
	 * Altera uma venda
	 * 
	 * @param venda venda a ser alterada
	 */
	@Override
	public void alterar(Venda venda) {
	}

	/**
	 * Remove uma venda
	 * 
	 * @param venda venda ser removida
	 */
	@Override
	public void remover(Venda venda) {
		vendas.remove(venda);
	}

	/**
	 * Retorna um item venda
	 * 
	 * @param index índice da venda
	 */
	@Override
	public Venda get(Integer index) {
		return vendas.get(index);
	}

}
