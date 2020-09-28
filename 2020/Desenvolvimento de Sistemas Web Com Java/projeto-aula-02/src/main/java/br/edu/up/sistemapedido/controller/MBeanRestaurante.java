package br.edu.up.sistemapedido.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.sistemapedido.dao.PratoDao;
import br.edu.up.sistemapedido.dao.RestauranteDao;
import br.edu.up.sistemapedido.entity.Prato;
import br.edu.up.sistemapedido.entity.Restaurante;

@ManagedBean( name="mbeanRestaurante")
@SessionScoped
public class MBeanRestaurante 
{
	private Restaurante restaurante = new Restaurante();
	private Prato prato = new Prato();
	
	private RestauranteDao restauranteDao = new RestauranteDao();
	private PratoDao pratoDao = new PratoDao();
	
	private List<Restaurante> restaurantes;
	private List<Prato> pratos = new ArrayList<Prato>();
	
	@PostConstruct
	public void listar() {
		restaurantes = restauranteDao.listar();
	}
	/**
	 * Adiciona o restaurante do bean para a lista de restaurantes
	 * @return null
	 */
	public String salvarRestaurante() {  	
		
		if ( restaurante.getId() == null) {
			restauranteDao.salvar(restaurante);
			
			for (Prato prato : pratos) {
				prato.setRestaurante(restaurante);
				pratoDao.salvar(prato);
			}
			
			pratos.clear();
			
		}else {
			restauranteDao.alterar(restaurante);
		}
		
		restaurante = new Restaurante();
	  	restaurantes = null;
	  	return "listaRestaurante.jsf";
	}
	
	public String editarRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante ;
		this.pratos      = restaurante.getPratos();
		return "cadastroRestaurante.jsf";
	}
		
	
	/**
	 * Deleta um restaurante da lista de restaurantes
	 * @param restaurante
	 * @return null
	 */
	public String deletarRestaurante(Restaurante restaurante) {
	    restauranteDao.excluir(restaurante);
	    restaurantes = null;
		return null;
	}
		
	/**
	 * Adiciona um prato ao restaurante
	 * @return null
	 */
	public String salvarPrato() {	
		
		System.out.println("prato " + prato.getDescricao());
		
		if ( restaurante.getId() != null) {
			prato.setRestaurante(restaurante);
			pratoDao.salvar(prato);
		}
		
		pratos.add(prato);
		prato = new Prato();

		return null;
	}
	
	
	/**
	 * Deleta um prato do restaurante
	 * @param prato o prato a ser excluido
	 * @return null
	 */
	public String deletarPrato(Prato prato) {
		
		if ( prato.getRestaurante() != null) {
			pratoDao.excluir(prato);
		}
		
		pratos.remove(prato);
		
		return null;
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

	public List<Restaurante> getRestaurantes() {
		if ( restaurantes == null)
			listar();
		return restaurantes;
	}

	public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	
	
	
}
