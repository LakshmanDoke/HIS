package com.his;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.his.service.impl.CaseUserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "36000")
public class HisApplicationTests {
	@Autowired
	CaseUserServiceImpl caseUserServiceImpl;
	@Autowired
	private WebTestClient webTestClient;

	@Before
	public void setUp() {
		webTestClient = webTestClient.mutate().responseTimeout(Duration.ofMillis(36000)).build();
	}

	@Test
	public void testGetMovieById() {
		webTestClient.get().uri("/rest/authenticate/{ssnid}", "525835271").accept(MediaType.APPLICATION_JSON).exchange()
				.expectStatus().isOk().expectBody()
				.consumeWith(response -> Assertions.assertThat(response.getResponseBody()).isNotNull());
	}
}
