package com.tw.springbootwebfluxvsspringmvc.service;

import org.springframework.stereotype.Service;

@Service
public class GoIbiboMockService implements MockService{
    public String getResponse(){

        return "Hello from GoIbibo";
    }
}
