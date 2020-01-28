package com.tekion.Cricket.beans;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CricketScorecard {
    private final HashMap<Team,TeamScore> teamScores;

    public CricketScorecard(Team t1, Team t2){
        this.teamScores = getCricketScorecardInstance(t1,t2);
    }

    public HashMap<Team,TeamScore> getCricketScorecardInstance(Team team1, Team team2){
        HashMap<Team, TeamScore> temp = new HashMap<>();
        temp.put(team1,new TeamScore(team1.getPlayers()));
        temp.put(team2,new TeamScore(team2.getPlayers()));
        return temp;
    }
}
