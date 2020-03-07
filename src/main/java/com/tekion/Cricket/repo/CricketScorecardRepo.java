package com.tekion.Cricket.repo;

import com.tekion.Cricket.beans.CricketScorecard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CricketScorecardRepo extends MongoRepository<CricketScorecard,Integer> {
}
