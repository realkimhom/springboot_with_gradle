package com.example.demo.mapper;

import com.example.demo.beans.Country;
import com.example.demo.beans.WikiAuction;
import com.example.demo.exception.IllegalValueException;

import java.util.Map;

public class WAMapper {

    public WikiAuction mapping_from_map_to_wa(Map<Object, Object> ori_map) throws ClassCastException {
        WikiAuction wikiAuction = new WikiAuction();
        if (ori_map == null)
            return null;
        try{
            wikiAuction.setDt((String) ori_map.get("dt"));
            wikiAuction.setWinning_bid_max((float) (double)ori_map.get("winning_bid_max"));
            wikiAuction.setWinning_bid_min((float) (double)ori_map.get("winning_bid_min"));
            wikiAuction.setAuction((String) ori_map.get("auction_name"));

            // can do more map here,
            IllegalValueException.check_max_min((float) (double) ori_map.get("winning_bid_max"),
                    (float) (double)ori_map.get("winning_bid_min") );
        }
        catch(ClassCastException e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            throw new ClassCastException("Cast can't be done. ");
        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        }
        return wikiAuction;
    }
}
