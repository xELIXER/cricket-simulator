package com.tekion.Cricket.util;


import com.tekion.Cricket.beans.Match;
import com.tekion.Cricket.beans.Team;

import java.util.Date;


public class StartMatchUtil {
    private static Team team1;
    private static Team team2;

    public static Team getTeam1() {
        return team1;
    }

    public static Team getTeam2() {
        return team2;
    }

    public static String startMatch(){
        team1 = TeamUtil.createTeam1("INDIA");

        team2 = TeamUtil.createTeam2("AUSTRALIA");

        Match indvAusODI = new Match("IND v AUS ODI", "M Chinnaswamy Stadium", new Date(), team1, team2, null, null);
        System.out.println("hello");
        if(Toss.toss()){
            /*
             * Team 1 wins the toss and chooses to bat.
             * */

            indvAusODI.setFirst(team1);
            indvAusODI.setSecond(team2);

            PlayMatch.play3(team1, team2, false);

            /*
             * Team 2 goes now.
             * */

            PlayMatch.play3(team2, team1, true);
        }
        else{
            /*
             * Team 2 wins the toss and chooses to bat.
             * */

            indvAusODI.setFirst(team2);
            indvAusODI.setSecond(team1);
            PlayMatch.play3(team2, team1, false);

            /*
             * Team 1 goes now.
             * */

            PlayMatch.play3(team1, team2, true);
        }
        String message = Result.printResult(indvAusODI ,indvAusODI.getFirst(), indvAusODI.getSecond());

        return message;
    }
}
