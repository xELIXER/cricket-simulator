package com.tekion.Cricket.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Data
@Document
@NoArgsConstructor
@Component
public class CricketScorecard {
    private String firstBatting;
    private String winner;
    private HashMap<Integer,TeamScore> teamScores;
    private Date date;

    public CricketScorecard(Team team1, Team team2){
        this.teamScores = getCricketScorecardInstance(team1,team2);
        date = new Date();
    }

    public HashMap<Integer,TeamScore> getCricketScorecardInstance(Team team1, Team team2){
        HashMap<Integer, TeamScore> temp = new HashMap<>();
        temp.put(team1.getId(), new TeamScore(team1.getName(), team1.getPlayers()));
        temp.put(team2.getId(), new TeamScore(team2.getName(), team2.getPlayers()));
        return temp;
    }
}
