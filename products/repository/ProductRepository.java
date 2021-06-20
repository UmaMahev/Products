package com.springbootproject.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.products.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer>   {
	
}
