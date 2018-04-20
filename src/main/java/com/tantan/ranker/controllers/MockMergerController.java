package com.tantan.ranker.controllers;

import com.tantan.ranker.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
public class MockMergerController {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  long MERGER_DELAY = 200;
  long LINE_COUNT = 10000;
  public static List<String> idList;
  static {
    FileReader fileReader = null;
    try {
      fileReader = new FileReader("10000users");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      idList = new ArrayList<String>();
      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        idList.add(line);
      }
      bufferedReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @RequestMapping("/mockMerger")
  public CompletableFuture<Resp> suggestedUsers(@RequestParam(value="user_id") Long userId,
                                     @RequestParam(value="limit", defaultValue = "25") Integer limit,
                                     @RequestParam(value="search") String search,
                                     @RequestParam(value="filter", defaultValue = "") String filter,
                                     @RequestParam(value="with") String with) throws InterruptedException {
    long start = System.currentTimeMillis();
    Random random = new Random();
    Thread.sleep((long) (Math.max(50, Math.sqrt(500) * random.nextGaussian() + MERGER_DELAY))); // Gaussian random delay

    List<User> userList = new ArrayList<User>();
    Stream<String> lines = null;
    try {
      lines = Files.lines(Paths.get("10000users"));
    } catch (IOException e) {
      e.printStackTrace();
      return CompletableFuture.completedFuture(null);
    }
    int index = (int) ((Math.random() * LINE_COUNT + limit) % LINE_COUNT);
    for ( int i = 0; i < limit; i ++) {
      int suggestedUserId = Integer.valueOf(idList.get(Math.min(index + i, idList.size() - 1)).trim());
      User user = new User().setId(suggestedUserId)
              .setDistance(100 * (float)Math.random())
              .setLastactivity("none")
              .setPopularity(100 * (float)Math.random())
              .setScore(100 * (float)Math.random())
              .setType("type");
      userList.add(user);
    }

    Resp resp = new Resp().setMeta(new Meta(limit, "test"))
            .setData(new UserList(userList)).setExtra(new Extra(false, limit));

    long delay = (System.currentTimeMillis() - start);
    LOGGER.info("Calling mock delay is: " + delay);

    return CompletableFuture.completedFuture(resp);
  }

  @RequestMapping("/mockDelay")
  public CompletableFuture<String> mockDelay(@RequestParam(value="delay") Long delay) throws InterruptedException {
    long start = System.currentTimeMillis();
    Random random = new Random();
    Thread.sleep((long) (Math.max(0, Math.sqrt(delay) * random.nextGaussian() + delay))); // Gaussian random delay
    LOGGER.info("Calling mock delay is: " + (System.currentTimeMillis() - start));
    return CompletableFuture.completedFuture("Mock delay");
  }
}
