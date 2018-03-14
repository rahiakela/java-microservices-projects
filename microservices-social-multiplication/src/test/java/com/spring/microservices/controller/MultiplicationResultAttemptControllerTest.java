package com.spring.microservices.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.microservices.controller.MultiplicationResultAttemptController.ResultResponse;
import com.spring.microservices.domain.Multiplication;
import com.spring.microservices.domain.MultiplicationResultAttempt;
import com.spring.microservices.domain.User;
import com.spring.microservices.service.MultiplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {
	
	@MockBean
	private MultiplicationService multiplicationService;
	@Autowired
	private MockMvc mvc;
	
	// This object will be magically initialized by the initFields method below.
	private JacksonTester<MultiplicationResultAttempt> jsonResult;
	private JacksonTester<ResultResponse> jsonResponse;
	
	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}
	
	@Test 
	public void postResultReturnCorrect() throws Exception {
		genericParameterizedTest(false);
	}
	
	@Test
	public void postResultReturnNotCorrect() throws Exception {
		genericParameterizedTest(true);
	}
	
	void genericParameterizedTest(final boolean correct) throws Exception {
		
		// given (remember we're not testing here the service itself)
		given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class)))
				.willReturn(correct);
		User user = new User("Rahi");
		Multiplication multiplication = new Multiplication(50,70);
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500, false);
		
		// when
		MockHttpServletResponse response = mvc.perform(post("/results").contentType(MediaType.APPLICATION_JSON).content(jsonResult.write(attempt).getJson()))
						.andReturn()
						.getResponse();
		
		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonResult.write(new MultiplicationResultAttempt(attempt.getUser(), attempt.getMultiplication(),attempt.getResultAttempt(),correct)).getJson());
	}
}
