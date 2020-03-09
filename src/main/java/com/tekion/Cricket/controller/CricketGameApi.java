package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.repo.CricketScorecardRepo;
import com.tekion.Cricket.repo.TeamScoreRepo;
import com.tekion.Cricket.service.MatchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class CricketGameApi {
    
    @Autowired
    private MatchController matchController;

    @Autowired
    private CricketScorecardRepo cricketScorecardRepo;

    @Autowired
    private TeamScoreRepo teamScoreRepo;


    @PostMapping(value = "/match")
    public CricketScorecard conductMatch(){
        return matchController.conductMatch();
    }

    @PostMapping("/")
    public String hello(){
        return "<body>" +
                "<p>hello from spring :D</p>" +
                "<p>Go to <code><b>localhost:8080/match</b></code> to start the cricket game.</p>" +
                "<p>or else click <a href='http://localhost:8080/match'>here</a></p>" +
                "</body>";
    }

}
