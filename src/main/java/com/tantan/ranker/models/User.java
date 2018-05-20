package com.tantan.ranker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class User {

  private long id;
  private float score;
  private String type;

  public User() {
  }

  public User(long id, float score, float popularity, float distance, String lastactivity, String type) {
    this.id = id;
    this.score = score;
    this.type = type;
  }

  public long getId() {
    return id;
  }

  public float getScore() {
    return score;
  }

  public String getType() {
    return type;
  }

  public User setId(long id) {
    this.id = id;
    return this;
  }

  public User setScore(float score) {
    this.score = score;
    return this;
  }

  public User setType(String type) {
    this.type = type;
    return this;
  }
}
