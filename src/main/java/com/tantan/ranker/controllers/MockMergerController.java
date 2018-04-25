package com.tantan.ranker.controllers;

import com.tantan.ranker.models.*;
import com.tantan.ranker.service.ConfigureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
public class MockMergerController {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  private static long LINE_COUNT = 10000;
  private static List<Long> idList;

  @Autowired
  private ConfigureService configureService;

  static {
    FileReader fileReader;
    try {
      fileReader = new FileReader("10000users");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      idList = new ArrayList<Long>();
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        idList.add(Long.parseLong(line.trim()));
      }
      bufferedReader.close();
      fileReader.close();
    } catch (Exception e) {
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
    long numLines = Math.max(LINE_COUNT, limit);
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    Thread.sleep((long) (Math.max(50, Math.sqrt(500) * random.nextGaussian() + configureService.getMergerDelay()))); // Gaussian random delay

    List<User> userList = new ArrayList<User>();
    int index = (int) ((Math.random() * numLines + limit) % numLines);
    for ( int i = 0; i < limit; i ++) {
      long suggestedUserId = idList.get(Math.min((index + i) % (int)numLines, idList.size() - 1));
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

  // 返回20K*64B数据， configurable
  @RequestMapping("/mockMerger2")
  public List<L1User> suggestedUsers2(@RequestParam(value="user_id") Long userId,
                                                @RequestParam(value="limit", defaultValue = "25") Integer limit,
                                                @RequestParam(value="search") String search,
                                                @RequestParam(value="filter", defaultValue = "") String filter,
                                                @RequestParam(value="with") String with) throws InterruptedException {
    long start = System.currentTimeMillis();
    List<L1User> userList = new ArrayList<>();
    try {
      Random random = new Random();
      random.setSeed(System.currentTimeMillis());
      Thread.sleep((long) (Math.max(50, Math.sqrt(500) * random.nextGaussian() + configureService.getMergerDelay()))); // Gaussian random delay

      final int size = idList.size();
      char[] rawData = new char[configureService.getResponseBytes() / 2];
      Arrays.fill(rawData, 'A');
      for (int i = 0; i < limit; i++) {
        int index = random.nextInt(size);
        L1User user = new L1User();
        user.setId(index);
        user.setRawData(new String(rawData));
        userList.add(user);
      }
    } catch (Exception e) {
      LOGGER.error("suggestedUsers2 fail", e);
    } finally {
      LOGGER.info("[LogType: Merger][ClientName: suggestedUsers2][ResponseTime: {}]", System.currentTimeMillis() - start);
    }

    return userList;
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
