package com.tekion.Cricket.beans;


import com.tekion.Cricket.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TeamScore{
    private String name;
    private int totalBalls;
    private int totalRuns;
    private int wickets;
    private String overs;
    private String verdict;
    private HashMap<Integer,PlayerScore > playerScores;

    public TeamScore(String name, List<Player> players) {
        this.name = name;
        this.totalBalls = 0;
        this.totalRuns = 0;
        this.wickets = 0;
        this.overs = "";
        HashMap<Integer, PlayerScore> temp = new HashMap<>();
        for (Player player: players) {
            temp.put(player.getId(), new PlayerScore());

            if(player.getRole().equals(Role.BOWLER)){
                temp.get(player.getId()).setBallsToDeliver(100);
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
