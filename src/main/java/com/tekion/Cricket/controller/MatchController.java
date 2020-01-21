package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.Match;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

}
