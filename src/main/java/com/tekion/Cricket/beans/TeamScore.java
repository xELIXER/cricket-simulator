package com.tekion.Cricket.beans;


import com.tekion.Cricket.util.Role;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class TeamScore{
    private int totalBalls;
    private int totalRuns;
    private int wickets;
    private String overs;

    HashMap<Player,PlayerScore > playerScores;

    public TeamScore(List<Player> players) {
        this.totalBalls = 0;
        this.totalRuns = 0;
        this.wickets = 0;
        this.overs = "";
        HashMap<Player, PlayerScore> temp = new HashMap<>();
        for (Player player: players) {
            temp.put(player, new PlayerScore());
            if(player.getRole().equals(Role.BOWLER)){
                temp.get(player).setBallsToDeliver(100);
            }
        }
        this.playerScores = temp;
    }

    public void incrementRuns(int runs){
        this.totalRuns += runs;
    }
    public void incrementWickets(){
        this.wickets++;
    }
}
