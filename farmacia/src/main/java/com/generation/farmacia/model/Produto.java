package com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity // tabela dentro do meu banco de dados
@Table(name = "tb_produtos")
public class Produto {

	//CONSTRUÇÃO DO OBJETO

	@Id   //atributo anotado será a Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // indica que a Chave Primária será gerada pelo Spring Data JPA
	private Long id;
	
	@NotBlank (message = "O atributo produto é obrigatório.")
	@Size(min= 5, max= 100)
	private String produto;
	
	@NotNull // não permite um valor nulo
	private double preco; 
	
	// ESTABELECENDO RELACIONAMENTO
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;


	
	// GET e SET PARA MANIPULAR OS DADOS DA TABELA

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
