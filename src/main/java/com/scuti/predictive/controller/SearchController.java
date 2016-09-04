package com.scuti.predictive.controller;

import com.scuti.predictive.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping("/search")
    public String home(Model model) {
        return "/search/search";
    }

    @RequestMapping(value = "/searchAll")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("searchMap", searchRepository.searchAll(search));
        model.addAttribute("search", search);
        return "/search/search";
    }

}
