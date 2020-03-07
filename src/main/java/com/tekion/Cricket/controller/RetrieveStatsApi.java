package com.tekion.Cricket.controller;

import com.tekion.Cricket.beans.WinLoseRecord;
import com.tekion.Cricket.repo.TeamScoreRepo;
import com.tekion.Cricket.repo.WinLoseRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("/stats")
public class RetrieveStatsApi {

    @Autowired
    TeamScoreRepo teamScoreRepo;
    @Autowired
    WinLoseRecordRepo winLoseRecordRepo;

    @PostMapping("/{teamName}")
    public WinLoseRecord getDetails(@PathVariable("teamName") String teamName) {
        return winLoseRecordRepo.findByTeamName(teamName.toUpperCase());
    }
}