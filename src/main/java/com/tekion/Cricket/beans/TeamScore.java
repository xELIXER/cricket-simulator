package com.tekion.Cricket.beans;


import com.tekion.Cricket.util.Role;
import lombok.Data;

import java.util.HashMap;

@Data
public class TeamScore{
    private int     totalBalls;
    private int     totalRuns;
    private int     wickets;
    private String  overs;

    HashMap<Player,PlayerScore > playerScores;
}
