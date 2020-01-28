package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.CricketMatch;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.service.MatchController;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class CrickeGametAPI {

    MatchController matchController = new MatchController();

    @RequestMapping("/match")
    public CricketMatch startMatch(){
        return matchController.setupMatch();
    }

    @RequestMapping("/")
    public String hello(){
        return "<body>" +
                "<p>hello from spring :D</p>" +
                "<p>Go to <code><b>localhost:8080/match</b></code> to start the cricket game.</p>" +
                "<p>or else click <a href='http://localhost:8080/match'>here</a></p>" +
                "</body>";
    }

    @RequestMapping("/scorecard")
    public CricketScorecard getScorecard(){
        return matchController.getScorecard();
    }

    @RequestMapping("/scorecard/team1")
    public TeamScore getTeam1Scores(){
        return matchController.getScorecard().getTeamScores().get(matchController.getTeam1());
    }

    @RequestMapping("/scorecard/team2")
    public TeamScore getTeam2Scores(){
        return matchController.getScorecard().getTeamScores().get(matchController.getTeam2());
    }
}
