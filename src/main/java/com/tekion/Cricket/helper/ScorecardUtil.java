package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.TeamScore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScorecardUtil {
    public static void wicket(TeamScore battingScorecard){
        battingScorecard.incrementWickets();
    }

    public static void incrementRuns(TeamScore battingScorecard, Player curBatsman, int runs) {
        try{
            battingScorecard.getPlayerScores().get(curBatsman).incrementRuns(runs);
            battingScorecard.incrementRuns(runs);
        }
        catch (Exception e){
            log.error("error while incrementing runs");
            throw e;
        }
    }

    public static void setBallsPlayed(TeamScore battingTeam, int totalBalls) {
        battingTeam.setTotalBalls(totalBalls);
        battingTeam.setOvers(totalBalls/6 + "." + totalBalls%6);
    }

    public static void incrementBoundary(TeamScore battingScorecard, Player curBatsman, int runs) {
        if(runs == 4)
            try{
                battingScorecard.getPlayerScores().get(curBatsman).incrementFours();
            }catch (Exception e){
                log.error("Error while incrementing Fours");
                throw e;
            }
        else
            try{
                battingScorecard.getPlayerScores().get(curBatsman).incrementSixes();
            }catch (Exception e){
                log.error("Error while incrementing Sixes");
                throw e;
            }
    }

    public static void incrementWicketsTaken(TeamScore bowlingScorecard, Player curBowler) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler).incrementWicketTaken();
        }catch(Exception e){
            log.error("Error while incrementing wickets taken by the current bowler");
            throw e;
        }
    }

    public static void incrementRunsGiven(TeamScore bowlingScorecard, Player curBowler, int runs) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler).incrementRunsGiven( runs );
            if(runs == 0)
                bowlingScorecard.getPlayerScores().get(curBowler).incrementDotBalls();
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
            bowlingScorecard.getPlayerScores().get(curBowler).incrementBallsDelivered();
        }catch(Exception e){
            log.error("Error while updating the  number of Balls delivered by the current bowler");
            throw e;
        }
    }

    public static int getBallsDelivered(Player curBowler, TeamScore bowlingScorecard) {
        try{
            return bowlingScorecard.getPlayerScores().get(curBowler).getBallsDelivered();
        }catch(Exception e){
            log.error("Error while getting the number of balls delivered by the current bowler");
            throw e;
        }
    }

    public static int getBallsToDeliver(Player curBowler, TeamScore bowlingScorecard) {
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
            bowlingScorecard.getPlayerScores().get(curBowler).incrementMaidenOver();
        }catch (Exception e){
            log.error("Error while updating the number maiden over for the current bowler");
            throw e;
        }
    }
}
