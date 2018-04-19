package com.tantan.ranker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Extra {

  private boolean isInsufficient;
  private int SelectedCount;

  public Extra() {
  }

  public Extra(boolean isInsufficient, int selectedCount) {
    this.isInsufficient = isInsufficient;
    this.SelectedCount = selectedCount;
  }

  public boolean getIsInsufficient() {
    return isInsufficient;
  }

  public int getSelectedCount() {
    return SelectedCount;
  }

  public Extra setIsInsufficient(boolean isInsufficient) {
    this.isInsufficient = isInsufficient;
    return this;
  }

  @JsonProperty("SelectedCount")
  public Extra setSelectedCount(int SelectedCount) {
    this.SelectedCount = SelectedCount;
    return this;
  }
}
