package com.tekion.Cricket.util;

import com.tekion.Cricket.beans.Team;

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
}
