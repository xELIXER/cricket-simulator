package com.tekion.Cricket.beans;

import lombok.Data;

@Data
public class Scorecard {
    private int totalRuns;
    private int dotBalls;
    private int sixes;
    private int fours;
    private int ballsPlayed;
    private int noOfOvers;
    private int runsGiven;
    private int wicketsTaken;
    private int maidenOver;
}
