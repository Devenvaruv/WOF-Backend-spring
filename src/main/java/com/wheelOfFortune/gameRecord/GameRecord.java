package com.wheelOfFortune.gameRecord;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "games")
public class GameRecord {
    @Id
    Long id;

    int score;

    String date;

    String userId;

    public GameRecord(String userId , int score , String date){
        this.userId = userId;
        this.score = score;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id=id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "id=" + id +
                ", score=" + score +
                ", date='" + date + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
