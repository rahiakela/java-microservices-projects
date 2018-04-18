package com.spring.microservices.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.microservices.domain.GameStats;
import com.spring.microservices.domain.ScoreCard;
import com.spring.microservices.repository.BadgeCardRepository;
import com.spring.microservices.repository.ScoreCardRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;

import java.util.Collections;

public class GameServiceImplTest {
	
	private GameServiceImpl gameService;
	@Mock
	private ScoreCardRepository scoreCardRepository;
	@Mock
	private BadgeCardRepository badgeCardRepository;
	
	@Before
	public void setup() {
		//  With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
		gameService = new GameServiceImpl(scoreCardRepository, badgeCardRepository);
	}
	
	@Test
	public void processFirstCorrectAttemptTest() {
		
		Long userId = 1L;
		Long attemptId = 8L;
		int totalScore = 10;
		ScoreCard scoreCard = new ScoreCard(userId, attemptId);
		
		// given
		given(scoreCardRepository.getTotalScoreForUser(userId)).willReturn(totalScore);
		// this repository will return the just-won score card
		given(scoreCardRepository.findByUserIdOrderByScoreTimestampDesc(userId)).willReturn(Collections.singletonList(scoreCard));
		
		
		// when
		GameStats iteration = gameService.newAttemptForUser(userId, attemptId, true);
		
		// assert - should score one card and win the badge FIRST_WON
		assertThat(iteration.getScore()).isEqualTo(scoreCard.getScore());
		
	}
}
