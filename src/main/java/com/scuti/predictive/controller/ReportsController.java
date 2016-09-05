package com.scuti.predictive.controller;

import com.scuti.predictive.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class ReportsController {

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping("/reports")
    public String home(Model model) {
        return "/reports/reports";
    }

    @RequestMapping("/reports/orderCount")
    public String productCount(Model model) {


        model.addAttribute("reportList", searchRepository.getOrderCount());

        return "/reports/reports";
    }

    @RequestMapping("/reports/customerStatusCount")
    public String customerStatusCount(Model model) {


        model.addAttribute("reportCustomerList", searchRepository.getCustomerStatusGroup());

        return "/reports/reports";
    }

}
