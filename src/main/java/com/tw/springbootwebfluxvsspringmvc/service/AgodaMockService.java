package com.tw.springbootwebfluxvsspringmvc.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class AgodaMockService implements MockService{

    public String getResponse(){

        return "Hello from Agoda";
    }

}
