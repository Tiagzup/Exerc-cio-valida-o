package com.br.zup.produtos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.produtos.modells.ProdutoModel;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer> {

}
