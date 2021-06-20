package com.springbootproject.products.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.products.entity.Product;
import com.springbootproject.products.service.ProductService;



@RestController
public class ProductController {
	
	    @Autowired
	    private ProductService service;

	    /**
	     * Retrieving all the products for the initail page
	     * @return all the products in product table
	     */
	    @GetMapping("/products")
	    public List<Product> findAllProducts() {
	        return service.getProducts();
	    }
	    
	    /**
	     * Filtering trigger from frontend based on color 
	     * EX: options of color - pink,blue,yellow (multiple check box)
	     * @return filtered products
	     */
	    @GetMapping("/filteredcolorProducts")
	    public List<Product> filteredColorProducts(@RequestBody List<String> filterColorParam) {
	        return CollectionUtils.isEmpty(filterColorParam)? new ArrayList<>() :service.filteredColorProducts(filterColorParam);
	    }
	    
	    /**
	     * Filtering trigger from frontend based on price and quantity
	     * EX: options of price will be in ranges - below 500, below 1000
	     * EX: options of quantity : 10, 20
	     * @return filtered products
	     */
	    @GetMapping("/filteredProducts")
	    public List<Product> filteredProducts(@RequestBody Map<String, List<Long>> filterParam) {
	        return CollectionUtils.isEmpty(filterParam)? new ArrayList<>() :service.filteredProducts(filterParam);
	    }
	    
	    

}
