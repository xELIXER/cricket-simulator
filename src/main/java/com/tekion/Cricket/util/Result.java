package com.tekion.Cricket.util;

import com.tekion.Cricket.beans.Match;
import com.tekion.Cricket.beans.Team;

public class Result {
    public static String printResult(Match match, Team first, Team second) {
        String message = "<body>";

        message += match.toString();

        message += "<p>" + first.getName() + " won the toss and goes first.</p>";

        message += "<p>" + first.getName() + "'s scoreboard: {" +
                "Wickets: " + first.getWickets() + ", " +
                "Dot balls: " + first.getDotBalls() + ", " +
                "4s: " + first.getFours() + ", " +
                "6s: " + first.getSixes() + "}</p>" +
                "<p> Balls Played: <b>" + (int)(first.getBallsPlayed()/6) + "." + first.getBallsPlayed()%6 + "</b></p>" +
                "<p>Runs to beat: <b>" + (first.getTotalRuns()+1) + "</b></p>";


        message += "<p>" + second.getName() + "'s turn</p>";

        message += "<p>" + second.getName() + "'s scoreboard: {" +
                "Wickets: " + second.getWickets() + ", " +
                "Dot balls: " + second.getDotBalls() + ", " +
                "4s: " + second.getFours() + ", " +
                "6s: " + second.getSixes() + "}</p>" +
                "<p> Balls Played: <b>" + (int)(second.getBallsPlayed()/6) + "." + second.getBallsPlayed()%6 + "</b></p>";

        message += "<br><p>" + first.getName() + " 's total score: <b>" + first.getTotalRuns() + "</b></p>";
        message += "<p>" + second.getName() + " 's total score: <b>" + second.getTotalRuns() + "</b></p>";

        if(first.getTotalRuns() > second.getTotalRuns()){
            message += "<p><h1><b>" + first.getName() + " won</b></h1></p></body>";
        }
        if(first.getTotalRuns() < second.getTotalRuns()){
            message += "<p><h1><b>" + second.getName() + " won</b></h1></p></body>";
        }
        return message;
    }
}
