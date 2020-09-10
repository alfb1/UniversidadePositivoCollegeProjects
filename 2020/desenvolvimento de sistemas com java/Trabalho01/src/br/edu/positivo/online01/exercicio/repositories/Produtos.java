package br.edu.positivo.online01.exercicio.repositories;

import java.util.ArrayList;
import java.util.List;
import br.edu.positivo.online01.exercicio.models.Produto;

/**
 * Classe Produtos 
 *  Responsável por guardar em memória  uma lista de todos os produtos cadastrados; 
 *  Gera uma lista dos produtos armazenados.
 *  
 *  @author Andre Brito
 *  @author Franccescoly Emmanuel Camargo
 */
public class Produtos {
   List<Produto> produtos = new ArrayList<>();
   
   public void cadastrar() {
	   String nome;
	   Double qtd;
	   Double preco;
	   
	   
	   nome  = Console.lerTexto("Nome :");
	   qtd   = Console.lerDecimal("Qtd em estoque :");
	   preco = Console.lerDecimal("Preco de venda :");
	   Produto produto = new Produto(nome);
	   produto.setQuantidadeEmEstoque(qtd);
	   produto.setPreco(preco);
	   
	   if ( ! temProdutoCadastrado(produto)) 
		   this.produtos.add(produto);
   }
   
   public boolean temProdutoCadastrado(Produto p) {
		if ( produtos.size() > 0 )
			for (Produto item : produtos) {
				if (item.getNome().contentEquals( p.getNome() )) {
					return true;
				}
			}
		return false;	   
   }
   
	public void listar() {
		if (produtos.size() > 0) {
			System.out.printf("%s%10s%22s%23s\n", "Codigo", "Nome", "Estoque", "Preço de venda");
			//Codigo      Nome   Estoque      Preço de venda
			for (Produto item : produtos) {
				System.out.printf("%5d       %-15s      %5.2f      %15.2f\n", produtos.indexOf(item), item.getNome(), item.getQuantidadeEmEstoque(), item.getPreco());
			}
		}
		
	}
	

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
	public Produto get(int index) 
	{
		if ( index < produtos.size())
		  return produtos.get(index);
		else return null;
	}
   
}
