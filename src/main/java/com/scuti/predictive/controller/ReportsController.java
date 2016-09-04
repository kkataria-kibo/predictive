package com.scuti.predictive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class ReportsController {

    @RequestMapping("/reports")
    public String home(Model model) {
        return "/reports/reports";
    }

}
