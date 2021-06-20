package com.springbootproject.products.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
	@Id
	@GeneratedValue
	public int id;
	public String title;
	public String bodyHtml;
	public String vendor;
	public String product_type;
	public  LocalDateTime	 createdAt;
	public List<Variants> variants;
	
	
	//////////  LOMBOK ERROR ////////////////////
	public List<Product> getVariants() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

