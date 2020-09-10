package models;

/**
 * Classe model para Funcionario
 * 
 * @author Andre Brito
 * @author Franccescoly Emmanuel Camargo
 * 
 */
public class Funcionario extends Pessoa {
	private double salario;

	/**
	 * Construtor recebe nome, cpf e o salario de um funcionario
	 * 
	 * @param nome    nome do funcionario
	 * @param cpf     cpf do funcionario
	 * @param salario salario do funcionario
	 */
	public Funcionario(String nome, String cpf, double salario) {
		super(nome, cpf);
		this.salario = salario;
	}

	/**
	 * Método para retornar o atributo salario
	 * 
	 * @return salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Método para setar o atributo salario
	 * 
	 * @param salario valor do salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Método para imprimir um objeto funcionario
	 */
	@Override
	public String toString() {
		return "Funcionario [ Nome" + this.getNome() + ", cpf = " + this.getCpf() + ", salario=" + salario + "]";
	}

}
