package com.tantan.ranker.service;

import com.tantan.ranker.config.ConfigureBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ConfigureBean.class)
public class ConfigureService {
  @Autowired
  private ConfigureBean configureBean;

  public int getMergerDelay() {
    return configureBean.getMergerDelay();
  }

  public int getResponseBytes() {
    return configureBean.getResponseBytes();
  }

}
