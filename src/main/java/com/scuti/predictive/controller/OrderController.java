package com.scuti.predictive.controller;

import com.scuti.predictive.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class OrderController {

    @RequestMapping("/order")
    public String home(Model model) {
        return "order";
    }

}
