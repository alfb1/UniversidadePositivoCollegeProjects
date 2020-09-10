package views;

import java.time.format.DateTimeFormatter;
import java.util.List;

import models.ItemVenda;
import models.Venda;

/**
 * Classe VendasView Responsável pela formatação dos cabecalhos de vendas
 *
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */

public class VendaUtilView {

	/**
	 * Metodo para exibir header da venda
	 * 
	 * @param item  objeto do tipo venda
	 * @param index inteiro correspondente ao índice da venda nas lista de vendas
	 */
	public static void headerVenda(Venda item, Integer index) {
		System.out.println("Funcionario " +  item.getFuncionario().getNome());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
		String data = item.getData().format(format);
		System.out.printf("%s%15s%22s%17s%20s\n", "Codigo", "Data", "Forma Pagamento", "Cliente", "Funcionario");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.printf("%5d  %20s %-22s   %-15s %-15s\n", 
				          index, 
				          data, 
				          item.getFormaPagamento().getNome(), 
				          item.getCliente().getNome(), 
				          item.getFuncionario().getNome());
	}

	/**
	 * Metodo para exibir header dos itens da venda
	 * 
	 */

	public static void headerItem() {
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.printf("%30s\n", "ITENS");
		System.out.printf("%s%20s%20s%18s%20s\n", "Seq", "Produto", "Quantidade", "Preço", "Total");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
	}

	/**
	 * Metodo para exibir header do item da venda
	 * 
	 * @param item  objeto ItemVenda
	 * @param index inteiro correspondente ao índice da venda nas lista de itens
	 */
	public static void bodyItem(ItemVenda item, Integer index) {
		System.out.printf("%5d%5s%-20s%10.2f%20.2f%20.2f\n", index, " ", item.getProduto().getNome(),
				item.getQuantidade(), item.getPreco(), item.getTotal());
	}

	/**
	 * Metodo para exibir o footer da venda com o total
	 * 
	 * @param total soma dos itens da venda
	 */

	public static void footer(Double total) {
		System.out.println(
				"----------------------------------------------------------------------------------------------");
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
			headerItem();

			for (ItemVenda item : items) {
				// soma o item
				total += item.getTotal();
				// exibe na tela
				bodyItem(item, items.indexOf(item) + 1);
			}

			footer(total);
		}

	}
}
