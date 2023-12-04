package com.wheelOfFortune.UserRecord;

import com.google.api.client.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
//@SpringBootApplication
public class UserRecordApplication {
    @Autowired
    UserRecordRepository userRecordRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserRecordApplication.class, args);
    }

    @ShellMethod("Saves a userRecord to Cloud Datastore: save-userRecord <userid> <score> <date>")
    public String saveUserRecord(String userId, String handle, int score , String date) {
        UserRecord savedUserRecord = this.userRecordRepository.save(new UserRecord(userId ,handle ,score , date  ));
        return savedUserRecord.toString();
    }

    @ShellMethod("Loads all UserRecord")
    public String findAllUserRecord() {
        Iterable<UserRecord> userRecords = this.userRecordRepository.findAll();
        return Lists.newArrayList(userRecords).toString();
    }

    @ShellMethod("Loads record by user: find-by-userID <userId>")
    public String findByUserId(String userId) {
        List<UserRecord> userRecords = this.userRecordRepository.findByUserId(userId);
        return userRecords.toString();
    }

    @ShellMethod("remove all records")
    public void removeAllUserRecords() {
        this.userRecordRepository.deleteAll();
    }

    @ShellMethod("remove userid records")
    public void removeByUserRecords(long id) {
        this.userRecordRepository.deleteById(id);
    }


}
