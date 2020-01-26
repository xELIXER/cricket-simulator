package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.util.GenerateRuns;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class PlayMatch {
    public static void play(Team battingTeam, Team bowlingTeam, int overs,
                            Pair<Team, TeamScore> battingScorecard, Pair<Team, TeamScore> bowlingScorecard){

        ArrayList<Player> batsmen = TeamUtil.initializeBatsmen(battingTeam);
        ArrayList<Player> bowlers = TeamUtil.initializeBowlers(bowlingTeam);
        Player curBatsman = batsmen.get(0);
        Player curBowler = bowlers.get(0);
        int runsThisOver = 0, ballsPlayed = 0, i;

        for(i = 0; i < overs * 6; i++ ){
            if(ScorecardUtil.getBallsDelivered(bowlingTeam, curBowler, bowlingScorecard) >=
                    ScorecardUtil.getBallsToDeliver(bowlingTeam, curBowler, bowlingScorecard)){
                bowlers.remove(0);
                curBowler = bowlers.get(0);
            }
            if(ScorecardUtil.getWicketsFallen(battingScorecard) > 9){
                break;
            }
            int runs = GenerateRuns.betterRandom( curBatsman.getRating() );
            ballsPlayed++;
            ScorecardUtil.ballDelivered(curBowler, bowlingScorecard);
            if(i%6 == 5 && runsThisOver == 0){
                // The value of i starts from 0 so every multiple of 5, it represents and end of an over
                ScorecardUtil.incrementMaidenOver(bowlingScorecard, curBowler);
                runsThisOver = 0;
            }
            runsThisOver += runs;
            if(runs == -1){
                ScorecardUtil.saveBallsPlayed(battingScorecard, curBatsman, ballsPlayed);
                ballsPlayed = 0;
                if(batsmen.size()>1) batsmen.remove(0);
                curBatsman = batsmen.get(0);
                ScorecardUtil.wicket(battingScorecard, curBowler);
                ScorecardUtil.incrementWicketsTaken(bowlingScorecard, curBowler);
            }
            else{
                ScorecardUtil.incrementRuns(battingScorecard, curBatsman, runs);
                ScorecardUtil.incrementRunsGiven(bowlingScorecard, curBowler, runs);
            }

            if(runs == 4 || runs == 6){
                ScorecardUtil.incrementBoundary(battingScorecard, curBatsman, runs);
            }
        }
        ScorecardUtil.setBallsPlayed(battingScorecard, i);
    }
}
