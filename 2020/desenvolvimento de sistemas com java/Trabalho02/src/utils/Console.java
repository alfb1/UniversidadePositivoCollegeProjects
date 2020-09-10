package utils;

import java.util.Scanner;

/**
 * Classe específica para realizar operações de entrada e saída de teclado.
 */
public class Console {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Método para montar menu para seleção de opções
	 * 
	 * @param opcoes    array de string com as opções do menu
	 * @param titulo    titulo do menu
	 * @param opcaoSair selecao do usuario para saida do menu
	 * @return int
	 */
	public static int mostrarMenu(String[] opcoes, String titulo, Boolean opcaoSair) {
		final String MENSAGEM = "Por favor, escolha uma opção:";
		int opcaoEscolhida = 0;
		if (titulo == null) {
			System.out.println(MENSAGEM);
		} else {
			System.out.println(titulo);
		}

		for (int i = 0; i < opcoes.length; i++) {
			System.out.println(i + 1 + ") " + opcoes[i]);
		}
		int opcaoFinal = opcoes.length;
		if (opcaoSair == true) {
			System.out.println(opcoes.length + 1 + ") Para sair.");
			opcaoFinal = opcoes.length + 1;
		}
		try {
			opcaoEscolhida = lerInteiroPositivo(MENSAGEM);
			if (opcaoEscolhida == opcaoFinal) {
				return -1;
			}
		} catch (Exception e) {
			opcaoEscolhida = mostrarMenu(opcoes, "Você selecionou um opção inválida, por favor tente novamente.",
					opcaoSair);
		}
		return opcaoEscolhida;
	}

	/**
	 * Método específico para realizar a captura de dados decimais no console.
	 * 
	 * @param descricao textual do valor a ser informado pelo usuário.
	 * @return valor decimal informado pelo usuário.
	 */
	public static Double lerDecimal(String descricao) {
		Double valor;
		try {
			valor = Double.parseDouble(lerTexto(descricao));
		} catch (Exception e) {
			valor = lerDecimal(descricao);
		}
		return valor;
	}

	/**
	 * Método específico para realizar a captura de dados inteiros no console.
	 * 
	 * @param descricao textual do valor a ser informado pelo usuário.
	 * @return valor inteiro informado pelo usuário.
	 */
	public static Integer lerInteiro(String descricao) {
		Integer valor;
		try {
			valor = Integer.parseInt(lerTexto(descricao));
		} catch (Exception e) {
			valor = lerInteiro(descricao);
		}
		return valor;
	}

	/**
	 * 
	 * Método específico para realizar a captura de dados inteiros positivos no
	 * console.
	 * 
	 * @param descricao textual do valor a ser informado pelo usuário.
	 * @return valor inteiro positivo informado pelo usuário.
	 */
	public static Integer lerInteiroPositivo(String descricao) {
		Integer valor = null;
		do {
			valor = lerInteiro(descricao);
			if (valor < 0) {
				System.out.println("Digite um valor positivo.");
			}
		} while (valor < 0);
		return valor;
	}

	/**
	 * Método específico para realizar a captura de dados texto no console.
	 * 
	 * @param descricao textual do valor a ser informado pelo usuário.
	 * @return um texto informado pelo usuário.
	 */
	public static String lerTexto(String descricao) {
		String valor;
		if (descricao == null) {
			System.out.println("Entre com valor:");
		} else {
			System.out.println(descricao);
		}
		try {
			valor = scanner.nextLine();
		} catch (Exception e) {
			valor = lerTexto(descricao);
		}
		return valor;
	}

}
