package com.tekion.Cricket.beans;


import com.tekion.Cricket.util.Role;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Data
@Document
public class TeamScore{
    private String name;
    private int totalBalls;
    private int totalRuns;
    private int wickets;
    private String overs;

    HashMap<Player,PlayerScore > playerScores;

    public TeamScore(String name, List<Player> players) {
        this.name = name;
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

    public TeamScore(String name) {
        this.name = name;
    }

    public void incrementRuns(int runs){
        this.totalRuns += runs;
    }
    public void incrementWickets(){
        this.wickets++;
    }
}
