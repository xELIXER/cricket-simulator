package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.Player;
import com.tekion.Cricket.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class MatchController {

    @RequestMapping("/match")
    public String startMatch(){
        return StartMatchUtil.startMatch();
    }

    @GetMapping(value = "/test")
    public String test(){
        return "<body>" +
                "<p>test from spring :D</p>" +
                "<p>Go to <code><b>localhost:8080/match</b></code> to start the cricket game.</p>" +
                "<p>or else click <a href='http://localhost:8080/match'>here</a></p>" +
                "</body>";
    }

    @RequestMapping("/")
    public String hello(){
        return "<body>" +
                "<p>hello from spring :D</p>" +
                "<p>Go to <code><b>localhost:8080/match</b></code> to start the cricket game.</p>" +
                "<p>or else click <a href='http://localhost:8080/match'>here</a></p>" +
                "</body>";
    }
    @RequestMapping(value="/testobj")
    public Player getObj()
    {
        Player p1 = new Player("Manzil Moharana", "jan 3, 1980", Role.ALL_ROUNDER);
        return p1;
    }
}
