//package com.tw.springbootwebfluxvsspringmvc.reactive.controller;
//
//import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
//import com.tw.springbootwebfluxvsspringmvc.reactive.service.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import reactor.core.publisher.Flux;
//
//
//public class RateController {
//
//    private RateService rateService;
//
//    public RateController(RateService rateService) {
//        this.rateService = rateService;
//    }
//
//    @GetMapping("/reactive/rates/{hotel_code}")
//    public Flux<Rate> getRates(@PathVariable(value = "hotel_code") String hotel_code) {
//        return rateService.getRates(hotel_code);
//    }
//
//
//}
