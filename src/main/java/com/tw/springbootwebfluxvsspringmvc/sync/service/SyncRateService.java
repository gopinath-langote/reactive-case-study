package com.tw.springbootwebfluxvsspringmvc.sync.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.sync.service.AgodaMockService;
import com.tw.springbootwebfluxvsspringmvc.sync.service.GoIbiboMockService;
import com.tw.springbootwebfluxvsspringmvc.sync.service.MakeMyTripMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SyncRateService {
    @Autowired
    @Qualifier("AGODAService")
    private AgodaMockService agodaMockService;

    @Autowired
    @Qualifier("MMTService")
    private MakeMyTripMockService makeMyTripMockService;

    @Autowired
    @Qualifier("GOService")
    private GoIbiboMockService goIbiboMockService;



    public SyncRateService(AgodaMockService agodaMockService, MakeMyTripMockService makeMyTripMockService, GoIbiboMockService goIbiboMockService) {
        this.agodaMockService = agodaMockService;
        this.makeMyTripMockService = makeMyTripMockService;
        this.goIbiboMockService = goIbiboMockService;
    }

    public List<Rate> getRates() {

       return Stream.of(this.agodaMockService, this.goIbiboMockService, this.makeMyTripMockService)
                .map(service -> service.getResponse()).flatMap(List::stream).collect(Collectors.toList());


    }
}
