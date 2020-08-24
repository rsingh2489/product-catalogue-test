package com.test.product.catalogue.controller;

import com.test.product.atalogue.service.ProductCatalogueService;
import com.test.product.catalogue.entity.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CatalogueController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogueController.class);
	
	@Autowired
	ProductCatalogueService productCatalogueService;
	
	@GetMapping(value="/product/all")
	@ResponseBody
	public List<Product> getAllProduct(){
		return productCatalogueService.getAllProduct();
	}
	
	@GetMapping(value="/product")
	@ResponseBody
	public List<Product> searchProduct(@RequestParam Map<String,String> allRequstParam){
		return productCatalogueService.searchProduct(allRequstParam);
	}
	
	@PostMapping("/product")
	@ResponseBody
	public Product addProduct(@RequestBody Product product){
		return productCatalogueService.addProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	@ResponseBody
	public String deleteProduct(@PathVariable("id") long id){
		return productCatalogueService.deleteProduct(id);
	}

}
