package com.tekion.Cricket.beans;

import lombok.Data;

import java.util.HashMap;

@Data
public class CricketScorecard {
    private String firstBatting;
    private String winner;
    private final HashMap<Team,TeamScore> teamScores;

    public CricketScorecard(Team team1, Team team2){
        this.teamScores = getCricketScorecardInstance(team1,team2);
    }

    public HashMap<Team,TeamScore> getCricketScorecardInstance(Team team1, Team team2){
        HashMap<Team, TeamScore> temp = new HashMap<>();
        temp.put(team1, new TeamScore(team1.getPlayers()));
        temp.put(team2, new TeamScore(team2.getPlayers()));
        return temp;
    }
}
