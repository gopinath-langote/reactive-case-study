package com.tw.springbootwebfluxvsspringmvc.reactive.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MockRateService {
    Flux<Rate> getResponse();

    Mono<Rate> getRateByHotel(String hotelCode);
}
