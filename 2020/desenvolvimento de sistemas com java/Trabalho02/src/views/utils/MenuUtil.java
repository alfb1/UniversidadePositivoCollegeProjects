package views.utils;

import java.util.ArrayList;
import java.util.List;

import utils.Console;

/**
 * Classe MenuUtil Respons�vel montar os menus principal e de vendas e as
 * intera��es com o usuario
 *
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */

public class MenuUtil {
	// op��es do menu principal
	public static String[] menuPrincipal = { "Clientes", "Listar Clientes", "Funcion�rios", "Listar funcion�rios",
			"Produtos", "Vendas", "Listar Vendas", "Finalizar" };
	// op��a do submenu vendas
	public static String[] menuVendas = { "Cadastro", "Listar", "Listar por forma de pagamento", "Voltar" };

	// lista para mensagens ao usuario
	static List<String> msgs = new ArrayList<String>();

	/**
	 * Limpa a lista de mensagem
	 * 
	 */
	public static void clearMsgs() {
		msgs.clear();
	}

	/**
	 * Adiciona uma mensagem a lista de mensagem
	 * 
	 * @param msg texto da mensagem
	 */
	public static void addMsg(String msg) {
		msgs.add(msg);
	}

	/**
	 * Teste para saber se h� mensagens
	 * 
	 * @return true se houver alguma mensagem cadastrada
	 */
	public static boolean temMsg() {
		return msgs.size() > 0;
	}

	/**
	 * exibe uma mensagem customizada e as mensagens da lista de mensagens
	 * 
	 * @param aviso t�tulo do aviso
	 */
	public static void showErrorMgs(String aviso) {
		if (temMsg()) {
			showText(aviso);
			showMgs(msgs);
		}
	}

	/**
	 * exibe os itens de um array de string e aguarda a entrada do usu�rio para
	 * sele��o de um item do muenu
	 * 
	 * @param items � o array com as op��es
	 * @return retorna um inteiro com a op��o escolhida pelo usu�rio
	 */
	public static Integer showMenu(String[] items) {
		if (items.length > 0) {
			showTraco();
			int i = 0;
			for (String item : items) {
				System.out.println(++i + ") " + item);
			}
			showTraco();
		}
		Integer opcao = Console.lerInteiro("Selecione uma opcao.");
		return opcao;
	}

	/**
	 * exibe o conte�do de uma lista de strings entre duas linhas e aguarda o
	 * pressionamento de uma tecla pelo usu�rio
	 * 
	 * @param items lista das mensagens
	 */
	public static void showMgs(List<String> items) {
		if (items.size() > 0) {
			showTraco();
			for (String item : items) {
				System.out.println(item);
			}
			showTraco();
		}
		pressioneUmaTecla();
	}

	/**
	 * Aguarda o usu�rio pressionar qualquer tecla.
	 * 
	 */
	public static void pressioneUmaTecla() {
		Console.lerTexto("Pressione alguma tecla...");
	}

	/**
	 * Imprime na tela uma linha de tamanho fixo : 30, com o caracter '-'
	 * 
	 */
	public static void showTraco() {
		showTraco(30);
	}

	/**
	 * Imprime na tela uma linha de tamanho vari�vel, com o caracter '-'
	 * 
	 * @param quantidade quantidade de tra�os para imprimir
	 * 
	 */
	public static void showTraco(int quantidade) {
		System.out.println("-".repeat(quantidade));
	}

	/**
	 * Aguarda pelo usu�rio pressionar uma tecla
	 * 
	 * @return true se o usu�rio pressionou a tecla s, false para qualquer outra
	 */
	public static boolean continuar() {
		String continuar = Console.lerTexto("Continuar o cadastro ? (s/n) ");
		return continuar.toUpperCase().equals("S");
	}

	/**
	 * Imprime o objeto em uma linha
	 * 
	 * @param o objeto a ser impresso na tela
	 */
	public static void showText(Object o) {
		System.out.println(o);
	}

	/**
	 * Imprime o objeto em uma linha decorada com a string "::" no come�o e no fim e
	 * com tra�os acima e abaixo do mesmo tamanho do objeto
	 * 
	 * @param o objeto a ser impresso na tela
	 */
	public static void showTitle(Object o) {
		Object o2 = "::   " + o + "   ::";
		showTraco(o2.toString().length());
		showText(o2);
		showTraco(o2.toString().length());
	}

	/**
	 * Exibe o menu principal com o titulo e as op��es
	 * 
	 * @return a op��o selecionada pelo usu�rio
	 */
	public static Integer showMenuPrincipal() {
		showTitle("Menu Principal");
		return showMenu(menuPrincipal);
	}

	/**
	 * Exibe o menu de vendas com o titulo e as op��es
	 * 
	 * @return a op��o selecionada pelo usu�rio
	 */
	public static Integer showMenuVendas() {
		showText("Menu Vendas");
		return showMenu(menuVendas);
	}

	/**
	 * Exibe uma mensagem para sucesso ou falha no cadastro
	 * 
	 * @param tableName o nome da tabela
	 * @param resposta  true para sucesso e false para falha
	 */
	public static void msgCadastro(String tableName, boolean resposta) {
		if (resposta)
			showText(tableName + " salvo com sucesso.");
		else
			showText(tableName + " j� se encontra cadastrado.");
	}
}
