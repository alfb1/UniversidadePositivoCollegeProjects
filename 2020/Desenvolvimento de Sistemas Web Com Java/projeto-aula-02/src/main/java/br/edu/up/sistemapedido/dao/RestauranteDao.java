package br.edu.up.sistemapedido.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemapedido.entity.Restaurante;

public class RestauranteDao {

	private EntityManager em;
	
	public void salvar(Restaurante restaurante) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(restaurante);
		em.getTransaction().commit();
	}
	
	public void alterar(Restaurante restaurante) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.merge(restaurante);
		em.getTransaction().commit();		
	}
	
	public void excluir(Restaurante restaurante) {
		
		em = Conexao.getInstance().createEntityManager();

		Restaurante rest = em.find( Restaurante.class, restaurante.getId() );
		
		
		em.getTransaction().begin();
		em.remove(rest);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurante> listar(){

		em = Conexao.getInstance().createEntityManager();
		
		Query q = em.createQuery("select r from Restaurante r");
		return q.getResultList();
	}
	
	public Restaurante buscarPorId(Integer id) {
		return null;
	}
	

}
