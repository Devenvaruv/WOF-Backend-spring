package com.wheelOfFortune.gameRecord;

import com.google.api.client.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
//@SpringBootApplication
public class GameRecordApplication {
	@Autowired
	GameRecordRepository gameRecordRepository;

	public static void main(String[] args) {
		SpringApplication.run(GameRecordApplication.class, args);
	}

	@ShellMethod("Saves a gameRecord to Cloud Datastore: save-gameRecord <userid> <score> <date>")
	public String saveGameRecord(String userId, int score , String date) {
		GameRecord savedGameRecord = this.gameRecordRepository.save(new GameRecord(userId , score , date));
		return savedGameRecord.toString();
	}

	@ShellMethod("Loads all GameRecord")
	public String findAllGameRecord() {
		Iterable<GameRecord> gameRecords = this.gameRecordRepository.findAll();
		return Lists.newArrayList(gameRecords).toString();
	}

	@ShellMethod("Loads record by user: find-by-userID <userId>")
	public String findByUserId(String userId) {
		List<GameRecord> gameRecords = this.gameRecordRepository.findByUserId(userId);
		return gameRecords.toString();
	}

	@ShellMethod("remove all records")
	public void removeAllGameRecords() {
		this.gameRecordRepository.deleteAll();
	}


}
