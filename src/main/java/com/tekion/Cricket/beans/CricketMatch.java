package com.tekion.Cricket.beans;

import lombok.Data;

import java.util.Date;

@Data
public class CricketMatch extends Match {
    private int overs;
    private final Team team1;
    private final Team team2;
    private final CricketScorecard scorecard;

    public CricketMatch(String name, String groundName, Date date, Team first, Team second, int overs, String team1Name,
                        String team2Name) {
        super(name, groundName, date,first,second);
        this.overs = overs;
        this.team1 = new Team(team1Name);
        this.team2 = new Team(team2Name);
        this.scorecard = new CricketScorecard(team1,team2);
    }

}
