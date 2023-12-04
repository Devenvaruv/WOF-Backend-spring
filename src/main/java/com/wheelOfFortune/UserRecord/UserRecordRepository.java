package com.wheelOfFortune.UserRecord;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import java.util.List;


public interface UserRecordRepository extends DatastoreRepository<UserRecord, Long>  {

    List<UserRecord> findByUserId(String userId);
    List<UserRecord> findById(long id);

}
