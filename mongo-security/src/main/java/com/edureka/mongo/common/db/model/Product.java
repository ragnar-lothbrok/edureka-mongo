package com.edureka.mongo.common.db.model;

import java.io.Serializable;

public class Product extends AuditEntity implements Serializable {

	private static final long serialVersionUID = 4913933159110420730L;

	private String supc;

	private String brand;

	private String description;
	private String size;

	private String category;

	private String subCategory;
	private float price;
	private Long quantity;
	private String country;
	private String sellerCode;
	private String stock;

	private Long pogId;

	public Product(Long pogId, String supc, String brand, String description, String size, String category,
			String subCategory, float price, Long quantity, String country, String sellerCode, String stock) {
		super();
		this.pogId = pogId;
		this.supc = supc;
		this.brand = brand;
		this.description = description;
		this.size = size;
		this.category = category;
		this.subCategory = subCategory;
		this.price = price;
		this.quantity = quantity;
		this.country = country;
		this.sellerCode = sellerCode;
		this.stock = stock;
	}

	public Product() {

	}

	public String getSupc() {
		return supc;
	}

	public void setSupc(String supc) {
		this.supc = supc;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Long getPogId() {
		return pogId;
	}

	public void setPogId(Long pogId) {
		this.pogId = pogId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Product(Long pogId, String brand, String description, String category, String subCategory, float price) {
		super();
		this.setId(pogId.toString());
		this.brand = brand;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.price = price;
	}

}
