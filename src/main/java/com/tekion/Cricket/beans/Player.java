package com.tekion.Cricket.beans;

import com.tekion.Cricket.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Player {
    private String name;
    private String DOB;
    private Role role;
    /*
    *    Bating stats
    * */
//    private int totalRuns;
//    private int dotBalls;
//    private int sixes;
//    private int fours;
//    private int ballsPlayed;
    HashMap<String, Integer> battingStats = new HashMap<>();
    /*
    *     Bowling stats
    * */
//    private int noOfBallsToPlay;
//    private int noOfBallsPlayed;
//    private String noOfOversPlayed;
//    private int runsGiven;
//    private int wicketsTaken;
//    private int maidenOver;
    HashMap<String, Integer> bowlingStats = new HashMap<>();


    public Player(String name, String dob, Role role) {
        this.name = name;
        this.DOB = dob;
        this.role = role;

        this.bowlingStats.put("noOfBallsToPlay", 0);
        this.bowlingStats.put("noOfBallsPlayed", 0);
        this.bowlingStats.put("noOfOversPlayed", 0);
        this.bowlingStats.put("runsGiven", 0);
        this.bowlingStats.put("wicketsTaken", 0);
        this.bowlingStats.put("maidenOver", 0);
//
        this.battingStats.put("totalRuns", 0);
        this.battingStats.put("dotBalls", 0);
        this.battingStats.put("sixes", 0);
        this.battingStats.put("fours", 0);
        this.battingStats.put("ballsPlayed", 0);
    }
}
