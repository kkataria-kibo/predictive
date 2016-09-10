package com.scuti.predictive.controller;

import com.scuti.predictive.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/order")
    public String home(Model model) {
        model.addAttribute("orderList", orderRepository.findAll());
        return "/orders/order";
    }


    @RequestMapping("/orderUpload")
    public String orderUpload(Model model) {

        return "/orders/orderUpload";
    }

}
