package br.edu.up.sistemapedido.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.up.sistemapedido.dao.VeiculoDao;
import br.edu.up.sistemapedido.entity.Veiculo;

@ManagedBean(name = "mbeanVeiculo")
public class MBeanVeiculo {

	// veiculo para operação de inclusao
	private Veiculo veiculo = new Veiculo();
	private VeiculoDao veiculoDao = new VeiculoDao();
	private List<Veiculo> veiculos;

	@PostConstruct
	public void listar() {
		veiculos = veiculoDao.listar();
	}

	/**
	 * Salva o veiculo na lista de veículos
	 * 
	 * @return null
	 */
	public String salvar() {
		
		if ( veiculo.getPlaca() == null) {
			veiculoDao.salvar(veiculo);		
		}else {
			veiculoDao.alterar(veiculo);
		}
		veiculo = new Veiculo();
		this.veiculos = null;
		return "listaVeiculo.jsf";
	}

	/**
	 * Deleta um veiculo da lista
	 * 
	 * @param veiculo para ser excluido
	 * @return null
	 */
	public String deletar(Veiculo veiculo) {
		veiculoDao.excluir(veiculo);
		veiculos=null;
		return "listaVeiculo.jsf";
	}

	public String carregar(Veiculo veiculo) {
		this.veiculo  = veiculo;
		return "cadastroVeiculo.jsf";
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		if ( veiculos == null)
			listar();
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
