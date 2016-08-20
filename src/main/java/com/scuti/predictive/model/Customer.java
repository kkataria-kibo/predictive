package com.scuti.predictive.model;

/**
 * Created by kkataria on 8/20/2016.
 */
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {


    private String id;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }

}