package com.tekion.Cricket.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.util.StartMatchUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class ScoreboardController {
    @RequestMapping("/scoreboard/team1")
    public String getScoreboardForTeam1(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(StartMatchUtil.getTeam1());
    }
    @RequestMapping("/scoreboard/team2")
    public String getScoreboardForTeam2(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(StartMatchUtil.getTeam2());
    }
    @RequestMapping("/scoreboard")
    public String getScoreboard(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new Team[]{StartMatchUtil.getTeam1(), StartMatchUtil.getTeam2()});
    }

}
