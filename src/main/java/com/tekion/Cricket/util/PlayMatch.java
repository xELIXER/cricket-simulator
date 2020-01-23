package com.tekion.Cricket.util;

import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.Team;

import java.util.ArrayList;
import java.util.List;


public class PlayMatch {
    public static void play(Team team, int runsToBbeat, boolean secondTeam){
        int x,i;
        for(i = 0; i < 300; i++){
            if(team.getWickets() > 9 || (secondTeam && team.getTotalRuns() > runsToBbeat) ){
                break;
            }

            x = GetRunsOrWicket.betterRandom();

            if(x == -1) { team.setWickets(team.getWickets() + 1); }
            else if(x == 0) { team.setDotBalls(team.getDotBalls() + 1); }
            else if(x == 1) { team.setTotalRuns(team.getTotalRuns() + 1); }
            else if(x == 2) { team.setTotalRuns(team.getTotalRuns() + 2); }
            else if (x == 3) { team.setTotalRuns(team.getTotalRuns() + 3); }
            else if(x == 4) {
                team.setTotalRuns(team.getTotalRuns() + 4);
                team.setFours(team.getFours() + 1);
            }
            else if(x == 5){ team.setTotalRuns( team.getTotalRuns() + 5 ); }

            else{
                team.setTotalRuns(team.getTotalRuns() + 6);
                team.setSixes( team.getSixes() + 1);
            }
        }
        team.setBallsPlayed(i);

    }

//    public static void play2(Team battingTeam, Team bowlingTeam , boolean secondInning){
//        ArrayList<Player> batsmen = new ArrayList<>();
//        batsmen.addAll(battingTeam.getPlayers());
//
//        ArrayList<Player> bowller = new ArrayList<>();
//        for(Player x:bowlingTeam.getPlayers()){
//            if(x.getRole() == Role.BOWLER)
//                bowller.add(x);
//        }
//
//        Player currBatting = batsmen.get(0);
//        Player  curBowling = bowller.get(0);
//
//        if(!secondInning) System.out.println("===FIRST INNINGS==");
//        else System.out.println("===SECOND INNINGS==");
//        for(Player x:batsmen)
//            System.out.println(x.getName() + " " + x.getRole());
//        System.out.println("================");
//        for(Player x:bowller)
//            System.out.println(x.getName() + " " + x.getRole());
//        System.out.println("=======END======");
//
//        int i;
//        for(i = 0; i < 300; i++ ){
//
//            if( curBowling.getBallsPlayed() >= curBowling.getNoOfBallsToPlay()){
//                bowller.remove(0);
//                curBowling = bowller.get(0);
//            }
//
//            if(battingTeam.getWickets() > 9 || (secondInning && battingTeam.getTotalRuns() > bowlingTeam.getTotalRuns()) ){
//                break;
//            }
//
//            int x = GetRunsOrWicket.betterRandom();
//
//
//            if(x == -1) {
//                // Wicket
//                battingTeam.setWickets(battingTeam.getWickets() + 1);
//                batsmen.remove(0);
//                currBatting = batsmen.get(0);
//                curBowling.setWicketsTaken( curBowling.getWicketsTaken() + 1 );
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//            }
//            else if(x == 0) {
//                // DOT BALLS
//                battingTeam.setDotBalls(battingTeam.getDotBalls() + 1);              // Batsman
//
//                currBatting.setDotBalls( currBatting.getDotBalls() + 1);             // Batting team
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );// Bowler
//            }
//            else if(x == 1) {
//                battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 1);
//
//                currBatting.setTotalRuns( currBatting.getTotalRuns() + 1 );
//                currBatting.setBallsPlayed( currBatting.getBallsPlayed() + 1 );
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//                curBowling.setRunsGiven( curBowling.getRunsGiven() + 1 );
//            }
//            else if(x == 2) {
//                battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 2);
//
//                currBatting.setTotalRuns( currBatting.getTotalRuns() + 2 );
//                currBatting.setBallsPlayed( currBatting.getBallsPlayed() + 1 );
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//                curBowling.setRunsGiven( curBowling.getRunsGiven() + 2 );
//
//            }
//            else if (x == 3) {
//                battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 3);
//
//                currBatting.setTotalRuns( currBatting.getTotalRuns() + 3 );
//                currBatting.setBallsPlayed( currBatting.getBallsPlayed() + 1 );
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//                curBowling.setRunsGiven( curBowling.getRunsGiven() + 3 );
//            }
//            else if(x == 4) {
//                battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 4);
//                battingTeam.setFours( battingTeam.getFours() + 1 );
//
//                currBatting.setTotalRuns( currBatting.getTotalRuns() + 4 );
//                currBatting.setBallsPlayed( currBatting.getBallsPlayed() + 1 );
//                currBatting.setFours( currBatting.getFours() + 1 );
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//                curBowling.setRunsGiven( curBowling.getRunsGiven() + 4 );
//            }
//            else if(x == 5){
//                battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 5);
//
//                currBatting.setTotalRuns( currBatting.getTotalRuns() + 5 );
//                currBatting.setBallsPlayed( currBatting.getBallsPlayed() + 1 );
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//                curBowling.setRunsGiven( curBowling.getRunsGiven() + 5 );
//            }
//
//            else{
//                battingTeam.setTotalRuns(battingTeam.getTotalRuns() + 6);
//                battingTeam.setSixes( battingTeam.getSixes() + 1 );
//
//                currBatting.setTotalRuns( currBatting.getTotalRuns() + 6 );
//                currBatting.setBallsPlayed( currBatting.getBallsPlayed() + 1 );
//                currBatting.setSixes( currBatting.getSixes() + 1 );
//
//                curBowling.setNoOfBallsPlayed( curBowling.getNoOfBallsPlayed() + 1 );
//                curBowling.setRunsGiven( curBowling.getRunsGiven() + 6 );
//            }
//        }
//        battingTeam.setBallsPlayed(i);
//    }

    public static void play3(Team battingTeam, Team bowlingTeam , boolean secondInning){
        ArrayList<Player> batsmen = new ArrayList<>();
        batsmen.addAll(battingTeam.getPlayers());

        ArrayList<Player> bowllers = new ArrayList<>();
        for(Player x:bowlingTeam.getPlayers()){
            if(x.getRole() == Role.BOWLER)
                bowllers.add(x);
        }


        Player currBatsman = batsmen.get(0);
        Player curBowler = bowllers.get(0);
        int runsThisOver = 0;
        int i;


        for(i = 0; i < 300; i++ ){

            if( curBowler.getBowlingStats().get("noOfBallsPlayed") >= curBowler.getBowlingStats().get("noOfBallsToPlay") && bowllers.size() > 1){
                if(bowllers.size() == 1) break;
                if(secondInning)System.out.println("second inning ");
                else System.out.println("first inning ");
                System.out.println(bowllers.toString());
                System.out.println("noOfBallsPlayed" + curBowler.getBowlingStats().get("noOfBallsPlayed"));
                System.out.println("i: "+i);
                System.out.println("noOfBallsToPlay" + curBowler.getBowlingStats().get("noOfBallsToPlay"));
                bowllers.remove(0);
                curBowler = bowllers.get(0);
            }

            if (i%6 == 0){
                if(runsThisOver == 0 && i > 0)
                    curBowler.getBowlingStats().put("maidenOver", curBowler.getBowlingStats().get("maidenOver") + 1);
                runsThisOver = 0;
            }

            if(battingTeam.getWickets() > 9 || (secondInning && battingTeam.getTotalRuns() > bowlingTeam.getTotalRuns()) ){
                break;
            }

            int x = GetRunsOrWicket.betterRandom();
            runsThisOver += x;
            curBowler.getBowlingStats().put("noOfBallsPlayed", curBowler.getBowlingStats().get("noOfBallsPlayed") + 1);

            if(x == -1) {
                battingTeam.setWickets( battingTeam.getWickets()+1 );

                batsmen.remove(0);
                currBatsman = batsmen.get(0);

                curBowler.getBowlingStats().put("wicketsTaken", curBowler.getBowlingStats().get("wicketsTaken") + 1);
            }
            else if(x == 0) {
                battingTeam.setDotBalls( battingTeam.getDotBalls()+1 );
                currBatsman.getBattingStats().put("dotBalls",  currBatsman.getBattingStats().get("dotBalls")+ 1);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);

            }
            else if(x == 1) {
                battingTeam.setTotalRuns( battingTeam.getTotalRuns()+1);
                currBatsman.getBattingStats().put("totalRuns",  currBatsman.getBattingStats().get("totalRuns") + 1);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);
                curBowler.getBowlingStats().put("runsGiven", curBowler.getBowlingStats().get("runsGiven") + 1);
            }
            else if(x == 2) {
                battingTeam.setTotalRuns( battingTeam.getTotalRuns()+2);
                currBatsman.getBattingStats().put("totalRuns",  currBatsman.getBattingStats().get("totalRuns") + 2);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);
                curBowler.getBowlingStats().put("runsGiven", curBowler.getBowlingStats().get("runsGiven") + 2);
            }
            else if (x == 3) {
                battingTeam.setTotalRuns( battingTeam.getTotalRuns()+3 );
                currBatsman.getBattingStats().put("totalRuns",  currBatsman.getBattingStats().get("totalRuns") + 3);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);
                curBowler.getBowlingStats().put("runsGiven", curBowler.getBowlingStats().get("runsGiven") + 3);
            }
            else if(x == 4) {
                battingTeam.setTotalRuns( battingTeam.getTotalRuns()+4 );
                battingTeam.setFours( battingTeam.getFours()+1 );
                currBatsman.getBattingStats().put("totalRuns",  currBatsman.getBattingStats().get("totalRuns") + 4);
                currBatsman.getBattingStats().put("fours",  currBatsman.getBattingStats().get("fours") + 1);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);
                curBowler.getBowlingStats().put("runsGiven", curBowler.getBowlingStats().get("runsGiven") + 4);
            }
            else if(x == 5){
                battingTeam.setTotalRuns( battingTeam.getTotalRuns()+5 );
                currBatsman.getBattingStats().put("totalRuns",  currBatsman.getBattingStats().get("totalRuns") + 5);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);
                curBowler.getBowlingStats().put("runsGiven", curBowler.getBowlingStats().get("runsGiven") + 5);
            }
            else{
                battingTeam.setTotalRuns( battingTeam.getTotalRuns()+6 );
                battingTeam.setSixes( battingTeam.getSixes()+1 );
                currBatsman.getBattingStats().put("totalRuns",  currBatsman.getBattingStats().get("totalRuns") + 6);
                currBatsman.getBattingStats().put("sixes",  currBatsman.getBattingStats().get("sixes") + 1);
                currBatsman.getBattingStats().put("ballsPlayed",  currBatsman.getBattingStats().get("ballsPlayed") + 1);
                curBowler.getBowlingStats().put("runsGiven", curBowler.getBowlingStats().get("runsGiven") + 6);
            }
        }
        battingTeam.setBallsPlayed(i);
        battingTeam.setOversPlayed( (int)(battingTeam.getBallsPlayed()/6) + "." + battingTeam.getBallsPlayed()%6);
    }
}
