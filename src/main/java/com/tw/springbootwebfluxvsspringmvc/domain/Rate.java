package com.tw.springbootwebfluxvsspringmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DecimalFormat;

@JsonIgnoreProperties
public class Rate {
    private String provider;
    private String roomType;
    private Double pricePerNight;
    private String currency;
    private Double tax;


    public Rate() {
    }

    public Rate(String roomType, Double pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public Rate(String provider, String roomType, Double pricePerNight, String currency, Double tax) {
        this.provider = provider;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
        this.tax = tax;
    }

    public String getProvider() {
        return provider;
    }

    public String getRoomType() {
        return roomType;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getTax() {
        return tax;
    }

    public String toString() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        return "Room type: " + roomType + " Price Per night: " + dec.format(pricePerNight) + currency+ " Tax: "+dec.format(tax)+"%";
    }

}
