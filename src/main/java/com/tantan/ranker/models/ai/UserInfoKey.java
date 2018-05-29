package com.tantan.ranker.models.ai;

public enum UserInfoKey {
  ID("id"),
  LOOKING_FOR_GENDER("looking_for_gender");

  private final String name;

  UserInfoKey(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public enum FeatureInfoKey {
    ID("id"),
    LOOKING_FOR_GENDER("looking_for_gender"),
    D("d"),
    P("p"),
    U("u"),
    T("t"),
    A("a");

    private final String name;

    FeatureInfoKey(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

  }
}
