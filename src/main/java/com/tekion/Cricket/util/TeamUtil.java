package com.tekion.Cricket.util;


import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.Team;

import java.util.Arrays;
import java.util.List;

public class TeamUtil {

    public static Team createTeam1(String teamName){

        Team team = new Team();
        team.setName(teamName);
        Player rishabPant = new Player("Rishab Pant", "Jan 3, 1980", Role.BATSMAN);
        Player manishPandey = new Player("Manish Pandey", "Jan 3, 1980", Role.BATSMAN);
        Player ravindraJadeja = new Player("Ravindra Jadeja", "Jan 3, 1980", Role.BATSMAN);
        Player navdeepSaini = new Player("Navdeep Saini", "Jan 3, 1980", Role.BOWLER);
//        navdeepSaini.setNoOfBallsToPlay(120);
        navdeepSaini.getBowlingStats().put("noOfBallsToPlay",120);
        Player srikarBharat = new Player("Srikar Bharat", "Jan 3, 1980", Role.BOWLER);
//        srikarBharat.setNoOfBallsToPlay(120);
        srikarBharat.getBowlingStats().put("noOfBallsToPlay",120);
        Player kuldeepYadav = new Player("Kuldeep Yadav", "Jan 3, 1980", Role.BOWLER);
//        kuldeepYadav.setNoOfBallsToPlay(60);
        kuldeepYadav.getBowlingStats().put("noOfBallsToPlay",60);
        Player shreyasIyer = new Player("Shreyas Iyer", "Jan 3, 1980", Role.ALL_ROUNDER);
        Player shikarDhawan = new Player("Shikhar Dhawan", "Jan 3, 1980", Role.ALL_ROUNDER);
        Player shardulThakur = new Player("Shradul Thakur", "Jan 3, 1980", Role.WK_KEEPER);
        Player mdShammi = new Player("Md Shammi", "Jan 3, 1980", Role.BATSMAN);
        Player jjBumrah = new Player("JJ Bumrah", "Jan 3, 1980", Role.ALL_ROUNDER);

        List<Player> names = Arrays.asList(rishabPant, manishPandey, shreyasIyer, ravindraJadeja,
                navdeepSaini, srikarBharat, kuldeepYadav, shikarDhawan, shardulThakur, mdShammi, jjBumrah);
        team.setPlayers(names);

        return team;
    }

    public static  Team createTeam2(String teamName){
        Team team = new Team();
        team.setName(teamName);
        Player aronFinch = new Player("Aron Finch", "Jan 3, 1980", Role.BATSMAN);
        Player peterHandscomb = new Player("Peter Handscomb", "Jan 3, 1980", Role.BATSMAN);
        Player stevenSmith = new Player("Steven Smith", "Jan 3, 1980", Role.BATSMAN);
        Player davidWarner = new Player("David Warner", "Jan 3, 1980", Role.BOWLER);
//        davidWarner.setNoOfBallsToPlay(120);
        davidWarner.getBowlingStats().put("noOfBallsToPlay",120);
        Player dArcyShort = new Player("D Arcy Short", "Jan 3, 1980", Role.BOWLER);
//        dArcyShort.setNoOfBallsToPlay(120);
        dArcyShort.getBowlingStats().put("noOfBallsToPlay",120);
        Player patCummins = new Player("Pat Cummins", "Jan 3, 1980", Role.BOWLER);
//        patCummins.setNoOfBallsToPlay(60);
        patCummins.getBowlingStats().put("noOfBallsToPlay",60);
        Player joshHazelwood = new Player("Josh Hazelwood", "Jan 3, 1980", Role.ALL_ROUNDER);
        Player ashtonAgar = new Player("Ashton Agar", "Jan 3, 1980", Role.ALL_ROUNDER);
        Player marnusLabushange = new Player("Maruns Labushange", "Jan 3, 1980", Role.ALL_ROUNDER);
        Player ashtonTurner = new Player("Ashton Turner", "Jan 3, 1980", Role.WK_KEEPER);
        Player alexCarey = new Player("Alec Carey", "Jan 3, 1980", Role.WK_KEEPER);
        List<Player> names = Arrays.asList(aronFinch, peterHandscomb, stevenSmith, davidWarner, dArcyShort,
                patCummins, joshHazelwood, ashtonAgar, marnusLabushange, ashtonTurner, alexCarey);
        team.setPlayers(names);
        return team;
    }

}
