package com.scuti.predictive.repository;

import com.scuti.predictive.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

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



	public List<SalesReport> getOrderCount() {
		Aggregation agg = newAggregation(Order.class,
				group("orderID").count().as("count"),
				project("count").and("orderID").previousOperation(),
				sort(Sort.Direction.DESC, "count")

		);
		AggregationResults<SalesReport> groupResults
				= mongoTemplate.aggregate(agg, Order.class, SalesReport.class);
		List<SalesReport> result = groupResults.getMappedResults();
		return result;
	}

	public List<CustomerReport> getCustomerStatusGroup() {

		Aggregation agg = newAggregation(Customer.class,
				group("status").count().as("count"),
				project("count").and("status").previousOperation(),
				sort(Sort.Direction.DESC, "count")

		);
		AggregationResults<CustomerReport> groupResults
				= mongoTemplate.aggregate(agg, Customer.class, CustomerReport.class);
		List<CustomerReport> result = groupResults.getMappedResults();
		return result;
	}
	
}
