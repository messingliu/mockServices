package com.tantan.ranker.models;

public class Meta {

  private long code;
  private String message;

  public Meta() {
  }

  public Meta(long code, String message) {
    this.code = code;
    this.message = message;
  }

  public long getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public Meta setCode(long code) {
    this.code = code;
    return this;
  }

  public Meta setMessage(String message) {
    this.message = message;
    return this;
  }

}

