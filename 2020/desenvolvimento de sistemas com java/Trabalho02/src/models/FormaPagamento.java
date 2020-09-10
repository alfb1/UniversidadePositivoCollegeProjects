package models;

/**
 * Classe model para aFormaPagamento
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */

public class FormaPagamento {
	private String nome;

	public FormaPagamento() {
	}

	/**
	 * Construtor recebe o nome da forma de pagamento
	 * 
	 * @param nome nome da forma de pagamento
	 */

	public FormaPagamento(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para retornar o atributo nome
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para setar o atributo nome
	 * 
	 * @param nome noome da forma de pagamento
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para imprimir um objeto formaPagamento
	 */
	@Override
	public String toString() {
		return "FormaPagamento [nome=" + nome + "]";
	}

}
