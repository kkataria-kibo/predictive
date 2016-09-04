package com.scuti.predictive.repository;

import com.scuti.predictive.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {}