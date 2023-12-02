package com.wheelOfFortune.gameRecord;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import java.util.List;

public interface GameRecordRepository extends DatastoreRepository<GameRecord, Long>  {

    List<GameRecord> findByUserId(String userId);
    //List<GameRecord> findByScore(int score);

}
