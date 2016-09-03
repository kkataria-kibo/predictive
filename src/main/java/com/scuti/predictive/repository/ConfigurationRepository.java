package com.scuti.predictive.repository;


import com.scuti.predictive.model.ScutiConfiguration;
import org.springframework.data.repository.CrudRepository;

public interface ConfigurationRepository extends CrudRepository<ScutiConfiguration, String> {}