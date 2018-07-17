package com.tw.springbootwebfluxvsspringmvc.sync.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "AGODAService")
public class AgodaMockService implements MockRateService {

    public List<Rate> getResponse() {

       return  Arrays.asList(
                new Rate("AGODA SUPER DELUX", (double) 1200),
                new Rate("AGODA DELUX", (double) 1000)
        );
    }



}
