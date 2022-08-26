package com.example.demo.service;

import com.example.demo.beans.Country;
import com.example.demo.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CountryService {

    // Request
    @Autowired
    CountryRepository countryRepository;

    public void save_countries(){

        RestTemplate template = new RestTemplate();
        List<Country> countries_list = new ArrayList<>();
        try{
            ResponseEntity<List> response = template.getForEntity("https://api.covid19api.com/countries",
                    List.class);

            // List<Map>
            List<Map<Object, Object>> map_list = response.getBody();

            System.out.println(map_list);
            for(Map map:map_list){
                Country new_country = new CountryMapper().mapping_from_map_to_country(map);
                if (new_country == null)
                    throw new IllegalArgumentException("One map is null");
                countries_list.add(new_country);
            }

        }
        catch (Exception e){
            throw e;
        }

        countryRepository.saveAll(countries_list);


    }

    public long count_countries(){
        return countryRepository.count();
    }

    public void new_country(Map country_map){
        Country country = new CountryMapper().mapping_from_map_to_country(country_map);
        countryRepository.save(country);
    }

}
