package br.edu.up.sistemapedido.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemapedido.entity.Cliente;

public class ClienteDao {

	private EntityManager em;
	
	public void salvar(Cliente cliente) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}
	
	public void alterar(Cliente cliente) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();		
	}
	
	public void excluir(Cliente cliente) {
		
		em = Conexao.getInstance().createEntityManager();

		Cliente cli = em.find(Cliente.class, cliente.getId());
		
		
		em.getTransaction().begin();
		em.remove(cli);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar(){

		em = Conexao.getInstance().createEntityManager();
		
		Query q = em.createQuery("select c from Cliente c");
		return q.getResultList();
	}
	
	public Cliente buscarPorId(Integer id) {
		return null;
	}
	

}
