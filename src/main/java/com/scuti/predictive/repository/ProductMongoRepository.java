package com.scuti.predictive.repository;

import com.scuti.predictive.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductMongoRepository extends CrudRepository<Product, String> {}