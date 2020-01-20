package com.tekion.Cricket.util;

import com.tekion.Cricket.beans.Match;
import com.tekion.Cricket.beans.Team;

import java.util.Date;

public class StartMatchUtil {
    public static String startMatch(){
        Team team1 = TeamUtil.createTeam1("INDIA");

        Team team2 = TeamUtil.createTeam2("AUSTRALIA");

        Match indvAusODI = new Match("IND v AUS ODI", "M Chinnaswamy Stadium", new Date(), team1, team2, null, null);
        System.out.println("hello");
        if(Toss.toss()){
            /*
             * Team 1 wins the toss and chooses to bat.
             * */
            indvAusODI.setFirst(team1);
            PlayMatch.play(team1, Integer.MAX_VALUE, false);

            /*
             * Team 2 goes now.
             * */
            indvAusODI.setSecond(team2);
            PlayMatch.play(team2, team1.getTotalRuns(), true);
        }
        else{
            /*
             * Team 2 wins the toss and chooses to bat.
             * */
            indvAusODI.setFirst(team2);
            PlayMatch.play(team2, Integer.MAX_VALUE, false);
            /*
             * Team 2 goes now.
             * */
            indvAusODI.setSecond(team1);
            PlayMatch.play(team1, team2.getTotalRuns(), true);
        }
        String message = Result.printResult(indvAusODI ,indvAusODI.getFirst(), indvAusODI.getSecond());
        System.out.println(message);
        return message;

//		MatchController controller = new MatchController();
//		controller.setMatch(indvAusODI);
//
//		if(controller.toss() == 0){
//			/*
//			 * Team 1 goes first.
//			 */
//
//
//		}

    }
}
