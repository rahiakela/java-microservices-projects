package com.spring.microservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.domain.LeaderBoardRow;
import com.spring.microservices.service.LeaderBoardService;

/**
* This class implements a REST API for the Gamification LeaderBoard service.
*/
@RestController
@RequestMapping("/leaders")
public class LeaderBoardController {
	
	private final LeaderBoardService leaderBoardService;

	public LeaderBoardController(final LeaderBoardService leaderBoardService) {
		this.leaderBoardService = leaderBoardService;
	}
	
	@GetMapping
	public List<LeaderBoardRow> getLeaderBoard() {
		return leaderBoardService.getCurrentLeaderBoard();
	}
}
