package com.br.zup.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.produtos.modells.ProdutoModel;
import com.br.zup.produtos.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
    
	public void salvarProduto (ProdutoModel produto) {
		produtoRepository.save(produto);
	}
	public Iterable<ProdutoModel> exiberProduto (){
		return produtoRepository.findAll();
	}
}	

