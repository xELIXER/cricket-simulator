package com.tekion.Cricket.helper;

import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.TeamScore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScorecardUtil {
    public static void incrementWicketForTeam(TeamScore battingScorecard){
        battingScorecard.incrementWickets();
    }

    public static void incrementRunsScored(TeamScore battingScorecard, Player curBatsman, int runs) {
        try{
            battingScorecard.getPlayerScores().get(curBatsman.getId()).incrementRuns(runs);
            battingScorecard.incrementRuns(runs);
        }
        catch (Exception e){
            log.error("error while incrementing runs", e);
        }
    }

    public static void setBallsPlayed(TeamScore battingTeam, int totalBalls) {
        battingTeam.setTotalBalls(totalBalls);
        battingTeam.setOvers(totalBalls/6 + "." + totalBalls%6);
    }

    public static void incrementBoundary(TeamScore battingScorecard, Player curBatsman, int runs) {
        if(runs == 4)
            try{
                battingScorecard.getPlayerScores().get(curBatsman.getId()).incrementFours();
            }catch (Exception e){
                log.error("Error while incrementing Fours: ",e);
            }
        else
            try{
                battingScorecard.getPlayerScores().get(curBatsman.getId()).incrementSixes();
            }catch (Exception e){
                log.error("Error while incrementing Sixes", e);
            }
    }

    public static void incrementWicketsTakenByBowler(TeamScore bowlingScorecard, Player curBowler) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler.getId()).incrementWicketTaken();
        }catch(Exception e){
            log.error("Error while incrementing wickets taken by the current bowler", e);
        }
    }

    public static void incrementRunsGiven(TeamScore bowlingScorecard, Player curBowler, int runs) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler.getId()).incrementRunsGiven( runs );
            if(runs == 0)
                bowlingScorecard.getPlayerScores().get(curBowler.getId()).incrementDotBalls();
        }catch (Exception e){
            log.error("error while incrementing runs" , e);
        }
    }

    public static int getWicketsFallen(TeamScore battingScorecard) {
        int wicketsFallen = 0;
        try{
             wicketsFallen = battingScorecard.getWickets();
        }catch (Exception e){
            log.error("Error while getting number of wickets fallen", e);
        }
        return wicketsFallen;
    }

    public static void ballDelivered(Player curBowler, TeamScore bowlingScorecard) {
        try{
            bowlingScorecard.getPlayerScores().get(curBowler.getId()).incrementBallsDelivered();
        }catch(Exception e){
            log.error("Error while updating the  number of Balls delivered by the current bowler", e);
        }
    }

    public static void saveBallsPlayed(TeamScore battingScorecard, Player curBatsman, int ballsPlayed) {
        try{
            battingScorecard.getPlayerScores().get(curBatsman.getId()).setBallsPlayed(ballsPlayed);
        }catch(Exception e){
            log.error("Error while saving the total balls played by the current batting team", e);
        }
    }

    public static void incrementMaidenOver(TeamScore bowlingScorecard, Player curBowler){
        try{
            bowlingScorecard.getPlayerScores().get(curBowler.getId()).incrementMaidenOver();
        }catch (Exception e){
            log.error("Error while updating the number maiden over for the current bowler", e);
        }
    }

    public static boolean ballsLeftToDeliver(TeamScore bowlingScorecard, Integer curBowlerId){
        return bowlingScorecard.getPlayerScores().get(curBowlerId).getBallsDelivered() >=
                bowlingScorecard.getPlayerScores().get(curBowlerId).getBallsToDeliver();
    }
}
