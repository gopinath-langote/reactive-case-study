package com.tw.springbootwebfluxvsspringmvc;

import com.tw.springbootwebfluxvsspringmvc.service.AgodaMockService;
import com.tw.springbootwebfluxvsspringmvc.service.GoIbiboMockService;
import com.tw.springbootwebfluxvsspringmvc.service.MakeMyTripMockService;
import com.tw.springbootwebfluxvsspringmvc.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.delayedExecutor;

@Component
public class FunctionHandler {


    private AgodaMockService agodaMockService;

    private MakeMyTripMockService makeMyTripMockService;

    private GoIbiboMockService goIbiboMockService;

    @Autowired
    public FunctionHandler(AgodaMockService agodaMockService, MakeMyTripMockService makeMyTripMockService, GoIbiboMockService goIbiboMockService) {
        this.agodaMockService = agodaMockService;
        this.makeMyTripMockService = makeMyTripMockService;
        this.goIbiboMockService = goIbiboMockService;
    }

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {

        String greeting = "";

        List<MockService> mockServices = Arrays.asList(this.agodaMockService,this.goIbiboMockService,this.makeMyTripMockService);

        List<CompletableFuture<String>> mockServiceFutures = mockServices.stream()
                .map(mockService -> getResponseFromMockService(mockService))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures =  CompletableFuture.allOf(
                mockServiceFutures.toArray(new CompletableFuture[mockServiceFutures.size()])
        );

        CompletableFuture<List<String>> allFutureResponse = allFutures.thenApply(v -> {
                return mockServiceFutures.stream()
                        .map(mockServiceFuture -> mockServiceFuture.join())
                        .collect(Collectors.toList());

        });
        try {
            greeting = String.join("\n",allFutureResponse.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject(greeting));
    }

    CompletableFuture<String> getResponseFromMockService(MockService mockService){


        return CompletableFuture.supplyAsync(() -> {

            return mockService.getResponse();
        },delayedExecutor(10,TimeUnit.SECONDS));
    }


}
