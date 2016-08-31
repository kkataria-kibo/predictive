package com.scuti.predictive.controller;

import com.scuti.predictive.model.Product;
import com.scuti.predictive.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class ConfigurationController {

    @RequestMapping("/configuration")
    public String home(Model model) {

        return "configuration";
    }

}
