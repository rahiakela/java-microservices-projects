package com.spring.microservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.microservices.domain.Badge;
import com.spring.microservices.domain.BadgeCard;
import com.spring.microservices.domain.GameStats;
import com.spring.microservices.domain.LeaderBoardRow;
import com.spring.microservices.domain.ScoreCard;
import com.spring.microservices.repository.BadgeCardRepository;
import com.spring.microservices.repository.ScoreCardRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GameServiceImpl implements GameService{
	
	private ScoreCardRepository scoreCardRepository;
	private BadgeCardRepository badgeCardRepository;
	
	public GameServiceImpl(ScoreCardRepository scoreCardRepository, BadgeCardRepository badgeCardRepository) {
		this.scoreCardRepository = scoreCardRepository;
		this.badgeCardRepository = badgeCardRepository;
	}

	@Override
	public GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct) {
		// For the first version we'll give points only if it's correct
		if (correct) {
			ScoreCard scoreCard = new ScoreCard(userId, attemptId);
			scoreCardRepository.save(scoreCard);
			log.info("User with id {} scored {} points for attempt id {}", userId, scoreCard.getScore(), attemptId);
			List<BadgeCard> badgeCards =  
		}
		return null;
	}

	@Override
	public GameStats retrieveStatsForUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* Checks the total score and the different score cards obtained
	* to give new badges in case their conditions are met.
	*/
	private List<BadgeCard> processForBadges(final Long userId, final Long attemptId) {
		List<BadgeCard> badgeCards = new ArrayList();
		
		int totalScore = scoreCardRepository.getTotalScoreForUser(userId);
		log.info("New score for user {} is {}", userId, totalScore);
		
		List<ScoreCard> scoreCardList = scoreCardRepository.findByUserIdOrderByScoreTimestampDesc(userId);
		List<BadgeCard> badgeCardList = badgeCardRepository.findByUserIdOrderByBadgeTimestampDesc(userId);
		
		// Badges depending on score
		
	}
	
	/**
	* Convenience method to check the current score against
	* the different thresholds to gain badges.
	* It also assigns badge to user if the conditions are met.
	*/
	private Optional<BadgeCard> checkAndGiveBadgeBasedOnScore(final List<BadgeCard> badgeCards, final Badge badge, final int score, final int scoreThreshold, final Long userId) {
		if (score >= scoreThreshold && !)
	}
	
	/**
	* Checks if the passed list of badges includes the one being checked
	*/
	private boolean containsBadge(final List<BadgeCard> badgeCards, final Badge badge) {
		return badgeCards.stream().anyMatch(b -> b.getBadge().equals(badge));
	}
}
