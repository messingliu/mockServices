package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AIData {
    @JsonProperty("userinfo")
    private UserInfoResponse userInfo;
    @JsonProperty("superliked")
    private List<Long> superLiked;
    @JsonProperty("usersuggested")
    private List<UserSuggestRecord> userSuggested;
    @JsonProperty("userboosted")
    private List<UserSuggestRecord> userBoosted; // `json:"userboosted"`
    @JsonProperty("counter")
    private CounterResponse counterResponse; //     `json:"counter"`
    @JsonProperty("pcounter")
    private CounterResponse pCounterResponse; //    `json:"pcounter"`
    @JsonProperty("filter_list")
    private FilterSearchResult filterSearchResult;

    public AIData() {}

    public AIData(UserInfoResponse userInfo, List<Long> superLiked, List<UserSuggestRecord> userSuggested, List<UserSuggestRecord> userBoosted, CounterResponse counterResponse, CounterResponse pCounterResponse, FilterSearchResult filterSearchResult) {
        this.userInfo = userInfo;
        this.superLiked = superLiked;
        this.userSuggested = userSuggested;
        this.userBoosted = userBoosted;
        this.counterResponse = counterResponse;
        this.pCounterResponse = pCounterResponse;
        this.filterSearchResult = filterSearchResult;
    }


    public FilterSearchResult getFilterSearchResult() {
        return filterSearchResult;
    }

    public void setFilterSearchResult(FilterSearchResult filterSearchResult) {
        this.filterSearchResult = filterSearchResult;
    }

    public UserInfoResponse getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoResponse userInfo) {
        this.userInfo = userInfo;
    }

    public List<Long> getSuperLiked() {
        return superLiked;
    }
    public void setSuperLiked(List<Long> superLiked) {
        this.superLiked = superLiked;
    }

    public List<UserSuggestRecord> getUserSuggested() {
        return userSuggested;
    }

    public void setUserSuggested(List<UserSuggestRecord> userSuggested) {
        this.userSuggested = userSuggested;
    }

    public List<UserSuggestRecord> getUserBoosted() {
        return userBoosted;
    }

    public void setUserBoosted(List<UserSuggestRecord> userBoosted) {
        this.userBoosted = userBoosted;
    }

    public CounterResponse getCounterResponse() {
        return counterResponse;
    }

    public void setCounterResponse(CounterResponse counterResponse) {
        this.counterResponse = counterResponse;
    }

    public CounterResponse getpCounterResponse() {
        return pCounterResponse;
    }

    public void setpCounterResponse(CounterResponse pCounterResponse) {
        this.pCounterResponse = pCounterResponse;
    }
}
