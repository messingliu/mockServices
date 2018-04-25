package com.tantan.ranker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("config")
public class ConfigureBean {
  private int mergerDelay;   // merger random sleep in ms
  private int responseBytes;

  public int getMergerDelay() {
    return mergerDelay;
  }

  public void setMergerDelay(int mergerDelay) {
    this.mergerDelay = mergerDelay;
  }

  public int getResponseBytes() {
    return responseBytes;
  }

  public void setResponseBytes(int responseBytes) {
    this.responseBytes = responseBytes;
  }
}
