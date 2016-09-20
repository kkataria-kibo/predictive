package com.scuti.predictive.model;

/**
 * Created by kkataria on 9/19/2016.
 */
public class Ratings {

    private Integer userid;
    private Integer productid;
    private Number rating;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Number getRating() {
        return rating;
    }

    public void setRating(Number rating) {
        this.rating = rating;
    }
}
