package com.tekion.Cricket.service;


import com.tekion.Cricket.beans.CricketMatch;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.helper.MatchControllerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

import static com.tekion.Cricket.util.MathUtil.toss;

@Slf4j
@Service
public class MatchController {

    public CricketScorecard conductMatch(){
        CricketMatch match = new CricketMatch("IND v AUS ODI", "M Chinnaswamy Stadium",  new Date(), null, null, 50,
                "INDIA", "AUSTRALIA");

        if(toss()){
            playMatch(match.getTeam1(),match.getTeam2(), match, match.getScorecard().getTeamScores());
        }
        else{
            playMatch(match.getTeam2(),match.getTeam1(), match, match.getScorecard().getTeamScores());
        }

        return match.getScorecard();
    }

    void playMatch(Team team1, Team team2, CricketMatch match, HashMap<Team, TeamScore> teamScores){
        match.setFirst(team1);
        match.setSecond(team2);
        MatchControllerUtil.play(team1, team2, match.getOvers(), teamScores);
        MatchControllerUtil.play(team2, team1, match.getOvers(), teamScores);
    }
}
