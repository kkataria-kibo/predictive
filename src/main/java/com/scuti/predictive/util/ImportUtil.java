package com.scuti.predictive.util;

import com.scuti.predictive.model.Product;
import com.scuti.predictive.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by kkataria on 9/4/2016.
 */
@Component
@Slf4j
public class ImportUtil {

    @Autowired
    ProductRepository productRepository;

    public boolean parseCSV(CSVParser parser)
            throws Exception {

        Set<String> headers = parser.getHeaderMap().keySet();

        int lineNumber = 1;

        List<Product> products = new ArrayList();

        for (CSVRecord line : parser) {
            lineNumber++;
            String code = StringUtils.trim(line.get("CODE"));
            String name = StringUtils.trim(line.get("NAME"));
            String description = StringUtils.trim(line.get("DESCRIPTION"));
            String sku = StringUtils.trim(line.get("SKU"));
            String imageurl = StringUtils.trim(line.get("IMAGEURL"));

            log.debug("IMPORTING CSV FILE.... " +  "code" + code + "name" + name );

            Product product = new Product();


            product.setCode(code);
            product.setName(name);
            product.setDescription(description);
            product.setSku(sku);
            product.setImageURL(imageurl);

            products.add(product);

        }

         productRepository.save(products);

        return true;
    }

}
