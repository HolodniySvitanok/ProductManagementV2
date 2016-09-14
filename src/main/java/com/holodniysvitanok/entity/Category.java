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
@Table(name="category_table")
public class Category extends ImageFile {

	@Column(name = "name_category", unique=true, nullable=false)
	private String name;

	@Column(name = "description_category")
	private String description;

	@Column(name = "support_field1_category")
	private String supportFieldName1;

	@Column(name = "support_field2_category")
	private String supportFieldName2;

	@Column(name = "support_field3_category")
	private String supportFieldName3;

	@Column(name = "support_field4_category")
	private String supportFieldName4;

	@Column(name = "support_field5_category")
	private String supportFieldName5;

	@Column(name = "support_field6_category")
	private String supportFieldName6;

	@Column(name = "support_field7_category")
	private String supportFieldName7;

	@Column(name = "support_field8_category")
	private String supportFieldName8;

	@Column(name = "support_field9_category")
	private String supportFieldName9;

	@Column(name = "support_field10_category")
	private String supportFieldName10;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	
	/*
	 * 
	 * Constructor
	 * 
	 */

	public Category() {

	}
	public Category(long id) {
		super(id);
	}

	/*
	 * 
	 * Getters and Setters
	 * 
	 */

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

	

	public String getSupportFieldName1() {
		return supportFieldName1;
	}

	public void setSupportFieldName1(String supportFieldName1) {
		this.supportFieldName1 = supportFieldName1;
	}

	public String getSupportFieldName2() {
		return supportFieldName2;
	}

	public void setSupportFieldName2(String supportFieldName2) {
		this.supportFieldName2 = supportFieldName2;
	}

	public String getSupportFieldName3() {
		return supportFieldName3;
	}

	public void setSupportFieldName3(String supportFieldName3) {
		this.supportFieldName3 = supportFieldName3;
	}

	public String getSupportFieldName4() {
		return supportFieldName4;
	}

	public void setSupportFieldName4(String supportFieldName4) {
		this.supportFieldName4 = supportFieldName4;
	}

	public String getSupportFieldName5() {
		return supportFieldName5;
	}

	public void setSupportFieldName5(String supportFieldName5) {
		this.supportFieldName5 = supportFieldName5;
	}

	public String getSupportFieldName6() {
		return supportFieldName6;
	}

	public void setSupportFieldName6(String supportFieldName6) {
		this.supportFieldName6 = supportFieldName6;
	}

	public String getSupportFieldName7() {
		return supportFieldName7;
	}

	public void setSupportFieldName7(String supportFieldName7) {
		this.supportFieldName7 = supportFieldName7;
	}

	public String getSupportFieldName8() {
		return supportFieldName8;
	}

	public void setSupportFieldName8(String supportFieldName8) {
		this.supportFieldName8 = supportFieldName8;
	}

	public String getSupportFieldName9() {
		return supportFieldName9;
	}

	public void setSupportFieldName9(String supportFieldName9) {
		this.supportFieldName9 = supportFieldName9;
	}

	public String getSupportFieldName10() {
		return supportFieldName10;
	}

	public void setSupportFieldName10(String supportFieldName10) {
		this.supportFieldName10 = supportFieldName10;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	

	
}
