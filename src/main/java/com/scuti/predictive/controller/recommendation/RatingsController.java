package com.scuti.predictive.controller.recommendation;

import com.scuti.predictive.model.Ratings;
import com.scuti.predictive.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kkataria on 8/21/2016.
 */

@Controller
public class RatingsController {

    @Autowired
    RatingsRepository ratingsRepository;

    @RequestMapping("/ratings")
    public String home(Model model) {
        model.addAttribute("ratingsList", ratingsRepository.findAll());
        return "/ratings/ratings";
    }

    @RequestMapping(value = "/addRating", method = RequestMethod.POST)
    public String addRating(@ModelAttribute Ratings ratings) {

        ratingsRepository.save(ratings);
        return "redirect:/ratings/ratings";
    }
}
