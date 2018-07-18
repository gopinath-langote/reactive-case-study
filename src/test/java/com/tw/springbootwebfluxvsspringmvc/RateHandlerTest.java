package com.tw.springbootwebfluxvsspringmvc;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import com.tw.springbootwebfluxvsspringmvc.reactive.service.RateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class RateHandlerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void contextLoads() {
		assertThat(webTestClient).isNotNull();
	}


	@Before
	public void setup(){
		RateService rateServiceMock = mock(RateService.class);
		when(rateServiceMock.getRates("TAJ")).thenReturn(Flux.just(
				new Rate("GOIBIBO SUPER DELUX", (double) 1200)

		));
//		webTestClient = WebTestClient
//				.bindToController(new RateController(rateServiceMock))
//				.build();
	}

	@Test
	public void shouldGetRatesAsFlux() {

		webTestClient.get().uri("/reactive/rates/TAJ", 2).accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Rate.class);

	}

	@Test
	public void shouldGetExceptionForWrongHotelCode(){
		webTestClient.get().uri("/reactive/rates/TAJ123", 2).accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isBadRequest();

	}

}