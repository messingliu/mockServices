package com.tantan.ranker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class User {

  private long id;
  private float score;
  private float popularity;
  private float distance;
  private String lastactivity;
  private String type;

  public User() {
  }

  public User(long id, float score, float popularity, float distance, String lastactivity, String type) {
    this.id = id;
    this.score = score;
    this.popularity = popularity;
    this.distance = distance;
    this.lastactivity = lastactivity;
    this.type = type;
  }

  public long getId() {
    return id;
  }

  public float getScore() {
    return score;
  }

  public float getPopularity() {
    return popularity;
  }

  public float getDistance() {
    return distance;
  }

  public String getLastactivity() {
    return lastactivity;
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

  public User setPopularity(float popularity) {
    this.popularity = popularity;
    return this;
  }

  public User setDistance(float distance) {
    this.distance = distance;
    return this;
  }

  public User setLastactivity(String lastactivity) {
    this.lastactivity = lastactivity;
    return this;
  }

  public User setType(String type) {
    this.type = type;
    return this;
  }
}
