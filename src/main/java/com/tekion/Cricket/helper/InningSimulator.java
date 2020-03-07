package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.*;
import com.tekion.Cricket.repo.WinLoseRecordRepo;
import com.tekion.Cricket.util.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class InningSimulator {

    public static void simulateInning(Team battingTeam, Team bowlingTeam, CricketMatch match, boolean isSecondInning){

        int overs = match.getOvers();
        CricketScorecard scorecard = match.getScorecard();
        ArrayList<Player> batsmen = TeamUtil.initializeBatsmen(battingTeam);
        ArrayList<Player> bowlers = TeamUtil.initializeBowlers(bowlingTeam);
        Player curBatsman = batsmen.get(0);
        Player curBowler = bowlers.get(0);
        int runsThisOver = 0, ballsPlayed = 0, i;
        HashMap<Integer, TeamScore> teamScores = scorecard.getTeamScores();

        for(i = 0; i < overs * 6; i++ ){

            if(ScorecardUtil.ballsLeftToDeliver(teamScores.get(bowlingTeam.getId()), curBowler.getId()) && bowlers.size() > 1){
                //Get the next bowler if the current bowler has already delivered the assigned number of balls.
                bowlers.remove(0);
                curBowler = bowlers.get(0);
            }

            if(ScorecardUtil.getWicketsFallen(teamScores.get(battingTeam.getId())) > 9 ||
                    (isSecondInning && teamScores.get(battingTeam.getId()).getTotalRuns() >  teamScores.get(bowlingTeam.getId()).getTotalRuns()) ){
                break;
            }

            int runs = MathUtil.generateScore( curBatsman.getRating() );
            ballsPlayed++;
            ScorecardUtil.ballDelivered(curBowler, teamScores.get(bowlingTeam.getId()));

            if(i%6 == 5 && runsThisOver == 0){
                // The value of i starts from 0 so every multiple of 5, it represents and end of an over.
                // If no runs are scored in an over, increment the maiden over count of the bowler.
                ScorecardUtil.incrementMaidenOver(teamScores.get(bowlingTeam.getId()), curBowler);
                runsThisOver = 0;

            }

            runsThisOver += runs;

            if(runs == -1){
                // -1 represents wicket fallen. Increase the number of wickets taken by the bowler and,
                // number of wickets lost by the current batting team.
                ScorecardUtil.saveBallsPlayed(teamScores.get(battingTeam.getId()), curBatsman, ballsPlayed);
                ballsPlayed = 0;
                if(batsmen.size()>1) batsmen.remove(0);
                curBatsman = batsmen.get(0);
                ScorecardUtil.incrementWicketForTeam(teamScores.get(battingTeam.getId()));
                ScorecardUtil.incrementWicketsTakenByBowler(teamScores.get(bowlingTeam.getId()), curBowler);
            }

            else{
                ScorecardUtil.incrementRunsScored(teamScores.get(battingTeam.getId()), curBatsman, runs);
                ScorecardUtil.incrementRunsGiven(teamScores.get(bowlingTeam.getId()), curBowler, runs);
            }

            if(runs == 4 || runs == 6){
                ScorecardUtil.incrementBoundary(teamScores.get(battingTeam.getId()), curBatsman, runs);
            }
        }
        ScorecardUtil.setBallsPlayed(teamScores.get(battingTeam.getId()), i);
        if( isSecondInning && teamScores.get(battingTeam.getId()).getTotalRuns() > teamScores.get(bowlingTeam.getId()).getTotalRuns() ){
            scorecard.setWinner(battingTeam.getName());
            scorecard.getTeamScores().get(battingTeam.getId()).setVerdict("WON");
            scorecard.getTeamScores().get(bowlingTeam.getId()).setVerdict("LOST");
        }
        else if(isSecondInning && teamScores.get(battingTeam.getId()).getTotalRuns() < teamScores.get(bowlingTeam.getId()).getTotalRuns()){
            scorecard.setWinner(bowlingTeam.getName());
            scorecard.getTeamScores().get(bowlingTeam.getId()).setVerdict("WON");
            scorecard.getTeamScores().get(battingTeam.getId()).setVerdict("LOST");
        }
        else if ( isSecondInning && teamScores.get(battingTeam.getId()).getTotalRuns() == teamScores.get(bowlingTeam.getId()).getTotalRuns() ){
            scorecard.setWinner("DRAW");
            scorecard.getTeamScores().get(bowlingTeam.getId()).setVerdict("DRAW");
            scorecard.getTeamScores().get(battingTeam.getId()).setVerdict("DRAW");
        }
    }
}
