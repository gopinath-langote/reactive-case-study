package com.tw.springbootwebfluxvsspringmvc.sync.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value = "MMTService")
public class MakeMyTripMockService implements MockRateService {

    public List<Rate> getResponse(){

        return Arrays.asList(
                new Rate("MMT SUPER DELUX", (double) 1200),
                new Rate("MMT DELUX", (double) 1000)
        );
    }


}
