package com.tw.springbootwebfluxvsspringmvc.reactive.handler;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.RateService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class RateHandler {
    private RateService rateService;

    public RateHandler(RateService rateService) {
        this.rateService = rateService;
    }

    public Mono<ServerResponse> getRates(ServerRequest request) {
        String hotel_code = request.pathVariable("hotel_code");
        
        Flux<Rate> rates = this.rateService.getRates(hotel_code);
        return ServerResponse.ok().body(rates.
                onErrorMap(RuntimeException.class, e -> new ResponseStatusException( BAD_REQUEST, e.getMessage())), Rate.class);
    }
}


