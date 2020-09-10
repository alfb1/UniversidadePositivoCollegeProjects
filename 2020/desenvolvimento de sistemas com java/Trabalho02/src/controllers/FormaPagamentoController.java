package controllers;

import java.util.List;

import models.FormaPagamento;
import repositories.FormasPagamento;

/**
 * Classe controladora para a forma de pagamento, repons�vel por fazer a conex�o
 * entre a classe FormaPagamentoView e formasPagamento ( reposit�rio )
 * 
 * @author Andr� Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class FormaPagamentoController {
	FormasPagamento formasPagamento;

	/**
	 * Constructor instancia as formasPagamento, seta as formas de pagamento
	 * solicitadas no exerc�cio
	 * 
	 */
	public FormaPagamentoController() {
		formasPagamento = new FormasPagamento();
		pagamentosDefault();
	}

	/**
	 * M�todo respons�vel por cadastrar as formas de pagamento default : dinheiro,
	 * cart�o, cheque
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
	 * M�todo que retorna uma lista do tipo FormaPagamento
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
	 * Metodo para checar se existe uma forma de pagamento j� cadastrada
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
	 * M�todo que retorna uma FormaPagamento pelo �ndice da lista
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
