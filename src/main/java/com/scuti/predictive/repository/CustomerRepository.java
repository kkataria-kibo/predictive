package com.scuti.predictive.repository;

/**
 * Created by kkataria on 8/20/2016.
 */

import com.scuti.predictive.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    public Customer findByUserName(String userName);

}

