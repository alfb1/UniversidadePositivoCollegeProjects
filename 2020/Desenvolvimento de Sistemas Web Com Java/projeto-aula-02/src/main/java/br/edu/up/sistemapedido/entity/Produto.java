package br.edu.up.sistemapedido.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="produto")
public class Produto {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column (name="id")
	private Integer id;
    
    @Column (name="nome")
	private String nome;
    
    @Column (name="descricao")
    private String descricao;
    
    @Column (name="quantidade")
    private Integer quantidade;
    
    @Column (name="preco")
    private float preco;
    
    @Column (name="fabricante")
    private String fabricante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
		

}
