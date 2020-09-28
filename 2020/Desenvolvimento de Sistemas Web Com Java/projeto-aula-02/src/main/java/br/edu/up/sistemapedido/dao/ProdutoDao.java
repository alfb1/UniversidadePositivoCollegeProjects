package br.edu.up.sistemapedido.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemapedido.entity.Produto;

public class ProdutoDao {

	private EntityManager em;
	
	public void salvar(Produto produto) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	public void alterar(Produto produto) {
		
		em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();		
	}
	
	public void excluir(Produto produto) {
		
		em = Conexao.getInstance().createEntityManager();

		Produto prod = em.find(Produto.class, produto.getId());
		
		
		em.getTransaction().begin();
		em.remove(prod);
		em.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){

		em = Conexao.getInstance().createEntityManager();
		
		Query q = em.createQuery("select p from Produto p");
		return q.getResultList();
	}
	
	public Produto buscarPorId(Integer id) {
		return null;
	}
	

}
