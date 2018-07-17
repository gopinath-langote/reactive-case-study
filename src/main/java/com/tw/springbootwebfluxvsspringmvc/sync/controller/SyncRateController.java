package com.tw.springbootwebfluxvsspringmvc.sync.controller;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.sync.service.SyncRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class SyncRateController {

    private SyncRateService rateService;

    public SyncRateController(SyncRateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/sync/rates")
    public List<Rate> getRates() throws InterruptedException {
        Thread.sleep(300);
        return rateService.getRates();
    }


}
