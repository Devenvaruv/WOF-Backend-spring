package com.wheelOfFortune.UserRecord;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "users")
public class UserRecord {
    @Id
    Long id;

    int score;

    String handle;

    String date;

    String userId;

    public UserRecord(String userId,String handle , int score , String date){
        this.handle = handle;
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

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
                "id=" + id +
                ", score=" + score +
                ", handle='" + handle + '\'' +
                ", date='" + date + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
