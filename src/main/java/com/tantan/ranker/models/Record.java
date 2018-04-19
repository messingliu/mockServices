package com.tantan.ranker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {

  private String REC_ID;
  private String id;
  private String gender;
  private String hide_contact;
  private String country_code;
  private String search_radius;
  private String looking_for_gender;
  private String search_min_age;
  private String search_max_age;
  private String intent;
  private String like_rating;
  private String status;
  private String archived_status;
  private String work_active;
  private String study_active;
  private String boost_level;
  private String latest_location_x;
  private String latest_location_y;
  private String popularity;
  private String score;
  private String last_activity;
  private String created_time;
  private String birthdate;
  private String updated_time;
  private String boost_expired_time;

  public String getREC_ID() {
    return REC_ID;
  }

  public String getId() {
    return id;
  }

  public String getGender() {
    return gender;
  }

  public String getHide_contact() {
    return hide_contact;
  }

  public String getCountry_code() {
    return country_code;
  }

  public String getSearch_radius() {
    return search_radius;
  }

  public String getLooking_for_gender() {
    return looking_for_gender;
  }

  public String getSearch_min_age() {
    return search_min_age;
  }

  public String getSearch_max_age() {
    return search_max_age;
  }

  public String getIntent() {
    return intent;
  }

  public String getLike_rating() {
    return like_rating;
  }

  public String getStatus() {
    return status;
  }

  public String getArchived_status() {
    return archived_status;
  }

  public String getWork_active() {
    return work_active;
  }

  public String getStudy_active() {
    return study_active;
  }

  public String getBoost_level() {
    return boost_level;
  }

  public String getLatest_location_x() {
    return latest_location_x;
  }

  public String getLatest_location_y() {
    return latest_location_y;
  }

  public String getPopularity() {
    return popularity;
  }

  public String getScore() {
    return score;
  }

  public String getLast_activity() {
    return last_activity;
  }

  public String getCreated_time() {
    return created_time;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public String getUpdated_time() {
    return updated_time;
  }

  public String getBoost_expired_time() {
    return boost_expired_time;
  }

  public void setREC_ID(String REC_ID) {
    this.REC_ID = REC_ID;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setHide_contact(String hide_contact) {
    this.hide_contact = hide_contact;
  }

  public void setCountry_code(String country_code) {
    this.country_code = country_code;
  }

  public void setSearch_radius(String search_radius) {
    this.search_radius = search_radius;
  }

  public void setLooking_for_gender(String looking_for_gender) {
    this.looking_for_gender = looking_for_gender;
  }

  public void setSearch_min_age(String search_min_age) {
    this.search_min_age = search_min_age;
  }

  public void setSearch_max_age(String search_max_age) {
    this.search_max_age = search_max_age;
  }

  public void setIntent(String intent) {
    this.intent = intent;
  }

  public void setLike_rating(String like_rating) {
    this.like_rating = like_rating;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setArchived_status(String archived_status) {
    this.archived_status = archived_status;
  }

  public void setWork_active(String work_active) {
    this.work_active = work_active;
  }

  public void setStudy_active(String study_active) {
    this.study_active = study_active;
  }

  public void setBoost_level(String boost_level) {
    this.boost_level = boost_level;
  }

  public void setLatest_location_x(String latest_location_x) {
    this.latest_location_x = latest_location_x;
  }

  public void setLatest_location_y(String latest_location_y) {
    this.latest_location_y = latest_location_y;
  }

  public void setPopularity(String popularity) {
    this.popularity = popularity;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public void setLast_activity(String last_activity) {
    this.last_activity = last_activity;
  }

  public void setCreated_time(String created_time) {
    this.created_time = created_time;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public void setUpdated_time(String updated_time) {
    this.updated_time = updated_time;
  }

  public void setBoost_expired_time(String boost_expired_time) {
    this.boost_expired_time = boost_expired_time;
  }

  public Record() {
  }
}
