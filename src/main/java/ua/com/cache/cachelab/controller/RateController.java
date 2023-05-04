package ua.com.cache.cachelab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.cache.cachelab.entity.Category;
import ua.com.cache.cachelab.entity.Rate;
import ua.com.cache.cachelab.service.CategoryService;
import ua.com.cache.cachelab.service.RateService;

import java.math.BigDecimal;

@Controller
public class RateController {

    private final RateService rateService;
    @Autowired
    public RateController(RateService rateService) {

        this.rateService = rateService;
    }

    @GetMapping("/rate")
    public String getHome(Model model){
        model.addAttribute("rate", rateService.getAllRate());
        return "rateindex";
    }


    @GetMapping("/rate/{id}")
    public String getRateById(@PathVariable("id") Long id,
                              Model model){
        model.addAttribute("rate",rateService.findRateById(id));
        return "rate";
    }




    @PostMapping("/saverate")
    public String saveNewRate(@RequestParam(name = "name") String name1,
                              @RequestParam(name = "price") BigDecimal price,
                              @RequestParam(name = "image") String image){

        Rate rate = new Rate();
        rate.setName(name1);
        rate.setPrice(price);
        rate.setImage(image);

        rateService.saveNewRate(rate);

        return "redirect:/rate";
    }


    @PostMapping("/updaterate")
    public String updateRate(@RequestParam(name = "id") Rate rate,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "price") BigDecimal price,
                             @RequestParam(name = "image") String image){

        rate.setPrice(price);
        rate.setName(name);
        rate.setImage(image);

        rateService.updateRate(rate);

        return "redirect:/rate";
    }



    @PostMapping("/deleterate")
    public String deleteRateById(@RequestParam(name = "id") Long id){
        rateService.deleteRate(id);
        return "redirect:/rate";
    }



}