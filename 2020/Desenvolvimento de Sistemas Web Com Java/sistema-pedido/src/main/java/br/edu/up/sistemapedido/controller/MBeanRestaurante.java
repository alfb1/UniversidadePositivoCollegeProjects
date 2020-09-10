package br.edu.up.sistemapedido.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.sistemapedido.entity.Prato;
import br.edu.up.sistemapedido.entity.Restaurante;

@ManagedBean( name="mbeanRestaurante")
@SessionScoped()
public class MBeanRestaurante 
{
	private ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	//resturante para inserção
	private Restaurante restaurante = new Restaurante();
	//restaurante para edicao
	private Restaurante restauranteEdicao = new Restaurante();
	
	private Prato prato = new Prato();
	
	/**
	 * Adiciona o restaurante do bean para a lista de restaurantes
	 * @return null
	 */
	public String salvarRestaurante() {  	
		
		restaurantes.add(restaurante);
		restaurante = new Restaurante();
	  	
	  	return null;
	}
	
	/**
	 * altera um restaurante da lista
	 * @return null
	 */
	public String alterarRestaurante() {
		int index = restaurantes.indexOf(restauranteEdicao);
		
		if ( index >= 0 ) 
			restaurantes.set(index, restauranteEdicao);	
		return "listaRestaurante.jsf";
	}
	
	
	/**
	 * Deleta um restaurante da lista de restaurantes
	 * @param restaurante
	 * @return null
	 */
	public String deletarRestaurante(Restaurante restaurante) {
		int index = restaurantes.indexOf(restaurante);
		
		if ( index >= 0 ) {	
			restaurantes.remove(index);
		}
		
		return null;
	}
		
	/**
	 * Adiciona um prato ao restaurante
	 * @return null
	 */
	public String salvarPrato() {		
		restaurante.getPratos().add(prato);
		prato = new Prato();
		return null;
	}
	
	/**
	 * Alteracao de pratos no restaurante
	 * @return null
	 */
	public String alterarPrato() {		
		restauranteEdicao.getPratos().add(prato);
		prato = new Prato();
		return null;
	}	
	/**
	 * Deleta um prato do restaurante
	 * @param prato o prato a ser excluido
	 * @return null
	 */
	public String deletarPrato(Prato prato) {
		
		int index = restaurante.getPratos().indexOf(prato);
		
		if ( index >= 0) {
			restaurante.getPratos().remove(index);
		}
		
		return null;
	}
	
	/**
	 * Deleta um prato do restaurante durante a edicao
	 * @param prato o prato a ser excluido
	 * @return null
	 */
	public String deletarPratoEdicao(Prato prato) {
		
		int index = restauranteEdicao.getPratos().indexOf(prato);
		
		if ( index >= 0) {
			restauranteEdicao.getPratos().remove(index);
		}
		
		return null;
	}

	/**
	 * Seta o restaurante do bean para edição
	 * @param restaurante a ser editado
	 * @return página de edição
	 */
	public String editarRestaurante(Restaurante restaurante) {
		
		this.restauranteEdicao = restaurante;
		return "editaRestaurante.jsf";
	}
	
	/**
	 * Seta um novo cadastro de restaurante
	 * @return
	 */
	public String novoRestaurante() {
		
		restaurante = new Restaurante();
		return "cadastroRestaurante.jsf";
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}
	
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}

	public ArrayList<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public Restaurante getRestauranteEdicao() {
		return restauranteEdicao;
	}

	public void setRestauranteEdicao(Restaurante restauranteEdicao) {
		this.restauranteEdicao = restauranteEdicao;
	}
	
	
	
}
