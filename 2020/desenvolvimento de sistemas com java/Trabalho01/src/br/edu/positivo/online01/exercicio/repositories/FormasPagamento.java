package br.edu.positivo.online01.exercicio.repositories;

import java.util.ArrayList;
import java.util.List;

import br.edu.positivo.online01.exercicio.models.FormaPagamento;


/**
 * Classe FormasPagamento - Responsável por guardar em memória  uma lista de todos as formas de pagamento cadastradas; 
 * 
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */
public class FormasPagamento {
	List<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();

	public void cadastrar() {
		String nome;
		nome = Console.lerTexto("Nome :");

		FormaPagamento fpagto = new FormaPagamento(nome);

		if (!temFormaPagamentoCadastrado(fpagto)) {
			formaPagamentos.add(fpagto);
		}
	}

	public boolean temFormaPagamentoCadastrado(FormaPagamento fp) {
		if (formaPagamentos.size() > 0)
			for (FormaPagamento item : formaPagamentos) {
				if (item.getNome().contentEquals(fp.getNome())) {
					return true;
				}
			}
		return false;
	}

	public List<FormaPagamento> getClientes() {
		return formaPagamentos;
	}

	public void listar() {
		if (formaPagamentos.size() > 0) {
			System.out.printf("%s%10s\n", "Código", "Nome");
			for (FormaPagamento item : formaPagamentos) {
				System.out.printf("%10d%10s\n", formaPagamentos.indexOf(item), item.getNome());
			}
		}
	}

	public List<FormaPagamento> getFormaPagamentos() {
		return formaPagamentos;
	}

	public FormaPagamento get(int index) {
		if (index < formaPagamentos.size())
			return formaPagamentos.get(index);
		else
			return null;
	}

}
