package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.util.MathUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class PlayMatch {
    public static void play(Team battingTeam, Team bowlingTeam, int overs,
                            Map<Team, TeamScore> teamScores){

        ArrayList<Player> batsmen = TeamUtil.initializeBatsmen(battingTeam);
        ArrayList<Player> bowlers = TeamUtil.initializeBowlers(bowlingTeam);
        Player curBatsman = batsmen.get(0);
        Player curBowler = bowlers.get(0);
        int runsThisOver = 0, ballsPlayed = 0, i;

        for(i = 0; i < overs * 6; i++ ){
            if(ScorecardUtil.getBallsDelivered(curBowler, teamScores.get(bowlingTeam)) >=
                    ScorecardUtil.getBallsToDeliver(curBowler, teamScores.get(bowlingTeam)) && bowlers.size() > 1){
                //Get the next bowler if the current bowler has already delivered the assigned number of balls.
                bowlers.remove(0);
                curBowler = bowlers.get(0);
            }
            if(ScorecardUtil.getWicketsFallen(teamScores.get(battingTeam)) > 9){
                break;
            }
            int runs = MathUtil.betterRandom( curBatsman.getRating() );
            ballsPlayed++;
            ScorecardUtil.ballDelivered(curBowler, teamScores.get(bowlingTeam));
            if(i%6 == 5 && runsThisOver == 0){
                // The value of i starts from 0 so every multiple of 5, it represents and end of an over.
                // If no runs are scored in an over, increment the maiden over count of the bowler.
                ScorecardUtil.incrementMaidenOver(teamScores.get(bowlingTeam), curBowler);
                runsThisOver = 0;
            }
            runsThisOver += runs;
            if(runs == -1){
                // -1 represents wicket fallen. Increase the number of wickets taken by the bowler and,
                // number of wickets lost by the current batting team.
                ScorecardUtil.saveBallsPlayed(teamScores.get(battingTeam), curBatsman, ballsPlayed);
                ballsPlayed = 0;
                if(batsmen.size()>1) batsmen.remove(0);
                curBatsman = batsmen.get(0);
                ScorecardUtil.wicket(teamScores.get(battingTeam));
                ScorecardUtil.incrementWicketsTaken(teamScores.get(bowlingTeam), curBowler);
            }
            else{
                ScorecardUtil.incrementRuns(teamScores.get(battingTeam), curBatsman, runs);
                ScorecardUtil.incrementRunsGiven(teamScores.get(bowlingTeam), curBowler, runs);
            }

            if(runs == 4 || runs == 6){
                ScorecardUtil.incrementBoundary(teamScores.get(battingTeam), curBatsman, runs);
            }
        }
        ScorecardUtil.setBallsPlayed(teamScores.get(battingTeam), i);
    }
}
