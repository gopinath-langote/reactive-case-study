package com.tw.springbootwebfluxvsspringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringBootWebfluxVsSpringMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootWebfluxVsSpringMvcApplication.class, args);

	}
}
/*
Spring Boot has a WebFlux starter that automates these steps. By default the starter uses Netty

spring webflux supports 2 models Traditional annotation-based model  and functional endpoints




2018-07-17 09:54:33.372  INFO 503 --- [           main] s.w.r.r.m.a.RequestMappingHandlerMapping : Mapped "{[/reactive/rates],methods=[GET]}" onto public reactor.core.publisher.Flux<com.tw.springbootwebfluxvsspringmvc.domain.Rate> com.tw.springbootwebfluxvsspringmvc.reactive.controller.RateController.getRates()
2018-07-17 09:54:33.373  INFO 503 --- [           main] s.w.r.r.m.a.RequestMappingHandlerMapping : Mapped "{[/sync/rates],methods=[GET]}" onto public java.util.List<com.tw.springbootwebfluxvsspringmvc.domain.Rate> com.tw.springbootwebfluxvsspringmvc.sync.controller.SyncRateController.getRates() throws java.lang.InterruptedException
2018-07-17 09:54:33.425  INFO 503 --- [           main] o.s.w.r.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.reactive.resource.ResourceWebHandler]
2018-07-17 09:54:33.426  INFO 503 --- [           main] o.s.w.r.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.reactive.resource.ResourceWebHandler]
2018-07-17 09:54:33.512  INFO 503 --- [           main] o.s.w.r.r.m.a.ControllerMethodResolver   : Looking for @ControllerAdvice: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext@710636b0: startup date [Tue Jul 17 09:54:32 IST 2018]; root of context hierarchy
2018-07-17 09:54:33.855  INFO 503 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2018-07-17 09:54:33.918  INFO 503 --- [ctor-http-nio-1] r.ipc.netty.tcp.BlockingNettyContext     : Started HttpServer on /0:0:0:0:0:0:0:0:8080
2018-07-17 09:54:33.918  INFO 503 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
 */