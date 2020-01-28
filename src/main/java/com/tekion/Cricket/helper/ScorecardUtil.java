package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.*;
import com.tekion.Cricket.util.Role;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ScorecardUtil {
//    public static CricketScorecard initializeScorecard(Team team1, Team team2, CricketScorecard scorecard){
//        TeamScore teamScorecard1 = new TeamScore();
//        HashMap<Player, PlayerScore> t = new HashMap<>();
//        for (Player x: team1.getPlayers()) { t.put(x, new PlayerScore() ); }
//        for(Player x: team1.getPlayers()){
//            if(x.getRole().equals(Role.BOWLER)) { t.get(x).setBallsToDeliver(100); }
//        }
//        teamScorecard1.setPlayerScores(t);
//        scorecard.setTeam1Score(teamScorecard1);
//
//        TeamScore teamScorecard2 = new TeamScore();
//        HashMap<Player, PlayerScore> t2 = new HashMap<>();
//        for (Player x: team2.getPlayers()) { t2.put(x, new PlayerScore()); }
//        for(Player x: team2.getPlayers()){
//            if(x.getRole().equals(Role.BOWLER)) { t2.get(x).setBallsToDeliver(100); }
//        }
//        teamScorecard2.setPlayerScores(t2);
//        scorecard.setTeam2Score(teamScorecard2);
//
//        return scorecard;
//    }

    public static void wicket(TeamScore battingScorecard){
        battingScorecard.setWickets(
                battingScorecard.getWickets() + 1);
    }

    public static void incrementRuns(TeamScore battingScorecard, Player curBatsman, int runs) {
        try{
            battingScorecard.getPlayerScores().get(curBatsman).setTotalRuns(
                    battingScorecard.getPlayerScores().get(curBatsman).incrementRuns(runs));
            battingScorecard.setTotalRuns(
                    battingScorecard.getTotalRuns() + runs);
        }
        catch (Exception e){
            log.error("error while incrementing runs" ,e);
            throw e;
        }
    }

    public static void setBallsPlayed(TeamScore battingTeam, int totalBalls) {
        battingTeam.setTotalBalls(totalBalls);
        battingTeam.setOvers(totalBalls/6 + "." + totalBalls%6);
    }

    public static void incrementBoundary(TeamScore battingScorecard, Player curBatsman, int runs) {
        if(runs == 4)
            battingScorecard.getPlayerScores().get(curBatsman).setFours(
                    battingScorecard.getPlayerScores().get(curBatsman).getFours() + 1);
        else
            battingScorecard.getPlayerScores().get(curBatsman).setSixes(
                    battingScorecard.getPlayerScores().get(curBatsman).getSixes() + 1);
    }

    public static void incrementWicketsTaken(TeamScore bowlingScorecard, Player curBowler) {
        bowlingScorecard.getPlayerScores().get(curBowler).setWicketsTaken(
                bowlingScorecard.getPlayerScores().get(curBowler).getWicketsTaken() + 1);
    }

    public static void incrementRunsGiven(TeamScore bowlingScorecard, Player curBowler, int runs) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler).setRunsGiven(
                    bowlingScorecard.getPlayerScores().get(curBowler).getRunsGiven() + runs);
        }catch (Exception e){
            log.error("error while incrementing runs" ,e);
            throw e;
        }
    }

    public static int getWicketsFallen(TeamScore battingScorecard) {
        try{
            return battingScorecard.getWickets();
        }catch (Exception e){
            log.error("Error while getting number of wickets fallen");
            throw e;
        }
    }

    public static void ballDelivered(Player curBowler, TeamScore bowlingScorecard) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler).setBallsDelivered(
                    bowlingScorecard.getPlayerScores().get(curBowler).getBallsDelivered() + 1);
        }catch(Exception e){
            log.error("Error while updating the  number of Balls delivered by the current bowler");
            throw e;
        }
    }

    public static int getBallsDelivered(Team bowlingTeam, Player curBowler, TeamScore bowlingScorecard) {
        try{
            return bowlingScorecard.getPlayerScores().get(curBowler).getBallsDelivered();
        }catch(Exception e){
            log.error("Error while getting the number of balls delivered by the current bowler");
            throw e;
        }
    }

    public static int getBallsToDeliver(Team bowlingTeam, Player curBowler, TeamScore bowlingScorecard) {
        try{
            return bowlingScorecard.getPlayerScores().get(curBowler).getBallsToDeliver();
        }catch(Exception e){
            log.error("Error while getting the number of balls assigned to the current bowler");
            throw e;
        }
    }

    public static void saveBallsPlayed(TeamScore battingScorecard, Player curBatsman, int ballsPlayed) {
        try{
            battingScorecard.getPlayerScores().get(curBatsman).setBallsPlayed(ballsPlayed);
        }catch(Exception e){
            log.error("Error while saving the total balls played by the current batting team");
            throw e;
        }
    }

    public static void incrementMaidenOver(TeamScore bowlingScorecard, Player curBowler){
        try{
            bowlingScorecard.getPlayerScores().get(curBowler).setMaidenOver(
                    bowlingScorecard.getPlayerScores().get(curBowler).getMaidenOver() + 1);
        }catch (Exception e){
            log.error("Error while updating the number maiden over for the current bowler");
        }
    }
}
