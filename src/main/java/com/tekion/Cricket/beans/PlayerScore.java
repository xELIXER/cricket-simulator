package com.tekion.Cricket.beans;

import lombok.Data;

@Data
public class PlayerScore{
    //Batting scores
    private int totalRuns;
    private int sixes;
    private int fours;
    private int ballsPlayed;

    //Bowling Scores
    private int ballsToDeliver;
    private int ballsDelivered;
    private int oversDelivered;
    private int runsGiven;
    private int wicketsTaken;
    private int dotBalls;
    private int maidenOver;

    public void incrementRuns(int runs){
        this.totalRuns += runs;
    }

    public void incrementFours(){
        this.fours++;
    }

    public void incrementSixes(){
        this.sixes++;
    }

    public void incrementDotBalls(){
        this.dotBalls++;
    }

    public void incrementBallsDelivered(){
        this.ballsDelivered++;
    }

    public void incrementRunsGiven(int run){
        this.runsGiven += run;
    }

    public void incrementWicketTaken(){
        this.wicketsTaken++;
    }

    public void incrementMaidenOver(){
        this.maidenOver++;
    }



}
