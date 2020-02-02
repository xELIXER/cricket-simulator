package com.tekion.Cricket.service;


import com.tekion.Cricket.beans.CricketMatch;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.beans.TeamScore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

import static com.tekion.Cricket.util.MathUtil.toss;
import static com.tekion.Cricket.helper.MatchControllerUtil.play;

@Slf4j
@Service
public class MatchController {

    public CricketScorecard conductMatch(){
        CricketMatch match = new CricketMatch("IND v AUS ODI", "M Chinnaswamy Stadium",
                new Date(), null, null, 50, "INDIA", "AUSTRALIA");
        if(toss()){
            beginMatch(match.getTeam1(),match.getTeam2(), match, match.getScorecard().getTeamScores());
        }
        else{
            beginMatch(match.getTeam2(),match.getTeam1(), match, match.getScorecard().getTeamScores());
        }
        return match.getScorecard();
    }
    void beginMatch(Team team1, Team team2, CricketMatch match, HashMap<Team, TeamScore> teamScores){
        match.setFirst(team1);
        match.setSecond(team2);
        play(team1, team2, match.getOvers(), teamScores, false);
        play(team2, team1, match.getOvers(), teamScores, true);
        if(teamScores.get(team1).getTotalRuns() > teamScores.get(team2).getTotalRuns()){
            match.getScorecard().setWinner(team1.getName());
        }
        else{
            match.getScorecard().setWinner(team2.getName());
        }
    }
}
