package com.scuti.predictive.controller;

import com.scuti.predictive.model.Customer;
import com.scuti.predictive.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository
            customerRepository;

    @RequestMapping("/customer")
    public String home(Model model) {
        model.addAttribute("customerList", customerRepository.findAll());
        return "/customer/customer";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addConfiguration(@ModelAttribute Customer customer) {

        customerRepository.save(customer);
        return "redirect:/customer/customer";
    }

    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
    public String deleteConfiguration(@PathVariable("id") String id, Model model) {

        customerRepository.delete(id);
        model.addAttribute("customerList", customerRepository.findAll());

        return "/customer/customer";
    }


}
