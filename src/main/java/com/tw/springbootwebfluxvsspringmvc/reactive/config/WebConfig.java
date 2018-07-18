package com.tw.springbootwebfluxvsspringmvc.reactive.config;

import com.tw.springbootwebfluxvsspringmvc.reactive.handler.RateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
    @Bean
    public RouterFunction<ServerResponse> routeGetRates(RateHandler rateHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/reactive/rates/{hotel_code}"), rateHandler::getRates);




    }
}

