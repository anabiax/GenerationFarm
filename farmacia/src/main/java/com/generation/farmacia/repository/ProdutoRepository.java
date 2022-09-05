package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// composta somente por métodos abstratos
	
	public List<Produto> findAllByProdutoContainingIgnoreCase (String produto);

	
}
