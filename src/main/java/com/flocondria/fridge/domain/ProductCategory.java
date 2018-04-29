package com.flocondria.fridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * JPA Entity for a Product category.
 * <p>
 * Created by Lætitia.
 */
@Entity
@Table
public class ProductCategory {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Product product) {
		this.products.add(product);
	}
	
	public ProductCategory(String name) {
		this.name = name;
	}
	
	public ProductCategory() {
	}
	
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	
}
