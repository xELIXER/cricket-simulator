package com.tekion.Cricket.repo;

import com.tekion.Cricket.beans.TeamScore;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamScoreRepo extends MongoRepository<TeamScore, String> {
    List<TeamScore> findAllByName(String name);
}
