package com.scuti.predictive.repository;

import com.scuti.predictive.model.Customer;
import com.scuti.predictive.model.Product;
import com.scuti.predictive.model.ScutiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public Map<String,Collection> searchAll(String text) {

		Map<String,Collection> results = new HashMap();
		Collection<Product> products =  mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("description").regex(text, "i"),
						Criteria.where("code").regex(text, "i"),
						Criteria.where("name").regex(text, "i"))
		), Product.class);

		results.put("product",products);

		Collection<Customer> customers = mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("email").regex(text, "i"),
						Criteria.where("userName").regex(text, "i"),
						Criteria.where("group").regex(text, "i"))
		), Customer.class);

		results.put("customer",customers);

		Collection<ScutiConfiguration> configs = mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("property").regex(text, "i"),
						Criteria.where("value").regex(text, "i"),
						Criteria.where("organization").regex(text, "i"))
		), ScutiConfiguration.class);

		results.put("configuration",configs);

		return results;
	}

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

	public Collection<Customer> searchCustomer(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("email").regex(text, "i"),
						Criteria.where("userName").regex(text, "i"),
						Criteria.where("group").regex(text, "i"))
		), Customer.class);
	}

	public Collection<Customer> searchGroupCustomer(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("group").regex(text, "i"))
		), Customer.class);
	}

	public Collection<ScutiConfiguration> searchConfiguration(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("property").regex(text, "i"),
						Criteria.where("value").regex(text, "i"),
						Criteria.where("organization").regex(text, "i"))
		), ScutiConfiguration.class);
	}

	public Collection<ScutiConfiguration> searchOrganizationConfiguration(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("organization").regex(text, "i"))
		), ScutiConfiguration.class);
	}
	
}
