package com.tekion.Cricket.helper;


import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.util.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamUtil {

    public static List<Player> getTeam1Players(){
        Player rishabPant = new Player(0, "Rishab Pant", "Jan 3, 1980", Role.BATSMAN, 3);
        Player manishPandey = new Player(1, "Manish Pandey", "Jan 3, 1980", Role.BATSMAN, 4);
        Player ravindraJadeja = new Player(2, "Ravindra Jadeja", "Jan 3, 1980", Role.BATSMAN, 6);
        Player navdeepSaini = new Player(3, "Navdeep Saini", "Jan 3, 1980", Role.BOWLER, 2);
        Player srikarBharat = new Player(4, "Srikar Bharat", "Jan 3, 1980", Role.BOWLER, 3);
        Player kuldeepYadav = new Player(5,"Kuldeep Yadav", "Jan 3, 1980", Role.BOWLER, 2);
        Player shreyasIyer = new Player(6, "Shreyas Iyer", "Jan 3, 1980", Role.ALL_ROUNDER, 2);
        Player shikarDhawan = new Player(7, "Shikhar Dhawan", "Jan 3, 1980", Role.ALL_ROUNDER, 3);
        Player shardulThakur = new Player(8, "Shradul Thakur", "Jan 3, 1980", Role.WK_KEEPER, 2);
        Player mdShammi = new Player(9, "Md Shammi", "Jan 3, 1980", Role.BATSMAN, 2);
        Player jjBumrah = new Player(10,"JJ Bumrah", "Jan 3, 1980", Role.ALL_ROUNDER, 3);

        return Arrays.asList(rishabPant, manishPandey, ravindraJadeja, shreyasIyer,
                                            navdeepSaini, srikarBharat, kuldeepYadav, shikarDhawan,
                                            shardulThakur, mdShammi, jjBumrah);
    }

    public static List<Player> getTeam2Players(){
        Player aronFinch = new Player(0, "Aron Finch", "Jan 3, 1980", Role.BATSMAN, 5);
        Player peterHandscomb = new Player(1, "Peter Handscomb", "Jan 3, 1980", Role.BATSMAN, 5);
        Player stevenSmith = new Player(2, "Steven Smith", "Jan 3, 1980", Role.BATSMAN, 6);
        Player davidWarner = new Player(3, "David Warner", "Jan 3, 1980", Role.BOWLER, 3);
        Player dArcyShort = new Player(4, "D Arcy Short", "Jan 3, 1980", Role.BOWLER, 4);
        Player patCummins = new Player(5, "Pat Cummins", "Jan 3, 1980", Role.BOWLER, 3);
        Player joshHazelwood = new Player(6, "Josh Hazelwood", "Jan 3, 1980", Role.ALL_ROUNDER, 3);
        Player ashtonAgar = new Player(7, "Ashton Agar", "Jan 3, 1980", Role.ALL_ROUNDER, 3);
        Player marnusLabushange = new Player(8, "Maruns Labushange", "Jan 3, 1980", Role.ALL_ROUNDER, 2);
        Player ashtonTurner = new Player(9, "Ashton Turner", "Jan 3, 1980", Role.WK_KEEPER, 3);
        Player alexCarey = new Player(10,"Alec Carey", "Jan 3, 1980", Role.WK_KEEPER, 2);

        return Arrays.asList(aronFinch, peterHandscomb, stevenSmith, davidWarner, dArcyShort,
                patCummins, joshHazelwood, ashtonAgar, marnusLabushange, ashtonTurner, alexCarey);
    }

    public static ArrayList<Player> initializeBatsmen(Team team){
        return new ArrayList<>(team.getPlayers());
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
