package br.edu.up.sistemapedido.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemapedido.entity.Veiculo;

public class VeiculoDao {

	private EntityManager em;
	
	public void salvar(Veiculo veiculo) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
	}
	
	public void alterar(Veiculo veiculo) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.merge(veiculo);
		em.getTransaction().commit();		
	}
	
	public void excluir(Veiculo veiculo) {
		
		em = Conexao.getInstance().createEntityManager();

		Veiculo veic = em.find(Veiculo.class, veiculo.getPlaca());
		
		
		em.getTransaction().begin();
		em.remove(veic);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listar(){

		em = Conexao.getInstance().createEntityManager();
		
		Query q = em.createQuery("select v from Veiculo v");
		return q.getResultList();
	}
	
	public Veiculo buscarPorId(Integer id) {
		return null;
	}
	

}
