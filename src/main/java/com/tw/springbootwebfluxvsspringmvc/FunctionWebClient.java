package com.tw.springbootwebfluxvsspringmvc;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;


public class FunctionWebClient {

    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<String> result = client.get().uri("/hello").retrieve().bodyToMono(String.class);

    public  String getResult() {
        return ">> result = " + result.doOnEach(c -> System.out.println(c)).subscribe();

    }

}
