package com.springbootproject.products.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Variants {
	 
	public int id;
	public String productId;
	public String title;
	public double price;
	public String quantity;
	
	
	
}

