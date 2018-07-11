package com.tw.springbootwebfluxvsspringmvc.reactive.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import reactor.core.publisher.Flux;

public interface MockRateService {
    Flux<Rate> getResponse();
}
