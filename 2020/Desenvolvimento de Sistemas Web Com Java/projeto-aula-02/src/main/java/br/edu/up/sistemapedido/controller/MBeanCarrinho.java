package br.edu.up.sistemapedido.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.sistemapedido.entity.Produto;

@ManagedBean(name="mbeanCarrinho")
@SessionScoped
public class MBeanCarrinho {
	
	private List<Produto> produtosSelecionados = new ArrayList<Produto>();

	public String adicionarProduto(Produto produto) {
		produto.setQuantidade(1);
		produtosSelecionados.add(produto);
		
		return "carrinho.jsf";
	}

	public List<Produto> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}
	
	public void removerProduto(Produto produto) {
		produtosSelecionados.remove(produto);
	}
	
	public void sumQuantidade(Produto produto) {
	  produto.setQuantidade( produto.getQuantidade() + 1);	
	}
	
	public void decQuantidade(Produto produto) {
	   
		if (produto.getQuantidade() > 1)
		  produto.setQuantidade( produto.getQuantidade() - 1);			
	}
	
	
}
