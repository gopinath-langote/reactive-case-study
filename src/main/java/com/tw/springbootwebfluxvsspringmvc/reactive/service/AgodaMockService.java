package com.tw.springbootwebfluxvsspringmvc.reactive.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class AgodaMockService implements MockRateService {

    @Override
    public Flux<Rate> getResponse() {

        return Flux.fromStream(Stream.of(
                new Rate("AGODA SUPER DELUX", (double) 1200),
                new Rate("AGODA DELUX", (double) 1000)
        )).delayElements(Duration.ofMillis(100));
    }

    @Override
    public Mono<Rate> getRateByHotel(String hotelCode) {
        return Mono.just(new Rate("AGODA SUPER DELUX", (double) 1200));
    }

}
