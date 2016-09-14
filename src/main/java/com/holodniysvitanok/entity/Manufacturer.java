package com.holodniysvitanok.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="manufacturer_table")
public class Manufacturer extends ImageFile{
	
	@Column(name = "name_manufacturer", unique=true, nullable=false)
	private String name;
	
	@Column(name = "description_manufacturer")
	private String description;
	
	@Column(name = "country_manufacturer")
	private String country;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	private List<Product> products = new ArrayList<>();


	
	/*
	 * 
	 * Constructor
	 * 
	 * */
	
	public Manufacturer() {
	}

	public Manufacturer(long id) {
		super(id);
	}

	/*
	 * 
	 * Getters and Setters
	 * 
	 * */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	
	
}
