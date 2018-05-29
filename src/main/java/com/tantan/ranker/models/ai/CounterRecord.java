package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounterRecord {
    @JsonProperty("uid")
    private long userId;
    @JsonProperty("type")
    private int type;
    @JsonProperty("count")
    private int count;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
