package com.tw.springbootwebfluxvsspringmvc.reactive.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Service
public class RateService {

    private AgodaMockService agodaMockService;

    private MakeMyTripMockService makeMyTripMockService;

    private GoIbiboMockService goIbiboMockService;


    @Autowired
    public RateService(AgodaMockService agodaMockService, MakeMyTripMockService makeMyTripMockService, GoIbiboMockService goIbiboMockService) {
        this.agodaMockService = agodaMockService;
        this.makeMyTripMockService = makeMyTripMockService;
        this.goIbiboMockService = goIbiboMockService;
    }

    public Flux<Rate> getRates(String hotel_code) {
        return Flux
                .fromStream(Stream.of(this.agodaMockService, this.goIbiboMockService, this.makeMyTripMockService))
                .flatMap(mockRateService -> mockRateService.getRateByHotel(hotel_code));
    }
}
