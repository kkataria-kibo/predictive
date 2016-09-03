package com.scuti.predictive.repository;

import com.scuti.predictive.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {}