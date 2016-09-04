package com.scuti.predictive.model;

/**
 * Created by kkataria on 9/4/2016.
 */
public class Item {

    private String name;
    private String sku;
    private String qty;
    private String price;
    private String discount;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
