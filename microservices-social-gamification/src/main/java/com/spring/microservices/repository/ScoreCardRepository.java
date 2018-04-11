package com.spring.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.microservices.domain.LeaderBoardRow;
import com.spring.microservices.domain.ScoreCard;

/**
* Handles CRUD operations with ScoreCards
*/
public interface ScoreCardRepository extends CrudRepository<ScoreCard, Long> {
	/**
	* Gets the total score for a given user, being the sum of the scores of all his ScoreCards.
	* @param userId the id of the user for which the total score should be retrieved
	* @return the total score for the given user
	*/
	@Query("SELECT SUM(sc.score) FROM com.spring.microservices.domain.ScoreCard sc WHERE sc.userId = :userId GROUP BY sc.userId")
	int getTotalScoreForUser(@Param("userId") final Long userId);
	
	/**
	* Retrieves a list of {@link LeaderBoardRow}s representing the Leader Board of users and their total score.
	* @return the leader board, sorted by highest score first.
	*/
	@Query("SELECT NEW com.spring.microservices.domain.LeaderBoardRow(sc.userId, SUM(sc.score)) FROM com.spring.microservices.domain.ScoreCard sc GROUP BY sc.userId ORDER BY SUM(sc.score) DESC")
	List<LeaderBoardRow> findFirst10();
	
	/**
	* Retrieves all the ScoreCards for a given user,identified by his user id.
	* @param userId the id of the user
	* @return a list containing all the ScoreCards for the given user, sorted by most recent.
	*/
	List<ScoreCard> findByUserIdOrderByScoreTimestampDesc(final Long userId);
}
