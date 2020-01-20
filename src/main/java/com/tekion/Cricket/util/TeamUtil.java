package com.tekion.Cricket.util;


import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.beans.Team;

import java.util.Arrays;
import java.util.List;

public class TeamUtil {

    public static Team createTeam1(String teamName){

        Team team = new Team();
        team.setName(teamName);
        Player rishabPant = new Player();
        Player manishPandey = new Player();
        Player ravindraJadeja = new Player();
        Player navdeepSaini = new Player();
        Player srikarBharat = new Player();
        Player kuldeepYadav = new Player();
        Player shreyasIyer = new Player();
        Player shikarDhawan = new Player();
        Player shardulThakur = new Player();
        List<Player> names = Arrays.asList(rishabPant, manishPandey, shreyasIyer, ravindraJadeja,
                navdeepSaini, srikarBharat, kuldeepYadav, shikarDhawan, shardulThakur);
        team.setPlayers(names);
        return team;
    }

    public static  Team createTeam2(String teamName){
        Team team = new Team();
        team.setName(teamName);
        Player aronFinch = new Player();
        Player peterHandscomb = new Player();
        Player stevenSmith = new Player();
        Player davidWarner = new Player();
        Player dArcyShort = new Player();
        Player patCummins = new Player();
        Player joshHazelwood = new Player();
        Player ashtonAgar = new Player();
        Player marnusLabushange = new Player();
        Player ashtonTurner = new Player();
        Player alexCarey = new Player();
        List<Player> names = Arrays.asList(aronFinch, peterHandscomb, stevenSmith, davidWarner, dArcyShort,
                patCummins, joshHazelwood, ashtonAgar, marnusLabushange, ashtonTurner, alexCarey);
        team.setPlayers(names);
        return team;
    }

}
