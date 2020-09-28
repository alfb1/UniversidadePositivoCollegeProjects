package br.edu.up.sistemapedido.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.up.sistemapedido.dao.ProdutoDao;
import br.edu.up.sistemapedido.entity.Produto;

@ManagedBean(name="mbeanListaDeProdutos")
public class MBeanListaDeProdutos {

	List<Produto> produtos;
	
	@PostConstruct
	public void listar() {
	  ProdutoDao produtoDao = new ProdutoDao();
	  produtos = produtoDao.listar();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
