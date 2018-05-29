package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CounterResponse {

    @JsonProperty("status")
    private int status; //  `json:"status"`
    @JsonProperty("reason")
    private String reason; // `json:"reason"`
    @JsonProperty("result")
    private List<CounterRecord> results; // `json:"result"`

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<CounterRecord> getResults() {
        return results;
    }

    public void setResults(List<CounterRecord> results) {
        this.results = results;
    }

    public CounterResponse() {

    }


    public CounterResponse(int status, String reason, List<CounterRecord> results) {
        this.status = status;
        this.reason = reason;
        this.results = results;
    }

}
