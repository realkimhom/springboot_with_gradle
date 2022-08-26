package com.example.demo.handler;

import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryHandler {
    @Autowired
    CountryService countryService;

    public void save_countries(){
        countryService.save_countries();
    }
}
