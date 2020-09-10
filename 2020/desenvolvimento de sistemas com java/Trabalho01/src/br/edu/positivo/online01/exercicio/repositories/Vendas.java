package br.edu.positivo.online01.exercicio.repositories;

import java.util.ArrayList;
import java.util.List;

import br.edu.positivo.online01.exercicio.models.FormaPagamento;
import br.edu.positivo.online01.exercicio.models.Venda;
import br.edu.positivo.online01.exercicio.view.VendasView;


/**
 * Classe Vendas 
 *  Responsável por guardar em memória  uma lista de todos as vendas cadastrados; 
 *  Gera uma lista das vendas simples e também pela forma de pagamento
 *  
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */
public class Vendas {

	List<Venda> vendas = new ArrayList<>();

	public void cadastrar(Venda venda) {
		this.vendas.add(venda);
	}

	public void listar() {
		System.out.println(":: Relatório de Vendas - Todos ::");
		if (haVendas()) {
			for (Venda item : vendas) {
				VendasView.listarVenda(item, vendas.indexOf(item));
			}
		}
	}

	public void listar(FormaPagamento fp) {
		System.out.println(":: Relatório de Vendas - Forma de Pagamento ::");
		if (haVendas()) {
			boolean haVendasFormaPgto = false;
			for (Venda item : vendas) {
				// se for da forma de pagamento escolhida
				if (fp.getNome().equals(item.getFormaPagamento().getNome())) {
					VendasView.listarVenda(item, vendas.indexOf(item));
					// seta a flag de venda para a forma selecionada
					haVendasFormaPgto = true;
				}
			}

			if (!haVendasFormaPgto) {
				System.out.println("Não há vendas cadastradas no momento para a forma de pagamento : [" + fp.getNome()
						+ "] no momento...");
			}
		}
	}

	public boolean haVendas() {
		boolean resp = (vendas.size() > 0);

		if (!resp) {
			System.out.println("Não há vendas cadastradas no momento...");
		}
		return resp;
	}




}
