package br.edu.up.sistemapedido.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.sistemapedido.entity.Veiculo;

@ManagedBean(name = "mbeanVeiculo")
@SessionScoped()
public class MBeanVeiculo {
	// veiculo para operação de inclusao
	private Veiculo veiculo = new Veiculo();
	
	// veiculo para operação de edição
	private Veiculo veiculoEdicao;
	
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

	/**
	 * Salva o veiculo na lista de veículos
	 * @return null
	 */
	public String salvar() {
		veiculos.add(veiculo);
		veiculo = new Veiculo();
		return null;
	}
	
	/**
	 * Deleta um veiculo da lista
	 * @param veiculo para ser excluido
	 * @return null
	 */
	public String deletar(Veiculo veiculo) {
		int index = veiculos.indexOf(veiculo);
		
		if ( index >= 0)
		   veiculos.remove(index);
		
		return null;
	}
	
	public String alterar() {
		
		int index = veiculos.indexOf(veiculoEdicao);
		
		if ( index >= 0)
			veiculos.set(index, veiculoEdicao);
			
	    return "listaVeiculo.jsf"; 		
	}

	public String editarVeiculo(Veiculo veiculo) {
		this.veiculoEdicao = veiculo;
		return "editaVeiculo.jsf";
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo getVeiculoEdicao() {
		return veiculoEdicao;
	}

	public void setVeiculoEdicao(Veiculo veiculoEdicao) {
		this.veiculoEdicao = veiculoEdicao;
	}

	
}
