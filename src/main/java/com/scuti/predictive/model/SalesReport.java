package com.scuti.predictive.model;

/**
 * Created by kkataria on 9/4/2016.
 */
public class SalesReport {

    private String orderID;
    private long count;

    public SalesReport() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
