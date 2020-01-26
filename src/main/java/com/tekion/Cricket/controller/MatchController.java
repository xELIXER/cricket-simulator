package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.Match;
import com.tekion.Cricket.service.SetupMatch;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class MatchController {

    @RequestMapping("/match")
    public Match startMatch(){
        return new SetupMatch().startMatch();
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
