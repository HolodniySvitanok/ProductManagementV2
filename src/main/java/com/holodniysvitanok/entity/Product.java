package com.holodniysvitanok.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

@Entity
@Table(name="product_table")
public class Product {

	@Id
    @Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "base_price_product") // базовая цена
	private int basePrice;
	
	@Column(name = "k_price_product") // к продажи
	private int kPrice;
	
	@Column(name = "count_product")
	private int count;
	
	@Column(name = "rate_product")
	private int rate;
	
	
	@Column(name = "stock_product")
	@Type(type= "org.hibernate.type.NumericBooleanType")
	private boolean stock;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "id_manufacturer")
	private Manufacturer manufacturer;
	
	@Column(name = "main_description_product")
	private String mainDescription;
		
	@Column(name = "show_product")
	@Type(type= "org.hibernate.type.NumericBooleanType")
	private boolean show;
	
	@Column(name = "url_image1_product")
	private String urlImage1;
	
	@Column(name = "url_image2_product")
	private String urlImage2;
	
	@Column(name = "url_image3_product")
	private String urlImage3;

	@Column(name = "support_field1_product")
	private String supportField1;
	
	@Column(name = "support_field2_product")
	private String supportField2;
	
	@Column(name = "support_field3_product")
	private String supportField3;
	
	@Column(name = "support_field4_product")
	private String supportField4;
	
	@Column(name = "support_field5_product")
	private String supportField5;
	
	@Column(name = "support_field6_product")
	private String supportField6;
	
	@Column(name = "support_field7_product")
	private String supportField7;
	
	@Column(name = "support_field8_product")
	private String supportField8;
	
	@Column(name = "support_field9_product")
	private String supportField9;
	
	@Column(name = "support_field10_product")
	private String supportField10;

	
	/*
	 * 
	 * Constructor
	 * 
	 * */
	public Product(long id) {
		this.id = id;
	}

	public Product() {
		super();
	}

	/*
	 * 
	 * Getter and Setter 
	 * 
	 * */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getkPrice() {
		return kPrice;
	}

	public void setkPrice(int kPrice) {
		this.kPrice = kPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMainDescription() {
		return mainDescription;
	}

	public void setMainDescription(String mainDescription) {
		this.mainDescription = mainDescription;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String getUrlImage1() {
		return urlImage1;
	}

	public void setUrlImage1(String urlImage1) {
		this.urlImage1 = urlImage1;
	}

	public String getUrlImage2() {
		return urlImage2;
	}

	public void setUrlImage2(String urlImage2) {
		this.urlImage2 = urlImage2;
	}

	public String getUrlImage3() {
		return urlImage3;
	}

	public void setUrlImage3(String urlImage3) {
		this.urlImage3 = urlImage3;
	}

	public String getSupportField1() {
		return supportField1;
	}

	public void setSupportField1(String supportField1) {
		this.supportField1 = supportField1;
	}

	public String getSupportField2() {
		return supportField2;
	}

	public void setSupportField2(String supportField2) {
		this.supportField2 = supportField2;
	}

	public String getSupportField3() {
		return supportField3;
	}

	public void setSupportField3(String supportField3) {
		this.supportField3 = supportField3;
	}

	public String getSupportField4() {
		return supportField4;
	}

	public void setSupportField4(String supportField4) {
		this.supportField4 = supportField4;
	}

	public String getSupportField5() {
		return supportField5;
	}

	public void setSupportField5(String supportField5) {
		this.supportField5 = supportField5;
	}

	public String getSupportField6() {
		return supportField6;
	}

	public void setSupportField6(String supportField6) {
		this.supportField6 = supportField6;
	}

	public String getSupportField7() {
		return supportField7;
	}

	public void setSupportField7(String supportField7) {
		this.supportField7 = supportField7;
	}

	public String getSupportField9() {
		return supportField9;
	}

	public void setSupportField9(String supportField9) {
		this.supportField9 = supportField9;
	}

	public String getSupportField10() {
		return supportField10;
	}

	public void setSupportField10(String supportField10) {
		this.supportField10 = supportField10;
	}

	public String getSupportField8() {
		return supportField8;
	}

	public void setSupportField8(String supportField8) {
		this.supportField8 = supportField8;
	}
	
	
	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	/*
	 * 
	 * Method
	 * 
	 * */
	public boolean isAvailable(){
		return (this.count > 0)? true : false;
	}

	public float getPrice(){
		
		if(kPrice == 0){
			return basePrice;
		}
		
		float proc = basePrice/100;
		return basePrice +(proc*kPrice);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", basePrice=" + basePrice + ", kPrice=" + kPrice + ", count=" + count + ", rate=" + rate + ", stock=" + stock
				+ ", category=" + category + ", show=" + show + ", urlImage1=" + urlImage1 + ", urlImage2=" + urlImage2 + ", urlImage3=" + urlImage3
				+ ", supportField1=" + supportField1 + ", supportField2=" + supportField2 + ", supportField3=" + supportField3 + ", supportField4="
				+ supportField4 + ", supportField5=" + supportField5 + ", supportField6=" + supportField6 + ", supportField7=" + supportField7
				+ ", supportField8=" + supportField8 + ", supportField9=" + supportField9 + ", supportField10=" + supportField10 + "]";
	}

	
	
}
