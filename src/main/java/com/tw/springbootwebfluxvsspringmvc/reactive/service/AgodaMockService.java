package com.tw.springbootwebfluxvsspringmvc.reactive.service;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AgodaMockService implements MockRateService {

    @Autowired
    private RateRepository rateRepository;

    public AgodaMockService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public Flux<Rate> getRateByHotel(String hotelCode) {

            return rateRepository.getRatesByHotel(hotelCode,"AGODA");

    }

}
