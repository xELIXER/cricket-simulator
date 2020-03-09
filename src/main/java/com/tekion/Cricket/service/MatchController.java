package com.tekion.Cricket.service;

import com.tekion.Cricket.beans.CricketMatch;
import com.tekion.Cricket.beans.CricketScorecard;
import com.tekion.Cricket.beans.Team;
import com.tekion.Cricket.beans.WinLoseRecord;
import com.tekion.Cricket.repo.CricketScorecardRepo;
import com.tekion.Cricket.repo.TeamScoreRepo;
import com.tekion.Cricket.repo.WinLoseRecordRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.tekion.Cricket.helper.InningSimulator.simulateInning;
import static com.tekion.Cricket.util.MathUtil.toss;

@Slf4j
@Service
public class MatchController {

    @Autowired
    private CricketScorecardRepo cricketScorecardRepo;
    @Autowired
    private TeamScoreRepo teamScoreRepo;
    @Autowired
    private WinLoseRecordRepo winLoseRecordRepo;


    public CricketScorecard conductMatch(){
        CricketMatch match = new CricketMatch("IND v AUS ODI", "M Chinnaswamy Stadium",
                new Date(), null, null, 50, "INDIA", "AUSTRALIA");
        if(toss()){
            beginMatch(match.getTeam1(),match.getTeam2(), match, match.getScorecard());
            match.getScorecard().setFirstBatting(match.getTeam1().getName());
        }
        else{
            beginMatch(match.getTeam2(),match.getTeam1(), match, match.getScorecard());
            match.getScorecard().setFirstBatting(match.getTeam2().getName());

        }

        //Save all match details.
        cricketScorecardRepo.save(match.getScorecard());
        //Save Individual team scores
        teamScoreRepo.save(match.getScorecard().getTeamScores().get(match.getTeam1().getId()));
        teamScoreRepo.save(match.getScorecard().getTeamScores().get(match.getTeam2().getId()));
        //Set winner and loser records
        String team1Name = match.getTeam1().getName();
        String team2Name = match.getTeam2().getName();
        WinLoseRecord team1Record = winLoseRecordRepo.findByTeamName(team1Name);
        WinLoseRecord team2Record = winLoseRecordRepo.findByTeamName(team2Name);
        if (match.getScorecard().getTeamScores().get(match.getTeam1().getId()).getVerdict().equals("DRAW")) {
            if (team1Record == null) {
                team1Record = new WinLoseRecord(team1Name, 0, 0, 1);
            }
            else {
                team1Record.incrementDraw();
            }
            if ( team2Record == null) {
                team2Record = new WinLoseRecord(team2Name, 0, 0, 1);
            }
            else {
                team2Record.incrementDraw();
            }
        }
        else {
            if (match.getScorecard().getTeamScores().get(match.getTeam1().getId()).getVerdict().equals("WON")) {
                if (team1Record == null) {
                    team1Record = new WinLoseRecord(team1Name, 1, 0, 0);
                }
                else {
                    team1Record.incrementWins();
                }
                if (team2Record == null) {
                    team2Record = new WinLoseRecord(team2Name, 0, 1, 0);
                }
                else {
                    team2Record.incrementDefeat();
                }
            }
            else {
                if (team1Record == null) {
                    team1Record = new WinLoseRecord(team1Name, 0, 1, 0);
                }
                else {
                    team1Record.incrementDefeat();
                }
                if (team2Record == null) {
                    team2Record = new WinLoseRecord(team2Name, 1, 0, 0);
                }
                else {
                    team2Record.incrementWins();
                }
            }
        }
        winLoseRecordRepo.save(team1Record);
        winLoseRecordRepo.save(team2Record);
        return match.getScorecard();
    }
    void beginMatch(Team team1, Team team2, CricketMatch match, CricketScorecard scorecard){
        match.setFirst(team1);
        match.setSecond(team2);
        simulateInning(team1, team2, match, false);
        simulateInning(team2, team1, match, true);
    }
}
