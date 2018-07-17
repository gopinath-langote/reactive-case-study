package com.tw.springbootwebfluxvsspringmvc.sync.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "GOService")
public class GoIbiboMockService implements MockRateService {
    public List<Rate> getResponse() {

        return Arrays.asList(
                new Rate("GOIBIBO SUPER DELUX", (double) 1200),
                new Rate("GOIBIBO DELUX", (double) 1000)
        );


    }


}
