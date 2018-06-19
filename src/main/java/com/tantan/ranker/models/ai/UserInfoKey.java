package com.tantan.ranker.models.ai;

public enum UserInfoKey {
  ID("id"),
  TYPE("type"),
  REASON("reason"),
  REC_ID("REC_ID"),
  ARCHIVED_STATUS("archived_status"),
  BIRTHDATE("birthdate"),
  BOOST_EXPIRED_TIME("boost_expired_time"),
  BOOST_LEVEL("boost_level"),
  COUNTRY_CODE("country_code"),
  CREATED_TIME("created_time"),
  GENDER("gender"),
  HIDE_CONTACT("hide_contact"),
  INTENT("intent"),
  LAST_ACTIVITY("last_activity"),
  LATEST_LOCATION_X("latest_location_x"),
  LATEST_LOCATION_Y("latest_location_y"),
  LIKE_RATING("like_rating"),
  LOOKING_FOR_GENDER("looking_for_gender"),
  POPULARITY("popularity"),
  SEARCH_MAX_AGE("search_max_age"),
  SEARCH_MIN_AGE("search_min_age"),
  SEARCH_RADIUS("search_radius"),
  STATUS("status"),
  STUDY_ACTIVE("study_active"),
  SVIP_EXPIRED_TIME("svip_expired_time"),
  SVIP_LEVEL("svip_level"),
  UPDATED_TIME("updated_time"),
  WORK_ACTIVE("work_active");

  private final String name;

  UserInfoKey(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
