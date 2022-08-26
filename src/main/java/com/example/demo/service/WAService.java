package com.example.demo.service;

import com.example.demo.beans.Country;
import com.example.demo.beans.WikiAuction;
import com.example.demo.exception.IllegalWikiNameException;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.mapper.WAMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class WAService {
    @Autowired
    WARepository waRepository;
    RestTemplate template = new RestTemplate();
    List<WikiAuction> wa_list = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(WAService.class);

    public ResponseEntity save_all_wa(String auction_name) throws IllegalWikiNameException {
        try{
            logger.info("https://whiskyhunter.net/api/auction_data/"+auction_name +"?format=json");
            ResponseEntity<List> response = template.getForEntity("https://whiskyhunter.net/api/auction_data/"+
                            auction_name +"?format=json",
                    List.class);
            // List<Map>
            List<Map<Object, Object>> map_list = response.getBody();

            System.out.println(map_list);
            for(Map map:map_list){
                WikiAuction new_wa = new WAMapper().mapping_from_map_to_wa(map);
                if (new_wa == null)
                    throw new IllegalArgumentException("One map is null");
                wa_list.add(new_wa);
            }
//            map_list.forEach((n) -> new WAMapper().mapping_from_map_to_wa(n));
            waRepository.saveAll(wa_list);
            logger.info("Successfully save the data");
            return new ResponseEntity<>("Successfully save the data", HttpStatus.OK);
        }catch (HttpClientErrorException e){
            throw new IllegalWikiNameException("No such Wiki: " + auction_name);
//            return new ResponseEntity<>("No such Wiki: " + auction_name, HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            throw e;
        }

    }
    public long count_was(){
        return waRepository.count();
    }
    public List<WikiAuction> findAll(){
        return waRepository.findAll();
    }

    @Async("async_find_all_from_wa")
    public List<WikiAuction> async_findAll()
    {
        try{
            return waRepository.findAll();
        }
        catch (Exception e){
            throw e;
        }
    }
}
