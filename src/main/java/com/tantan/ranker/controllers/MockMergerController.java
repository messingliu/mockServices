package com.tantan.ranker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class MockMergerController {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  long MERGER_DELAY = 200;

  @RequestMapping("/mockMerger")
  public CompletableFuture<String> suggestedUsers(@RequestParam(value="user_id") Long userId,
                                     @RequestParam(value="limit", defaultValue = "25") Integer limit,
                                     @RequestParam(value="search") String search,
                                     @RequestParam(value="filter", defaultValue = "") String filter,
                                     @RequestParam(value="with") String with) throws InterruptedException {
    LOGGER.info("Calling merger begin at: " + System.currentTimeMillis());
    Thread.sleep((long)(MERGER_DELAY * ( 0.5 + Math.random()))); // 50% to 150% random delay
    LOGGER.info("Calling merger end at: " + System.currentTimeMillis());
    return CompletableFuture.completedFuture("Mock Merger");
  }

  @RequestMapping("/mockDelay")
  public CompletableFuture<String> mockDelay(@RequestParam(value="delay") Long delay) throws InterruptedException {
    LOGGER.info("Calling mock delay begin at: " + System.currentTimeMillis());
    Thread.sleep((long)(delay * ( 0.5 + Math.random()))); // 50% to 150% random delay
    LOGGER.info("Calling mock delay end at: " + System.currentTimeMillis());
    return CompletableFuture.completedFuture("Mock delay");
  }
}
