package com.springbootproject.products.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.springbootproject.products.entity.Product;
import com.springbootproject.products.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	/**
	 * Retrieving all the products for the initail page
	 * @return all the products in product table
	 */
	public List<Product> getProducts() {
		return repository.findAll();
	}

	 /**
     * Filtering trigger from frontend based on color 
     * EX: options of color - pink,blue,yellow (multiple check box)
     * @return filtered products
     */
	public List<Product> filteredColorProducts(List<String> filterColorParam) {
		List<Product> filteredProduct=new ArrayList<Product>();
		if(!CollectionUtils.isEmpty(filterColorParam)) {		
		filterColorParam.forEach(colors->{
			getProducts().forEach(products->{
				filteredProduct.addAll(products.getVariants().stream().filter(variant->variant.getTitle().equals(colors)).collect(Collectors.toList()));
			});
		});}
		return filteredProduct;
		
	}
	
	 /**
     * Filtering trigger from frontend based on price and quantity
     * EX: options of price will be in ranges - below 500, below 1000
     * EX: options of quantity : 10, 20
     * @return filtered products
     */

	public List<Product> filteredProducts( Map<String, List<Long>> filterParam) {
		List<Product> filteredProduct=new ArrayList<Product>();	
		if(filterParam.containsKey("price")&& !filterParam.isEmpty()) {
	filterParam.get("price").forEach(price->
	{getProducts().forEach(products->{
		filteredProduct.addAll(products.getVariants().stream().filter(variant->variant.getPrice()<(price)).collect(Collectors.toList()));
	});
	}); }
		else {
	filterParam.get("quantity").forEach(quantity->
	{getProducts().forEach(products->{
		filteredProduct.addAll(products.getVariants().stream().filter(variant->variant.getQuantity()==(quantity)).collect(Collectors.toList()));
	});
	});}
	
		return filteredProduct;
	}

	
	
	
}


