package models;

/**
 * Classe model para Pessoa
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class Pessoa {
	private String nome;
	private String cpf;

	public Pessoa() {
	}

	/**
	 * Construtor recebe nome e cpf de uma pessoa
	 * 
	 * @param nome da pessoa
	 * @param cpf  da pessoa
	 */
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	/**
	 * Método para retornar o atributo nome
	 * 
	 * @return nome da pessoa
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para setar o atributo nome
	 * 
	 * @param nome nome da pessoa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para retornar o atributo cpf
	 * 
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método para setar o atributo cpf
	 * 
	 * @param cpf cpf da pessoa
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Método para imprimir um objeto pessoa
	 */
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}

}
