package com.scuti.predictive.util;

import com.scuti.predictive.model.*;
import com.scuti.predictive.repository.OrderRepository;
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

    @Autowired
    OrderRepository orderRepository;

    public boolean parseCSV(CSVParser parser)
            throws Exception {

        Set<String> headers = parser.getHeaderMap().keySet();

        int lineNumber = 1;

        List<Product> products = new ArrayList();

        for (CSVRecord line : parser) {
            lineNumber++;
            //String code = StringUtils.trim(line.get("CODE"));
            String name = StringUtils.trim(line.get("title"));
            String description = StringUtils.trim(line.get("description"));
            String sku = StringUtils.trim(line.get("SKU"));
            String link = StringUtils.trim(line.get("link"));
            String image = StringUtils.trim(line.get("image"));
            String color = StringUtils.trim(line.get("color"));
            String size = StringUtils.trim(line.get("size"));
            String gender = StringUtils.trim(line.get("gender"));
            String age = StringUtils.trim(line.get("age"));
            String availability = StringUtils.trim(line.get("availability"));
            String upc = StringUtils.trim(line.get("UPC"));
            String price = StringUtils.trim(line.get("price"));
            String sale_price = StringUtils.trim(line.get("sale price"));
            String parent_id = StringUtils.trim(line.get("parent id"));
            String brand = StringUtils.trim(line.get("brand"));
            String shipping = StringUtils.trim(line.get("shipping"));
            String category = StringUtils.trim(line.get("category"));
            String google_category = StringUtils.trim(line.get("google category"));
            String MPN = StringUtils.trim(line.get("MPN"));
            //SKU	title	description	link	image	color	size	gender	age	availability	UPC	price	sale price
            // parent id	brand	shipping	category	google category	MPN
            Product product = new Product();
            product.setColor(color);
            product.setSize(size);
            product.setGender(gender);
            product.setAge(age);
            product.setAvailability(availability);
            product.setUpc(upc);
            product.setPrice(price);
            product.setSale_price(sale_price);
            product.setCode(parent_id);
            product.setName(name);
            product.setDescription(description);
            product.setSku(sku);
            product.setImageURL(image);
            product.setBrand(brand);
            product.setMpn(MPN);
            product.setCategory(category);
            product.setUrl(link);

            products.add(product);

        }

        productRepository.save(products);

        return true;
    }

    public boolean parseOrderCSV(CSVParser parser)
            throws Exception {

        Set<String> headers = parser.getHeaderMap().keySet();

        int lineNumber = 1;

        List<Order> orders = new ArrayList();

        for (CSVRecord line : parser) {

            lineNumber++;
            String orderId = StringUtils.trim(line.get("OrderID"));
            String orderDate = StringUtils.trim(line.get("OrderDate"));
            String firstName = StringUtils.trim(line.get("FirstName"));
            String lastName = StringUtils.trim(line.get("LastName"));
            String shipState = StringUtils.trim(line.get("ShipState"));
            String shipCity = StringUtils.trim(line.get("ShipCity"));
            String shipPostalCode = StringUtils.trim(line.get("ShipPostalCode"));
            String item = StringUtils.trim(line.get("Item"));
            String productName = StringUtils.trim(line.get("ProductName"));
            String qty = StringUtils.trim(line.get("Qty"));
            String priceEach = StringUtils.trim(line.get("PriceEach"));
            String itemDiscount = StringUtils.trim(line.get("ItemDiscount"));
            String totalPrice = StringUtils.trim(line.get("TotalPrice"));
            String merchandiseTotal = StringUtils.trim(line.get("MerchandiseTotal"));
            String orderDiscount = StringUtils.trim(line.get("OrderDiscount"));
            String shipping = StringUtils.trim(line.get("Shipping"));
            String discountedShipping = StringUtils.trim(line.get("DiscountedShipping"));
            String tax = StringUtils.trim(line.get("Tax"));
            String totalInvoiced = StringUtils.trim(line.get("TotalInvoiced"));
            String couponCode = StringUtils.trim(line.get("CouponCode"));
            String paymentMethod = StringUtils.trim(line.get("PaymentMethod"));


            log.debug("IMPORTING CSV FILE.... " + "item" + item + "orderId" + orderId);

            Order order = new Order();

            //fill sku here
            Item _item = new Item();
            _item.setSku(item);
            _item.setName(productName);
            order.setItems(_item);

            //fill data here in order object...
            order.setOrderID(orderId);
            order.setDateOrdered(orderDate);

            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            order.setCustomer(customer);

            Shipment shipment = new Shipment();

            shipment.setState(shipState);
            shipment.setCity(shipCity);
            shipment.setPostalCode(shipPostalCode);
            order.setShippingCostTotal(shipping);

            order.setOrderDiscount(orderDiscount);
            order.setMerhandiseTotal(merchandiseTotal);
            order.setCharges(totalInvoiced);
            order.setTax(tax);
            order.setSourceCodes(couponCode);
            Payment payment = new Payment();
            payment.setType(paymentMethod);
            order.setPayments(payment);

            orders.add(order);

        }

        orderRepository.save(orders);

        return true;
    }

}
