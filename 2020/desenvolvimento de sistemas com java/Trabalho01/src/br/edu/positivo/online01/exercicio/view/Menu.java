package br.edu.positivo.online01.exercicio.view;

import java.util.ArrayList;
import java.util.List;

import br.edu.positivo.online01.exercicio.repositories.Console;

/**
 * Classe Menu 
 *  Responsável montar os menus principal e de vendas e as interações com o usuario
 *
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */

public class Menu {
	// opções do menu principal
	public static String[] menuPrincipal = { "Clientes", "Listar Clientes", "Produtos", "Listar Produtos",
			"Forma de Pagamento", "Listar Forma de Pagamento", "Vendas", "Finalizar" };
	// opçõa do submenu vendas
	public static String[] menuVendas = { "Cadastro", "Listar", "Listar por forma de pagamento", "Voltar" };

	// lista para mensagens ao usuario
	static List<String> msgs = new ArrayList<String>();

	// limpa a lista de mensagem
	public static void clearMsgs() {
		msgs.clear();
	}

	// adicionar uma mensagem
	public static void addMsg(String msg) {
		msgs.add(msg);
	}

	// teste para saber se há msgs
	public static boolean temMsg() {
		return msgs.size() > 0;
	}

	// exibe uma mensagem customizada junto com a lista de
	// msgs armazenadas;
	public static void showErrorMgs(String aviso) {
		if (temMsg()) {
			showText(aviso);
			showMgs(msgs);
		}
	}

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

	public static void showMgs(List<String> items) {
		if (items.size() > 0) {
			showTraco();
			for (String item : items) {
				System.out.println(item);
			}
			showTraco();
		}
		String opcao = Console.lerTexto("Pressione alguma tecla...");
	}

	public static void showTraco() {
		System.out.println("-".repeat(30));
	}

	public static boolean continuar() {
		String continuar = Console.lerTexto("Continuar o cadastro ? (s/n) ");
		return continuar.toUpperCase().equals("S");
	}

	public static void showText(Object o) {
		System.out.println(o);
	}

	public static Integer showMenuPrincipal() {
		showText("Menu Principal");
		return showMenu(menuPrincipal);
	}

	public static Integer showMenuVendas() {
		showText("Menu Vendas");
		return showMenu(menuVendas);
	}
}
