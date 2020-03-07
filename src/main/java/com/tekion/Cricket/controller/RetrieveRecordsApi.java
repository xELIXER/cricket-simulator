package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.repo.CricketScorecardRepo;
import com.tekion.Cricket.repo.TeamScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/get")
public class RetrieveRecordsApi {

    @Autowired
    private CricketScorecardRepo cricketScorecardRepo;
    @Autowired
    private TeamScoreRepo teamScoreRepo;

    @PostMapping("/all")
    public List<CricketScorecard> getAllMatchRecords() {
        return cricketScorecardRepo.findAll(Sort.by(Sort.Order.desc("date")));
    }

    @PostMapping("/{teamName}")
    public List<TeamScore> getAllRecordsOfTeam (@PathVariable("teamName") String teamName) {
        return teamScoreRepo.findAllByName(teamName.toUpperCase());
    }
}
