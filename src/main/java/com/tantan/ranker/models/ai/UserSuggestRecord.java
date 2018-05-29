package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSuggestRecord {

    @JsonProperty("u")
    private long id; //   `json:"u"`
    @JsonProperty("s")
    private double score; //   `json:"s"`
    @JsonProperty("d")
    private double distance; //   `json:"d"`  0-10000
    //    @JsonProperty("l")
    //  private int  likeRating     ; //   `json:"l"`
    @JsonProperty("a")
    private int lastActivity; //   `json:"a"` 0-84000
    @JsonProperty("p")
    private double polularity; //   `json:"p"` 0-1
    @JsonProperty("c")
    private int createTime; //   `json:"c"`
    @JsonProperty("g")
    private int gender; //   `json:"g"` 1/2
    @JsonProperty("t")
    private int study; //   `json:"t"`  0/1
    @JsonProperty("e")
    private int boostExpiredTime; //   `json:"e"`
    @JsonProperty("o")
    private int boostLevel; //   `json:"o"` 1-4

    public UserSuggestRecord() {

    }

    public UserSuggestRecord(long id, float score, float distance, int lastActivity, float polularity, int createTime, int gender, int study, int boostExpiredTime, int boostLevel) {
        this.id = id;
        this.score = score;
        this.distance = distance;
        this.lastActivity = lastActivity;
        this.polularity = polularity;
        this.createTime = createTime;
        this.gender = gender;
        this.study = study;
        this.boostExpiredTime = boostExpiredTime;
        this.boostLevel = boostLevel;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(int lastActivity) {
        this.lastActivity = lastActivity;
    }

    public double getPolularity() {
        return polularity;
    }

    public void setPolularity(float polularity) {
        this.polularity = polularity;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStudy() {
        return study;
    }

    public void setStudy(int study) {
        this.study = study;
    }

    public int getBoostExpiredTime() {
        return boostExpiredTime;
    }

    public void setBoostExpiredTime(int boostExpiredTime) {
        this.boostExpiredTime = boostExpiredTime;
    }

    public int getBoostLevel() {
        return boostLevel;
    }

    public void setBoostLevel(int boostLevel) {
        this.boostLevel = boostLevel;
    }
}
