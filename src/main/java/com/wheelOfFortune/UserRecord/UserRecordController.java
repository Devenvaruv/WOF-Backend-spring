package com.wheelOfFortune.UserRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@RestController
public class UserRecordController {
    private final UserRecordRepository userRecordRepository;

    public UserRecordController(UserRecordRepository userRecordRepository) {
        this.userRecordRepository = userRecordRepository;
    }

    @PostMapping("/saveUserRecord")
    @CrossOrigin(origins = "*")
    public String saveUserRecord(@RequestBody UserRecord userRecord) {
        if (userRecord == null) {
            return "The book is invalid";
        }
        this.userRecordRepository.save(userRecord);
        return "success";
    }

    @GetMapping("/findAllUserRecord")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<UserRecord> findAllUserRecord() {
        Iterable<UserRecord> userRecords = this.userRecordRepository.findAll();
        List<UserRecord> userRecordList = new ArrayList<>();
        userRecords.forEach(userRecordList::add);
        return userRecordList;
    }

//    @GetMapping("/findByUserId")
//    @ResponseBody
//    @CrossOrigin(origins = "*")
//    public List<UserRecord> findByUserId(@RequestParam String userId) {
//        Iterable<UserRecord> userRecords = this.userRecordRepository.findByUserId(userId);
//        List<UserRecord> userRecordList = new ArrayList<>();
//        userRecords.forEach(userRecordList::add);
//        return userRecordList;
//    }
}

