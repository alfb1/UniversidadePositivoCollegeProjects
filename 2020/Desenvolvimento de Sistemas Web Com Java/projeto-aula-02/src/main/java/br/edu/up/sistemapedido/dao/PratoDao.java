package br.edu.up.sistemapedido.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemapedido.entity.Prato;
import br.edu.up.sistemapedido.entity.Restaurante;

public class PratoDao {

	private EntityManager em;
	
	public void salvar(Prato prato) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(prato);
		em.getTransaction().commit();
	}
	
	public void alterar(Prato prato) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.merge(prato);
		em.getTransaction().commit();		
	}
	
	public void excluir(Prato prato) {
		
		em = Conexao.getInstance().createEntityManager();

		Prato p = em.find(Prato.class, prato.getId());
		
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Prato> listar(Restaurante restaurante){

		em = Conexao.getInstance().createEntityManager();
		
		Query q = em.createQuery("select p from Prato p where restaurante = " + restaurante.getId());
		return q.getResultList();
	}
	
	public Prato buscarPorId(Integer id) {
		return null;
	}
	

}
