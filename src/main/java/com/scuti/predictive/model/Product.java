package com.scuti.predictive.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	private String id;
	
	private String name;
	
	private String code;
	
	private String description;
	
	private Integer sku;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}
	
}
