package com.tw.springbootwebfluxvsspringmvc.domain;

public class Rate {
    private String roomType;
    private Double pricePerNight;

    public Rate(String roomType, Double pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }
    public String toString(){

        return "Room type: "+roomType+ " Price Per night: "+ pricePerNight;
    }

}
