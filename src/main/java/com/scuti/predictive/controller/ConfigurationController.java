package com.scuti.predictive.controller;

import com.scuti.predictive.model.ScutiConfiguration;
import com.scuti.predictive.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class ConfigurationController {

    @Autowired
    ConfigurationRepository
            configRepository;

    @RequestMapping("/configuration")
    public String home(Model model) {
        model.addAttribute("configurationList", configRepository.findAll());
        return "/configuration/configuration";
    }

    @RequestMapping(value = "/addConfig", method = RequestMethod.POST)
    public String addConfiguration(@ModelAttribute ScutiConfiguration config) {

        configRepository.save(config);
        return "redirect:/configuration/configuration";
    }

    @RequestMapping(value = "/deleteConfig/{id}", method = RequestMethod.GET)
    public String deleteConfiguration(@PathVariable("id") String id, Model model) {

        configRepository.delete(id);
        model.addAttribute("configurationList", configRepository.findAll());

        return "/configuration/configuration";
    }

}
