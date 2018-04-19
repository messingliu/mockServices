package com.tantan.ranker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resp {

  @JsonProperty("meta")
  private Meta meta;

  @JsonProperty("data")
  private UserList data;


  @JsonProperty("extra")
  private Extra extra;

  public Resp() {
  }

  public Resp(Meta meta, UserList data, Extra extra) {
    this.meta = meta;
    this.data = data;
    this.extra = extra;
  }

  public Meta getMeta() {
    return meta;
  }

  public UserList getData() {
    return data;
  }

  public Extra getExtra() {
    return extra;
  }

  public Resp setMeta(Meta meta) {
    this.meta = meta;
    return this;
  }

  public Resp setData(UserList data) {
    this.data = data;
    return this;
  }

  public Resp setExtra(Extra extra) {
    this.extra = extra;
    return this;
  }

}
