package models;

/**
 * Classe model para Cliente
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 */
public class Cliente extends Pessoa {
	private String email;

	/**
	 * Construtor recebe nome, cpf e email de um cliente
	 * 
	 * @param nome  nome da pessoa
	 * @param cpf   cpf da pessoa
	 * @param email email da pessoa
	 */
	public Cliente(String nome, String cpf, String email) {
		super(nome, cpf);
		this.email = email;
	}

	/**
	 * Método para retornar o atributo email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método para setar o atributo email
	 * 
	 * @param email email do cliente
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método para imprimir um objeto cliente
	 */
	@Override
	public String toString() {
		return "Cliente [ Nome =" + getNome() + ", Cpf =" + getCpf() + ", email=" + email + "]";
	}

}
