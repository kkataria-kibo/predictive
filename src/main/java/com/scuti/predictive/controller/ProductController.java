package com.scuti.predictive.controller;

import com.scuti.predictive.model.Product;
import com.scuti.predictive.repository.ProductRepository;
import com.scuti.predictive.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductSearchRepository productSearchRepository;
	
	@RequestMapping("/product")
	public String home(Model model) {
		model.addAttribute("productList", productRepository.findAll());
		return "product";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {
		product.setBrand("bobeau");
		productRepository.save(product);
		return "redirect:product";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("productList", productSearchRepository.searchProduct(search));
		model.addAttribute("search", search);
		return "product";
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") String id, Model model) {

		productRepository.delete(id);
		model.addAttribute("productList", productRepository.findAll());

		return "product";
	}


}
