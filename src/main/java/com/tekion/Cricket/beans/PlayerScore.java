package com.tekion.Cricket.beans;

import com.tekion.Cricket.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
public class PlayerScore{
    //Batting scores
    private int totalRuns;
    private int dotBalls;
    private int sixes;
    private int fours;
    private int ballsPlayed;

    //Bowling Scores
    private int ballsToDeliver;
    private int ballsDelivered;
    private int oversDelivered;
    private int runsGiven;
    private int wicketsTaken;
    private int maidenOver;
}
