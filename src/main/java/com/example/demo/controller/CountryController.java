package com.example.demo.controller;


import com.example.demo.beans.Country;
import com.example.demo.service.CountryService;
import com.example.demo.service.WAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CountryController {
    private static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    CountryService countryService;

    @RequestMapping(value="/save_countries")
    public void save_countries(){
        countryService.save_countries();
    }

    @PostMapping(value="/new_country")
    public void new_country(@RequestBody Map<Object, Object> payload){

        countryService.new_country(payload);

    }

}
