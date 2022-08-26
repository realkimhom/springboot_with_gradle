package com.example.demo.mapper;

import com.example.demo.beans.Country;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Map;
import java.util.Objects;

public class CountryMapper {

    public Country mapping_from_map_to_country(Map<Object, Object> ori_map) throws ClassCastException {
        Country country = new Country();
        if (ori_map == null)
            return null;
        try{
            country.setCountry((String) ori_map.get("Country"));
            country.setSlug((String) ori_map.get("Slug"));
            country.setISO2((String) ori_map.get("ISO2"));

        }
        catch(ClassCastException e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            throw new ClassCastException("Some ");
        }
        return country;
    }
}
