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
public class EmailController {

    @RequestMapping("/email")
    public String home(Model model) {
        return "/email/email";
    }


}
