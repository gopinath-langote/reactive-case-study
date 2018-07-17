package com.tw.springbootwebfluxvsspringmvc.sync.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MockRateService {
    List<Rate> getResponse();


}
