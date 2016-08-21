package com.scuti.predictive.controller;

import com.scuti.predictive.model.Product;
import com.scuti.predictive.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by kkataria on 8/21/2016.
 */

@RestController
public class RecommendationController {

    @Autowired
    ProductSearchRepository productSearchRepository;

    @RequestMapping(value = "/{org}/recommend" , method = RequestMethod.GET , produces = "application/json")
    public Collection<Product> recommend(@PathVariable("org") String name) {
        return  productSearchRepository.searchOrgProducts(name);
    }
}
