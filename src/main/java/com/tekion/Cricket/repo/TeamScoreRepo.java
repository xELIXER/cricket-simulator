package com.tekion.Cricket.repo;

import com.tekion.Cricket.beans.TeamScore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamScoreRepo extends MongoRepository<TeamScore, String> {
    TeamScore findAllByName(String name);
}
