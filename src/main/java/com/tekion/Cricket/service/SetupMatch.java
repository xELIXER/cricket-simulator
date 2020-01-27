package com.tekion.Cricket.service;


import com.tekion.Cricket.helper.PlayMatch;
import javafx.util.Pair;
import com.tekion.Cricket.beans.CricketMatch;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.helper.ScorecardUtil;
import com.tekion.Cricket.helper.TeamUtil;
import com.tekion.Cricket.util.Toss;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
public class SetupMatch {
    private static Team team1;
    private static Team team2;
    private static CricketScorecard scorecard;

    public static CricketScorecard getScorecard() {
        return scorecard;
    }

    public static Team getTeam1() {
        return team1;
    }

    public static Team getTeam2() {
        return team2;
    }

    public CricketMatch startMatch(){
        team1 = TeamUtil.initializeTeam1("INDIA");
        team2 = TeamUtil.initializeTeam2("AUSTRALIA");
        scorecard = new CricketScorecard();

        CricketMatch indvAusODI = new CricketMatch("IND v AUS ODI", "M Chinnaswamy Stadium",  new Date(),
                                    null, null, 50);
        if(Toss.toss()){
            ScorecardUtil.initializeScorecard(team1, team2, scorecard);
            Pair<Team, TeamScore> firstTeamScorecard  = new Pair<>(team1, scorecard.getTeam1Score());
            Pair<Team, TeamScore> secondTeamScorecard = new Pair<>(team2, scorecard.getTeam2Score());
            indvAusODI.setFirst(team1);
            indvAusODI.setSecond(team2);
            PlayMatch.play(team1, team2, indvAusODI.getOvers(), firstTeamScorecard, secondTeamScorecard);
            PlayMatch.play(team2, team1, indvAusODI.getOvers(), secondTeamScorecard, firstTeamScorecard);
        }
        else{
            ScorecardUtil.initializeScorecard(team2, team1, scorecard);
            Pair<Team, TeamScore> firstTeamScorecard  = new Pair<>(team2, scorecard.getTeam1Score());
            Pair<Team, TeamScore> secondTeamScorecard = new Pair<>(team1, scorecard.getTeam2Score());
            indvAusODI.setFirst(team2);
            indvAusODI.setSecond(team1);
            PlayMatch.play(team2, team1, indvAusODI.getOvers(), firstTeamScorecard, secondTeamScorecard);
            PlayMatch.play(team1, team2, indvAusODI.getOvers(), secondTeamScorecard, firstTeamScorecard);
        }
        return indvAusODI;
    }
}