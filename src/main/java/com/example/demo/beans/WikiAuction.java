package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WikiAuction {
    @Id
    private String dt;

    @Column(name = "winning_bid_max")
    private float winning_bid_max;

    @Column(name = "winning_bid_min")
    private float winning_bid_min;

    @Column(name = "auction_name")
    private String auction;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public float getWinning_bid_max() {
        return winning_bid_max;
    }

    public void setWinning_bid_max(float winning_bid_max) {
        this.winning_bid_max = winning_bid_max;
    }

    public float getWinning_bid_min() {
        return winning_bid_min;
    }

    public void setWinning_bid_min(float winning_bid_min) {
        this.winning_bid_min = winning_bid_min;
    }

    public String getAuction() {
        return auction;
    }

    public void setAuction(String auction) {
        this.auction = auction;
    }
}
