package com.scuti.predictive.model;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Slf4j
@Document(collection = "product")
public class Product {

	private String id;
	private String name;
	private String code;
	private String description;
	private String sku;
	private String imageURL;
	private String brand;
	private String category;
	private String model;
	private String weight;
	private String width;
	private String height;
	private String depth;
	private String aggregateRating;
	private String additionalProperty;
	private String gtin12;//	Text 	The GTIN-12 code of the product, or the product to which the offer refers. The GTIN-12 is the 12-digit GS1 Identification Key composed of a U.P.C. Company Prefix, Item Reference, and Check Digit used to identify trade items. See GS1 GTIN Summary for more details.
	private String gtin13;//	Text 	The GTIN-13 code of the product, or the product to which the offer refers. This is equivalent to 13-digit ISBN codes and EAN UCC-13. Former 12-digit UPC codes can be converted into a GTIN-13 code by simply adding a preceeding zero. See GS1 GTIN Summary for more details.
	private String gtin14;//	Text 	The GTIN-14 code of the product, or the product to which the offer refers. See GS1 GTIN Summary for more details.
	private String gtin8;//
	private String isRelatedTo;
	private String isSimilarTo;
	private String itemCondition;
	private String mpn;
	private String productionDate;
	private String purchaseDate;
	private String review;
	private String url;
	private String color;
	private String size;
	private String gender;
	private String age;
	private String availability;
	private String upc;
	private String price;
	private String sale_price;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSale_price() {
		return sale_price;
	}

	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}



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

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getAggregateRating() {
		return aggregateRating;
	}

	public void setAggregateRating(String aggregateRating) {
		this.aggregateRating = aggregateRating;
	}

	public String getAdditionalProperty() {
		return additionalProperty;
	}

	public void setAdditionalProperty(String additionalProperty) {
		this.additionalProperty = additionalProperty;
	}

	public String getGtin12() {
		return gtin12;
	}

	public void setGtin12(String gtin12) {
		this.gtin12 = gtin12;
	}

	public String getGtin13() {
		return gtin13;
	}

	public void setGtin13(String gtin13) {
		this.gtin13 = gtin13;
	}

	public String getGtin14() {
		return gtin14;
	}

	public void setGtin14(String gtin14) {
		this.gtin14 = gtin14;
	}

	public String getGtin8() {
		return gtin8;
	}

	public void setGtin8(String gtin8) {
		this.gtin8 = gtin8;
	}

	public String getIsRelatedTo() {
		return isRelatedTo;
	}

	public void setIsRelatedTo(String isRelatedTo) {
		this.isRelatedTo = isRelatedTo;
	}

	public String getIsSimilarTo() {
		return isSimilarTo;
	}

	public void setIsSimilarTo(String isSimilarTo) {
		this.isSimilarTo = isSimilarTo;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
