package com.tw.springbootwebfluxvsspringmvc.reactive.controller;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RateController {

    private RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/reactive/rates")
    public Flux<Rate> getRates() {
        return rateService.getRates();
    }


}
