package br.edu.positivo.online01.exercicio.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.positivo.online01.exercicio.models.ItemVenda;
import br.edu.positivo.online01.exercicio.models.Venda;


/**
 * Classe VendasView 
 *  Responsável pela formatação dos cabecalhos de vendas
 *
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */

public class VendasView {
	
	/**
	 * Metodo para exibir header da venda
	 * 
	 * @param item  objeto do tipo venda
	 * @param index inteiro correspondente ao índice da venda nas lista de vendas
	 */
	public static void headerVenda(Venda item, Integer index) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
		String data = item.getData().format(format);
		System.out.printf("%s%15s%30s%30s\n", "Codigo", "Data", "Forma Pagamento", "Cliente");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.printf("%5d%20s%5s%-25s%5s%-40s\n", index, data, " ", item.getFormaPagamento().getNome()," ",
			                                    	 item.getCliente().getNome());
	}

	/**
	 * Metodo para exibir header dos itens da venda
	 * 
	 */
	
	public static void headerItem() {
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.printf("%30s\n", "ITENS");
		System.out.printf("%s%20s%20s%18s%20s\n", "Seq", "Produto", "Quantidade", "Preço", "Total");
		System.out.println("----------------------------------------------------------------------------------------------");
	}

	/**
	 * Metodo para exibir header do item da venda
	 * 
	 * @param item objeto ItemVenda
	 * @param index inteiro correspondente ao índice da venda nas lista de itens
	 * @param total somatorio dos itens da venda
	 */
	public static void bodyItem(ItemVenda item, Integer index, Double total) {
		System.out.printf("%5d%5s%-20s%10.2f%20.2f%20.2f\n", index, " ", item.getProduto().getNome(), item.getQuantidade(),
				item.getPreco(), total);
	}

	/**
	 * Metodo para exibir o footer da venda com o total
	 * 
	 * @param total soma dos itens da venda
	 */
	
	public static void footer(Double total) {
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.printf("%80.2f\n Total : ", total);
		System.out.println("");
	}
	
	/**
	 * Metodo para listar uma venda
	 * 
	 * @param venda um objeto do tipo Venda
	 * @param index inteiro correspondente ao índice da venda nas lista de vendas
	 */
	
	public static void listarVenda(Venda venda, Integer index) {
		headerVenda(venda, index);
		listarItems(venda.getItems());	
	}
	
	/**
	 * Metodo para listar os itens da venda
	 * 
	 * @param items inteiro correspondente ao índice da venda nas lista de vendas
	 */
	
	public static void listarItems(List<ItemVenda> items) {
		if (items.size() > 0) {
			double total = 0.0;
			double totalItem = 0.0;
			headerItem();

			for (ItemVenda item : items) {
				// calcula o total
				totalItem = item.getQuantidade() * item.getPreco();
				// soma o item
				total += totalItem;
				// exibe na tela
				bodyItem(item, items.indexOf(item), totalItem);
			}

			footer(total);
		}

	}
}
