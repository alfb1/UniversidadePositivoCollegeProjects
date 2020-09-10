package controllers;

import java.util.List;

import models.FormaPagamento;
import repositories.FormasPagamento;

/**
 * Classe controladora para a forma de pagamento, reponsável por fazer a conexão
 * entre a classe FormaPagamentoView e formasPagamento ( repositório )
 * 
 * @author André Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class FormaPagamentoController {
	FormasPagamento formasPagamento;

	/**
	 * Constructor instancia as formasPagamento, seta as formas de pagamento
	 * solicitadas no exercício
	 * 
	 */
	public FormaPagamentoController() {
		formasPagamento = new FormasPagamento();
		pagamentosDefault();
	}

	/**
	 * Método responsável por cadastrar as formas de pagamento default : dinheiro,
	 * cartão, cheque
	 */
	public void pagamentosDefault() {
		FormaPagamento dinheiro = new FormaPagamento("Dinheiro");
		FormaPagamento cartao = new FormaPagamento("Cheque");
		FormaPagamento cheque = new FormaPagamento("Cartao");

		cadastrar(dinheiro);
		cadastrar(cartao);
		cadastrar(cheque);
	}

	/**
	 * Método que retorna uma lista do tipo FormaPagamento
	 * 
	 * @return lista de formaPagamento
	 */
	public List<FormaPagamento> listar() {
		return formasPagamento.listar();
	}

	/**
	 * Metodo para cadastro de FormaPagamento
	 * 
	 * @param formaPagamento do tipo FormaPagamento
	 * @return boolean true em caso de sucesso no cadastro
	 */
	public boolean cadastrar(FormaPagamento formaPagamento) {
		if (!temFormaPagamentoCadastrado(formaPagamento)) {
			formasPagamento.cadastrar(formaPagamento);
			return true;
		}
		return false;
	}

	/**
	 * Metodo para checar se existe uma forma de pagamento já cadastrada
	 * 
	 * @param formaPagamento do tipo FormaPagamento
	 * @return boolean true se houver item cadastrado
	 */
	public boolean temFormaPagamentoCadastrado(FormaPagamento formaPagamento) {

		if (formasPagamento.listar().size() > 0)
			for (FormaPagamento item : formasPagamento.listar()) {
				if (item.getNome().equals(formaPagamento.getNome())) {
					return true;
				}
			}
		return false;
	}

	/**
	 * Método que retorna uma FormaPagamento pelo índice da lista
	 * 
	 * @param index indice da lista
	 * @return FormaPagamento
	 */
	public FormaPagamento get(Integer index) {
		if ( index >= 0 && index < formasPagamento.listar().size())
		  return formasPagamento.get(index);
		else 
		  return null;
	}

}
