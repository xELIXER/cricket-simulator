package com.tekion.Cricket.helper;


import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.util.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamUtil {

    public static Team initializeTeam1(String teamName){

        Team team;
        Player rishabPant       = new Player("Rishab Pant", "Jan 3, 1980", Role.BATSMAN, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player manishPandey     = new Player("Manish Pandey", "Jan 3, 1980", Role.BATSMAN, new int[]{15, 30, 20, 18, 10, 3, 1, 3});
        Player ravindraJadeja   = new Player("Ravindra Jadeja", "Jan 3, 1980", Role.BATSMAN, new int[]{30, 30, 15, 8, 5, 8, 1, 3});
        Player navdeepSaini     = new Player("Navdeep Saini", "Jan 3, 1980", Role.BOWLER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player srikarBharat     = new Player("Srikar Bharat", "Jan 3, 1980", Role.BOWLER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player kuldeepYadav     = new Player("Kuldeep Yadav", "Jan 3, 1980", Role.BOWLER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player shreyasIyer      = new Player("Shreyas Iyer", "Jan 3, 1980", Role.ALL_ROUNDER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player shikarDhawan     = new Player("Shikhar Dhawan", "Jan 3, 1980", Role.ALL_ROUNDER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player shardulThakur    = new Player("Shradul Thakur", "Jan 3, 1980", Role.WK_KEEPER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player mdShammi         = new Player("Md Shammi", "Jan 3, 1980", Role.BATSMAN, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player jjBumrah         = new Player("JJ Bumrah", "Jan 3, 1980", Role.ALL_ROUNDER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});

        List<Player> players = Arrays.asList(rishabPant, manishPandey, shreyasIyer, ravindraJadeja,
                                            navdeepSaini, srikarBharat, kuldeepYadav, shikarDhawan,
                                            shardulThakur, mdShammi, jjBumrah);
        team = new Team(teamName, players);
        return team;
    }

    public static  Team initializeTeam2(String teamName){
        Team team;
        Player aronFinch            = new Player("Aron Finch", "Jan 3, 1980", Role.BATSMAN, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player peterHandscomb       = new Player("Peter Handscomb", "Jan 3, 1980", Role.BATSMAN, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player stevenSmith          = new Player("Steven Smith", "Jan 3, 1980", Role.BATSMAN, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player davidWarner          = new Player("David Warner", "Jan 3, 1980", Role.BOWLER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player dArcyShort           = new Player("D Arcy Short", "Jan 3, 1980", Role.BOWLER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player patCummins           = new Player("Pat Cummins", "Jan 3, 1980", Role.BOWLER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player joshHazelwood        = new Player("Josh Hazelwood", "Jan 3, 1980", Role.ALL_ROUNDER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player ashtonAgar           = new Player("Ashton Agar", "Jan 3, 1980", Role.ALL_ROUNDER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player marnusLabushange     = new Player("Maruns Labushange", "Jan 3, 1980", Role.ALL_ROUNDER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player ashtonTurner         = new Player("Ashton Turner", "Jan 3, 1980", Role.WK_KEEPER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});
        Player alexCarey            = new Player("Alec Carey", "Jan 3, 1980", Role.WK_KEEPER, new int[]{5, 30, 20, 18, 15, 8, 1, 3});

        List<Player> players = Arrays.asList(aronFinch, peterHandscomb, stevenSmith, davidWarner, dArcyShort,
                patCummins, joshHazelwood, ashtonAgar, marnusLabushange, ashtonTurner, alexCarey);
        team = new Team(teamName, players);
        return team;
    }

    public static ArrayList<Player> initializeBatsmen(Team team){
        ArrayList<Player> batsmen = new ArrayList<>();
        batsmen.addAll(team.getPlayers());
        return batsmen;
    }

    public static ArrayList<Player> initializeBowlers(Team team){
        ArrayList<Player> bowler = new ArrayList<>();
        for (Player x: team.getPlayers()) {
               if(x.getRole().equals(Role.BOWLER))
                   bowler.add(x);
        }
        return bowler;
    }



}
