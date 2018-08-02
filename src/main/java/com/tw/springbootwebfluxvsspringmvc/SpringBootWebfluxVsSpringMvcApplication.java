package com.tw.springbootwebfluxvsspringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.Set;

@SpringBootApplication
public class SpringBootWebfluxVsSpringMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootWebfluxVsSpringMvcApplication.class, args);



	}
}
