package com.tekion.Cricket;

import com.tekion.Cricket.beans.TeamScore;
import com.tekion.Cricket.repo.TeamScoreRepo;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTeamScoreRepo {
    @Autowired
    private TeamScoreRepo teamScoreRepo;

    @Test
    public void setUp() throws Exception {
        TeamScore teamScore = new TeamScore("INDIA");
        this.teamScoreRepo.save(teamScore);
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        TeamScore teamScore = teamScoreRepo.findAllByName("INDIA");
    }
    @Test
    public void testDataUpdate(){
        /*Test update*/
        TeamScore teamScore = teamScoreRepo.findAllByName("INDIA");
        teamScore.setOvers("999");
    }
    @After
    public void tearDown() throws Exception {
        this.teamScoreRepo.deleteAll();
    }

}
