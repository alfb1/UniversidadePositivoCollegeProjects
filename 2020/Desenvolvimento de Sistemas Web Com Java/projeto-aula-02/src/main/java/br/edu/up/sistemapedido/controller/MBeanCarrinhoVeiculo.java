package br.edu.up.sistemapedido.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.up.sistemapedido.entity.Veiculo;

@ManagedBean(name="mbeanCarrinhoVeiculo")
@SessionScoped
public class MBeanCarrinhoVeiculo {
	
	private List<Veiculo> produtosSelecionados = new ArrayList<Veiculo>();

	public String adicionarProduto(Veiculo veiculo) {
		produtosSelecionados.add(veiculo);
		
		return "carrinhoVeiculo.jsf";
	}

	public List<Veiculo> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Veiculo> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}
	
	public void remover(Veiculo veiculo) {
		produtosSelecionados.remove(veiculo);
	}
	
	
}
