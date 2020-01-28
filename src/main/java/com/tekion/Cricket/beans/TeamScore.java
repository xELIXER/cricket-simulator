package com.tekion.Cricket.beans;


import com.tekion.Cricket.util.Role;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TeamScore{
    private int     totalBalls;
    private int     totalRuns;
    private int     wickets;
    private String  overs;

    HashMap<Player,PlayerScore > playerScores;

    public TeamScore(List<Player> players) {
        this.totalBalls = 0;
        this.totalRuns = 0;
        this.wickets = 0;
        this.overs = "";
        HashMap<Player, PlayerScore> temp = new HashMap<>();
        for (Player x: players) {
            temp.put(x, new PlayerScore());
            if(x.getRole().equals(Role.BOWLER)){
                temp.get(x).setBallsToDeliver(100);
            }
        }
        this.playerScores = temp;
    }
}
