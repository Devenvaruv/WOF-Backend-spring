package com.wheelOfFortune.gameRecord;

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
public class GameRecordController {
    private final GameRecordRepository gameRecordRepository;

    public GameRecordController(GameRecordRepository gameRecordRepository) {
        this.gameRecordRepository = gameRecordRepository;
    }

    @PostMapping("/saveGameRecord")
    @CrossOrigin(origins = "*")
    public String saveGameRecord(@RequestBody GameRecord gameRecord) {
        if (gameRecord == null) {
            return "The book is invalid";
        }
        this.gameRecordRepository.save(gameRecord);
        return "success";
    }

    @GetMapping("/findAllGameRecord")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<GameRecord> findAllGameRecord() {
        Iterable<GameRecord> gameRecords = this.gameRecordRepository.findAll();
        List<GameRecord> gameRecordList = new ArrayList<>();
        gameRecords.forEach(gameRecordList::add);
        return gameRecordList;
    }

    @GetMapping("/findByUserId")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<GameRecord> findByUserId(@RequestParam String userId) {
        Iterable<GameRecord> gameRecords = this.gameRecordRepository.findByUserId(userId);
        List<GameRecord> gameRecordList = new ArrayList<>();
        gameRecords.forEach(gameRecordList::add);
        return gameRecordList;
    }
}
