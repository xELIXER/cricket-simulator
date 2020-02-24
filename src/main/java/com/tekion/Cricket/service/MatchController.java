package com.tekion.Cricket.service;


import com.tekion.Cricket.beans.CricketMatch;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.tekion.Cricket.util.MathUtil.toss;
import static com.tekion.Cricket.helper.InningSimulator.simulateInning;

@Slf4j
@Service
public class MatchController {

    public CricketScorecard conductMatch(){
        CricketMatch match = new CricketMatch("IND v AUS ODI", "M Chinnaswamy Stadium",
                new Date(), null, null, 50, "INDIA", "AUSTRALIA");
        if(toss()){
            beginMatch(match.getTeam1(),match.getTeam2(), match, match.getScorecard());
            match.getScorecard().setFirstBatting(match.getTeam1().getName());
        }
        else{
            beginMatch(match.getTeam2(),match.getTeam1(), match, match.getScorecard());
            match.getScorecard().setFirstBatting(match.getTeam2().getName());

        }
        return match.getScorecard();
    }
    void beginMatch(Team team1, Team team2, CricketMatch match, CricketScorecard scorecard){
        match.setFirst(team1);
        match.setSecond(team2);
        simulateInning(team1, team2, match, false);
        simulateInning(team2, team1, match, true);
    }
}
