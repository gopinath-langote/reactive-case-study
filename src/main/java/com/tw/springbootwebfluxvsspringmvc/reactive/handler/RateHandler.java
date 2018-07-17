package com.tw.springbootwebfluxvsspringmvc.reactive.handler;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.RateService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RateHandler {
    private RateService rateService;

    public RateHandler(RateService rateService) {
        this.rateService = rateService;
    }

    public Mono<ServerResponse> getRates(ServerRequest request) {
        Flux<Rate> shows = this.rateService.getRates();
        return ServerResponse.ok().body(shows, Rate.class);
    }
}
