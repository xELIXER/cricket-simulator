package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.service.SetupMatch;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class ScorecardController {
    @RequestMapping("/scorecard")
    public CricketScorecard getScorecard(){
        return new SetupMatch().getScorecard();
    }

    @RequestMapping("/scorecard/team1")
    public TeamScore getTeamScore1(){ return new SetupMatch().getScorecard().getTeam1Score(); }

    @RequestMapping("/scorecard/team2")
    public TeamScore getTeamScore2(){ return new SetupMatch().getScorecard().getTeam2Score(); }
}
