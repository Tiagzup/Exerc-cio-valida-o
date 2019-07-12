package com.br.zup.produtos.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zup.produtos.modells.ProdutoModel;
import com.br.zup.produtos.services.ProdutoService;


@Controller
public class ProdutoControler {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping ("/")
	public ModelAndView exibirProduto () {
		ModelAndView modelAndView = new ModelAndView("produto.html");
		modelAndView.addObject("produtos", produtoService.exiberProduto());
		return modelAndView;
		
	}
	@PostMapping ("/")
	public ModelAndView  salvarProduto(@Valid ProdutoModel produtoModel, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("produto.html");
		
		if (bindingResult.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("produtos", produtoService.exiberProduto());
			modelAndView.addObject("Erros", erros);
			return modelAndView;
			
		}else {
			produtoService.salvarProduto(produtoModel);
			modelAndView.addObject("produtos", produtoService.exiberProduto());
			return modelAndView;
		}
	}

}
