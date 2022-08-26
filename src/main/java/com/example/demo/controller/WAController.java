package com.example.demo.controller;


import com.example.demo.exception.IllegalWikiNameException;
import com.example.demo.service.WAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wa")
public class WAController {

    @Autowired
    WAService waService;

    @RequestMapping(value = "/wiki_auction")
    public void wiki_auction(@RequestParam String auction_name) throws IllegalWikiNameException {
        waService.save_all_wa(auction_name);
    }

    @RequestMapping(value = "/count")
    public long count(){
        for(int i = 0; i < 100; i++)
            // select lock the table
            waService.findAll();
        return waService.count_was();
    }

    @RequestMapping(value = "/async_count")
    public long async_count(){
        for (int i = 0; i < 100; i ++)
            waService.async_findAll();
        return waService.count_was();
    }
}
