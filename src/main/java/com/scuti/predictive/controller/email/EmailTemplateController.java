package com.scuti.predictive.controller.email;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class EmailTemplateController {

    @RequestMapping("/templates")
    public String home(Model model) {
        return "/email/templates";
    }


}
