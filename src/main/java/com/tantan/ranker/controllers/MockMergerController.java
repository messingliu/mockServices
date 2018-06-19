package com.tantan.ranker.controllers;

import avro.shaded.com.google.common.collect.Lists;
import com.tantan.ranker.models.*;
import com.tantan.ranker.models.ai.*;
import com.tantan.ranker.service.ConfigureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
public class MockMergerController {
  private static final Logger LOGGER = LoggerFactory.getLogger(MockMergerController.class);

  private static long LINE_COUNT = 10000;
  private static Map<Long, Boolean> userGenderMap = new HashMap<>(); // true: male
  private static List<Long> maleUsers = new ArrayList<>();
  private static List<Long> femaleUsers = new ArrayList<>();

  @Autowired
  private ConfigureService configureService;

  static {
    FileReader fileReader;
    try {
      fileReader = new FileReader("user_ids");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        try {
          String[] lines = line.split("\t");
          long userId = Long.parseLong(lines[0].trim());
          boolean male = 1 == Integer.parseInt(lines[1].trim());
          if (male) {
            maleUsers.add(userId);
          } else {
            femaleUsers.add(userId);
          }
          userGenderMap.put(userId, male);
        } catch (Throwable t) {}
      }
      LOGGER.info("Read {} user ids", userGenderMap.size());
      bufferedReader.close();
      fileReader.close();
    } catch (Exception e) {
      LOGGER.error("Read file 'user_ids' error", e);
    }
  }

  @RequestMapping("/users")
  public CompletableFuture<Resp> suggestedUsers(@RequestParam(value="user_id") Long userId,
                                     @RequestParam(value="limit", defaultValue = "25") Integer limit,
                                     @RequestParam(value="search") String search,
                                     @RequestParam(value="filter", defaultValue = "") String filter,
                                     @RequestParam(value="with") String with) throws InterruptedException {
    long start = System.currentTimeMillis();
    long numLines = Math.max(LINE_COUNT, limit);
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    Thread.sleep((long) (Math.max(25, Math.sqrt(100) * random.nextGaussian() + configureService.getMergerDelay()))); // Gaussian random delay

    List<User> userList = new ArrayList<User>();
    int index = (int) ((Math.random() * numLines + limit) % numLines);
    for ( int i = 0; i < limit; i ++) {
      long suggestedUserId;
      if ((i & 0x01) == 0) {
        suggestedUserId = maleUsers.get(Math.min((index + i) % (int)numLines, maleUsers.size() - 1));
      } else {
        suggestedUserId = femaleUsers.get(Math.min((index + i) % (int)numLines, femaleUsers.size() - 1));
      }
      User user = new User().setId(suggestedUserId)
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
                                                @RequestParam(value="search", defaultValue = "") String search,
                                                @RequestParam(value="filter", defaultValue = "") String filter,
                                                @RequestParam(value="with", defaultValue = "") String with) throws InterruptedException {
    long start = System.currentTimeMillis();
    Map<Long, L1User> userMap = new HashMap<>();
    List<L1User> userList = new ArrayList<>();
    int repeated = 0;
    try {
      Random random = new Random();
      random.setSeed(System.currentTimeMillis());
      Thread.sleep((long) (Math.max(50, Math.sqrt(500) * random.nextGaussian() + configureService.getMergerDelay()))); // Gaussian random delay

      char[] rawData = new char[configureService.getResponseBytes() / 2];
      Arrays.fill(rawData, 'A');
      Boolean male = userGenderMap.get(userId);
      for (int i = 0; userMap.size() < limit; i++) {
        long suggestUserId;
        if (male == null) {
          if ((i & 0x01) == 0) {
            suggestUserId = femaleUsers.get(random.nextInt(femaleUsers.size()));
          } else {
            suggestUserId = maleUsers.get(random.nextInt(maleUsers.size()));
          }
        } else if (male) {
          suggestUserId = femaleUsers.get(random.nextInt(femaleUsers.size()));
        } else {
          suggestUserId = maleUsers.get(random.nextInt(maleUsers.size()));
        }
        if (userMap.containsKey(suggestUserId)) {
          repeated++;
        } else {
          L1User user = new L1User();
          user.setId(suggestUserId);
          user.setRawData(new String(rawData));
          userMap.put(suggestUserId, user);
          userList.add(user);
        }
      }
    } catch (Exception e) {
      LOGGER.error("suggestedUsers2 fail", e);
    } finally {
      LOGGER.info("[LogType: Merger][ClientName: suggestedUsers2][ResponseTime: {}] Repeated={}", System.currentTimeMillis() - start, repeated);
    }

    return userList;
  }


  @RequestMapping("/candidates")
  public AIResp suggestedUsers3(@RequestParam(value = "user_id") Long userId,
                                @RequestParam(value = "limit", defaultValue = "25") Integer limit) {

    long start = System.currentTimeMillis();
    Random random = new Random();
    random.setSeed(start);
    AIResp resp = new AIResp();
    resp.setMeta(new Meta(200, "OK"));
    AIData data = new AIData();
    resp.setData(data);
    UserInfoResponse userInfo = new UserInfoResponse();
    data.setUserInfo(userInfo);
    userInfo.setReason("");
    userInfo.setStatus(0);
    userInfo.setType("ALL");
    Boolean male = userGenderMap.get(userId);
    male = male == null ? false : male;
    userInfo.setRecord(getUserRecord(userId, male));
    data.setCounterResponse(new CounterResponse(0, "", getCounterRecord(userId, random)));
    data.setpCounterResponse(new CounterResponse(0, "", getPCounterRecord(userId, random)));
    data.setFilterSearchResult(new FilterSearchResult(0, "", Lists.newArrayList(), Lists.newArrayList(), Lists.newArrayList(), Lists.newArrayList()));

    try {
      Thread.sleep((long) (Math.max(10, Math.sqrt(50) * random.nextGaussian() + 20))); // Gaussian random delay

      List<UserSuggestRecord> suggestedUsers = Lists.newArrayList();
      data.setUserSuggested(suggestedUsers);
      List<Long> suggestUserIds = getSuggestUserIds(male, limit);
      data.setUserSuggested(getSuggestUsers(suggestUserIds, ! male));
      List<Long> boostUserIds = getSuggestUserIds(male, (int)(limit * 0.01));
      data.setUserBoosted(getSuggestUsers(boostUserIds, ! male));
      data.setSuperLiked(boostUserIds.size() > 0 ? Lists.newArrayList(boostUserIds.get(0)) : Collections.emptyList());
    } catch (Exception e) {
      LOGGER.error("suggestedUsers3 fail", e);
      resp.setMeta(new Meta(500, "ERROR"));
    } finally {
      LOGGER.info("[LogType: Merger][ClientName: suggestedUsers3][ResponseTime: {}] Repeated={}", System.currentTimeMillis() - start);
    }
    resp.setExtra(new Extra(false, data.getUserSuggested() == null ? 0 : data.getUserSuggested().size()));

    return resp;
  }

  private Map<String, String> getUserRecord(Long userId, boolean male) {
    Map<String, String> record = new HashMap<>();
    record.put(UserInfoKey.ID.getName(), Long.toString(userId));
    record.put(UserInfoKey.GENDER.getName(), male ? Integer.toString(Gender.MALE.getName()) : Integer.toString(Gender.FEMALE.getName()));
    record.put(UserInfoKey.LOOKING_FOR_GENDER.getName(), male ? Integer.toString(Gender.FEMALE.getName()) : Integer.toString(Gender.MALE.getName()));
    return record;
  }

  private List<CounterRecord> getCounterRecord(long userId, Random random) {
    List<CounterRecord> records = Lists.newArrayList();
    CounterRecord record0 = new CounterRecord();
    record0.setUserId(userId);
    record0.setType(CounterType.COUNTER_LIKE_RATING);
    record0.setCount(random.nextInt(150));
    records.add(record0);
    CounterRecord record1 = new CounterRecord();
    record1.setUserId(userId);
    record1.setType(CounterType.COUNTER_MATCHED);
    record1.setCount(random.nextInt(3));
    records.add(record1);
    return records;
  }

  private List<CounterRecord> getPCounterRecord(long userId, Random random) {
    List<CounterRecord> records = Lists.newArrayList();
    List<Integer> types = Lists.newArrayList(CounterType.COUNTER_LIKED, CounterType.COUNTER_DISLIKED, CounterType.COUNTER_DEFAULT,
        CounterType.COUNTER_BLOCKED, CounterType.COUNTER_SUPERLIKED);
    for (Integer type : types) {
      CounterRecord record = new CounterRecord();
      record.setUserId(userId);
      record.setType(type);
      record.setCount(random.nextInt(5));
      records.add(record);
    }
    return records;
  }



  private List<Long> getSuggestUserIds(boolean male, int limit) {
    List<Long> userIds = Lists.newArrayList();
    if (limit <=0 || limit > 100000) {
      return userIds;
    }
    Set<Long> set = new HashSet<>();
    List<Long> userList = male ? femaleUsers : maleUsers;
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    while (set.size() < limit) {
      Long id = userList.get(random.nextInt(userList.size()));
      if (! set.contains(id)) {
        set.add(id);
        userIds.add(id);
      }
    }

    return userIds;
  }

  private List<UserSuggestRecord> getSuggestUsers(List<Long> userIds, boolean male) {
    if (userIds == null) {
      return Collections.emptyList();
    }
    List<UserSuggestRecord> users = Lists.newArrayList();
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    for (Long userId : userIds) {
      UserSuggestRecord suggested = new UserSuggestRecord();
      suggested.setId(userId);
      suggested.setScore(random.nextFloat());
      suggested.setDistance(random.nextFloat() * 10000);
      suggested.setPolularity(random.nextFloat());
      suggested.setStudy(random.nextInt(2));
      suggested.setLastActivity(random.nextInt(84000));
      suggested.setBoostLevel(random.nextInt(5));
      suggested.setGender(male ? Gender.MALE.getName() : Gender.FEMALE.getName());
      users.add(suggested);
    }

    return users;
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
