package com.spring.microservices.service;

import org.springframework.stereotype.Service;

import com.spring.microservices.domain.LeaderBoardRow;
import com.spring.microservices.repository.ScoreCardRepository;

import java.util.List;

@Service
class LeaderBoardServiceImpl implements LeaderBoardService {

    private ScoreCardRepository scoreCardRepository;

    LeaderBoardServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        return scoreCardRepository.findFirst10();
    }
}
