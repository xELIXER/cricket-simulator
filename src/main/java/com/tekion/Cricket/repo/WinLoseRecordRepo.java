package com.tekion.Cricket.repo;

import com.tekion.Cricket.beans.WinLoseRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinLoseRecordRepo extends MongoRepository<WinLoseRecord, String> {
    WinLoseRecord findByTeamName(String teamName);
}
