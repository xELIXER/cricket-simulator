package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.*;
import com.tekion.Cricket.util.Role;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ScorecardUtil {
    public static CricketScorecard initializeScorecard(Team team1, Team team2, CricketScorecard scorecard){
        TeamScore teamScorecard1 = new TeamScore();
        HashMap<Player, PlayerScore> t = new HashMap<>();
        for (Player x: team1.getPlayers()) { t.put(x, new PlayerScore() ); }
        for(Player x: team1.getPlayers()){
            if(x.getRole().equals(Role.BOWLER)) { t.get(x).setBallsToDeliver(100); }
        }
        teamScorecard1.setPlayerScores(t);
        scorecard.setTeam1Score(teamScorecard1);

        TeamScore teamScorecard2 = new TeamScore();
        HashMap<Player, PlayerScore> t2 = new HashMap<>();
        for (Player x: team2.getPlayers()) { t2.put(x, new PlayerScore()); }
        for(Player x: team2.getPlayers()){
            if(x.getRole().equals(Role.BOWLER)) { t2.get(x).setBallsToDeliver(100); }
        }
        teamScorecard2.setPlayerScores(t2);
        scorecard.setTeam2Score(teamScorecard2);

        return scorecard;
    }

    public static void wicket(Pair<Team, TeamScore> battingScorecard, Player curBatsman){
        battingScorecard.getValue().setWickets(
                battingScorecard.getValue().getWickets() + 1);
    }

    public static void incrementRuns(Pair<Team, TeamScore> battingScorecard, Player curBatsman, int runs) {
        try{
            battingScorecard.getValue().getPlayerScores().get(curBatsman).setTotalRuns(
                    battingScorecard.getValue().getPlayerScores().get(curBatsman).getTotalRuns() + runs);
            battingScorecard.getValue().setTotalRuns(
                    battingScorecard.getValue().getTotalRuns() + runs);
        }
        catch (Exception e){
            log.error("error while incrementing runs" ,e);
            throw e;
        }
    }

    public static void setBallsPlayed(Pair<Team, TeamScore> battingTeam, int totalBalls) {
        battingTeam.getValue().setTotalBalls(totalBalls);
        battingTeam.getValue().setOvers(totalBalls/6 + "." + totalBalls%6);
    }

    public static void incrementBoundary(Pair<Team, TeamScore> battingScorecard, Player curBatsman, int runs) {
        if(runs == 4)
            battingScorecard.getValue().getPlayerScores().get(curBatsman).setFours(
                    battingScorecard.getValue().getPlayerScores().get(curBatsman).getFours() + 1);
        else
            battingScorecard.getValue().getPlayerScores().get(curBatsman).setSixes(
                    battingScorecard.getValue().getPlayerScores().get(curBatsman).getSixes() + 1);
    }

    public static void incrementWicketsTaken(Pair<Team, TeamScore> bowlingScorecard, Player curBowler) {
        bowlingScorecard.getValue().getPlayerScores().get(curBowler).setWicketsTaken(
                bowlingScorecard.getValue().getPlayerScores().get(curBowler).getWicketsTaken() + 1);
    }

    public static void incrementRunsGiven(Pair<Team, TeamScore> bowlingScorecard, Player curBowler, int runs) {
        try{
            bowlingScorecard.getValue().getPlayerScores().get(curBowler).setRunsGiven(
                    bowlingScorecard.getValue().getPlayerScores().get(curBowler).getRunsGiven() + runs);
        }catch (Exception e){
            log.error("error while incrementing runs" ,e);
            throw e;
        }
    }

    public static int getWicketsFallen(Pair<Team, TeamScore> battingScorecard) {
        try{
            return battingScorecard.getValue().getWickets();
        }catch (Exception e){
            log.error("Error while getting number of wickets fallen");
            throw e;
        }
    }

    public static void ballDelivered(Player curBowler, Pair<Team, TeamScore> bowlingScorecard) {
        try{
            bowlingScorecard.getValue().getPlayerScores().get(curBowler).setBallsDelivered(
                    bowlingScorecard.getValue().getPlayerScores().get(curBowler).getBallsDelivered() + 1);
        }catch(Exception e){
            log.error("Error while updating the  number of Balls delivered by the current bowler");
            throw e;
        }
    }

    public static int getBallsDelivered(Team bowlingTeam, Player curBowler, Pair<Team, TeamScore> bowlingScorecard) {
        try{
            return bowlingScorecard.getValue().getPlayerScores().get(curBowler).getBallsDelivered();
        }catch(Exception e){
            log.error("Error while getting the number of balls delivered by the current bowler");
            throw e;
        }
    }
    public static int getBallsToDeliver(Team bowlingTeam, Player curBowler, Pair<Team, TeamScore> bowlingScorecard) {
        try{
            return bowlingScorecard.getValue().getPlayerScores().get(curBowler).getBallsToDeliver();
        }catch(Exception e){
            log.error("Error while getting the number of balls assigned to the current bowler");
            throw e;
        }
    }

    public static void saveBallsPlayed(Pair<Team, TeamScore> battingScorecard, Player curBatsman, int ballsPlayed) {
        try{
            battingScorecard.getValue().getPlayerScores().get(curBatsman).setBallsPlayed(ballsPlayed);
        }catch(Exception e){
            log.error("Error while saving the total balls played by the current batting team");
            throw e;
        }
    }

    public static void incrementMaidenOver(Pair<Team, TeamScore> bowlingScorecard, Player curBowler){
        try{
            bowlingScorecard.getValue().getPlayerScores().get(curBowler).setMaidenOver(
                    bowlingScorecard.getValue().getPlayerScores().get(curBowler).getMaidenOver() + 1);
        }catch (Exception e){
            log.error("Error while updating the number maiden over for the current bowler");
        }
    }
}
