package com.tekion.Cricket.service;


import com.tekion.Cricket.beans.*;
import com.tekion.Cricket.helper.PlayMatch;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;

import static com.tekion.Cricket.util.MathUtil.toss;

@Data
@Slf4j
public class MatchController {
    private final Team team1 = new Team("INDIA");
    private final Team team2 = new Team("AUSTRALIA");
    private final CricketScorecard scorecard = new CricketScorecard(team1,team2);


    public CricketMatch setupMatch(){
        HashMap<Team, TeamScore> teamScores = scorecard.getTeamScores();
        CricketMatch match = new CricketMatch("IND v AUS ODI", "M Chinnaswamy Stadium",  new Date(), null, null, 50);

        if(toss()){
            playMatch(team1,team2, match, teamScores);
        }

        else{
            playMatch(team2,team1, match, teamScores);
        }

        return match;
    }

    void playMatch(Team team1, Team team2, CricketMatch match, HashMap<Team, TeamScore> teamScores){
        match.setFirst(team1);
        match.setSecond(team2);
        PlayMatch.play(team1, team2, match.getOvers(), teamScores);
        PlayMatch.play(team2, team1, match.getOvers(), teamScores);
    }
}
