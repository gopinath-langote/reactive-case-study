package com.tw.springbootwebfluxvsspringmvc.reactive.controller;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.AgodaMockService;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.GoIbiboMockService;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.MakeMyTripMockService;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.MockRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController

public class RateController {

    private AgodaMockService agodaMockService;

    private MakeMyTripMockService makeMyTripMockService;

    private GoIbiboMockService goIbiboMockService;


    @Autowired
    public RateController(AgodaMockService agodaMockService, MakeMyTripMockService makeMyTripMockService, GoIbiboMockService goIbiboMockService) {
        this.agodaMockService = agodaMockService;
        this.makeMyTripMockService = makeMyTripMockService;
        this.goIbiboMockService = goIbiboMockService;
    }

    @GetMapping("/reactive/rates")
    public Flux<Rate> getRates() {
        List<MockRateService> mockServices = Arrays.asList(this.agodaMockService, this.goIbiboMockService, this.makeMyTripMockService);

        List<Rate> collectiveRates = new ArrayList<Rate>();

        List<Flux<Rate>> fluxFlux = mockServices.stream().map(
                service -> service.getResponse()).collect(Collectors.toList());

       return Flux.concat(Flux.fromIterable(fluxFlux));
    }

}
