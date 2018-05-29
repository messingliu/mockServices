package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UserInfoResponse {

  @JsonProperty("status")
  private int status;

  @JsonProperty("type")
  private String type;

  @JsonProperty("record")
  private Map<String, String> record;

  @JsonProperty("reason")
  private String reason;

  public UserInfoResponse() {
  }

  public UserInfoResponse(int status, String type, Map<String, String> record, String reason) {
    this.status = status;
    this.type = type;
    this.record = record;
    this.reason = reason;
  }

  public int getStatus() {
    return status;
  }

  public String getType() {
    return type;
  }

  public Map<String, String> getRecord() {
    return record;
  }

  public String getReason() {
    return reason;
  }


  public void setStatus(int status) {
    this.status = status;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setRecord(Map<String, String> record) {
    this.record = record;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
