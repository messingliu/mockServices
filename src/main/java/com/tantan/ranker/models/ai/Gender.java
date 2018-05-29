package com.tantan.ranker.models.ai;

public enum Gender {
  FEMALE(2),
  MALE(1);

  private final int name;

  Gender(int name) {
    this.name = name;
  }

  public int getName() {
    return name;
  }
}
