package com.spring.microservices.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class RandomGeneratorServiceImplTest {
	
	private RandomGeneratorServiceImpl randomGeneratorServiceImpl;
	
	@Before
	public void setUp() {
		randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
	}
	
	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
		// when a good sample of randomly generated factors is generated
		List<Integer> randomFactors = IntStream.range(0, 1000)
				.map(i -> randomGeneratorServiceImpl.generateRandomFactor())
				.boxed()
				.collect(Collectors.toList());
		// then all of them should be between 11 and 100 because we want a middle-complexity calculation
		assertThat(randomFactors).containsExactlyElementsOf(
				IntStream.range(11, 100)
					.boxed()
					.collect(Collectors.toList())
				);
	}
}
