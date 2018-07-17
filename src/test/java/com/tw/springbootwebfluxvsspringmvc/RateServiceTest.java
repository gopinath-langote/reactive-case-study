package com.tw.springbootwebfluxvsspringmvc;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RateServiceTest {

    private RateService rateService;

    private List<Rate> rateList = Arrays.asList(
            new Rate("AGODA SUPER DELUX", (double) 1200),
            new Rate("MMT SUPER DELUX", (double) 1240),
            new Rate("GOIBIBO SUPER DELUX", (double) 1210)
    );

    @Before
    public void setup() {
        AgodaMockService agodaMockService = mock(AgodaMockService.class);
        MakeMyTripMockService makemyTripMockService = mock(MakeMyTripMockService.class);
        GoIbiboMockService goibiboMockService = mock(GoIbiboMockService.class);


        when(agodaMockService.getResponse()).thenReturn(Flux.just(
                rateList.get(0)
        ));
        when(makemyTripMockService.getResponse()).thenReturn(Flux.just(
                rateList.get(1)
        ));
        when(goibiboMockService.getResponse()).thenReturn(Flux.just(
                rateList.get(2)
        ));

        rateService = new RateService(agodaMockService,makemyTripMockService,goibiboMockService);
    }

    @Test
    public void shouldGetCombinedRatesAsFlux() {

        StepVerifier.create(rateService.getRates(hotel_code).collectList())
                .expectNextMatches(rates -> {
                    assertTrue(rates.containsAll(rateList));
                    return true;
                })
                .expectComplete()
                .verify();

    }

}
