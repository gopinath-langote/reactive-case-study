package com.tw.springbootwebfluxvsspringmvc.reactive.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MakeMyTripMockService implements MockRateService{

    public Flux<Rate> getResponse(){

        return Flux.fromStream(Stream.of(
                new Rate("SUPER DELUX", (double) 1200),
                new Rate("DELUX", (double) 1000)
        ));
    }

}
