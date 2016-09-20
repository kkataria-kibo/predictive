package com.scuti.predictive.repository;


import com.scuti.predictive.model.Ratings;
import org.springframework.data.repository.CrudRepository;

public interface RatingsRepository extends CrudRepository<Ratings, String> {}