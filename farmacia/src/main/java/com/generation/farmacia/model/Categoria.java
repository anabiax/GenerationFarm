package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // tabela dentro do meu banco de dados
@Table(name = "tb_categoria")
public class Categoria {

	//CONSTRUÇÃO DO OBJETO
	
	@Id   //atributo anotado será a Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // indica que a Chave Primária será gerada pelo Spring Data JPA
	private Long id;
	
	@NotBlank (message = "O atributo categoria n pode retornar nulo.")
	private String categoria;
	
	@NotNull
	private String descricao;
	
	
	// ESTABELECER RELACIONAMENTO
	// toda vez que tiver um relacionamento PRECISO passar um Json
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) //
	@JsonIgnoreProperties("categoria") // barrar loop infinito
	private List<Produto> produto;
	// definição de que vários produtos serão exibidos numa lista
			// precisa ser obrigatoriamente um array


	// GET e SET PARA MANIPULAR OS DADOS DA TABELA

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

		
}
