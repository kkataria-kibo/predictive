package com.scuti.predictive.repository;

import com.scuti.predictive.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ProductSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Product> searchProduct(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("description").regex(text, "i"),
									Criteria.where("code").regex(text, "i"),
									Criteria.where("name").regex(text, "i"))
						), Product.class);
	}

	public Collection<Product> searchOrgProducts(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("brand").regex(text, "i"))
		), Product.class);
	}
	
}
