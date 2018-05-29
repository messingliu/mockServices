package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FilterSearchResult {
    @JsonProperty("status")
    private int status;    // `protobuf:"varint,1,opt,name=Status" json:"status,omitempty"`
    @JsonProperty("reason")
    private String reason;    // `protobuf:"bytes,2,opt,name=Reason" json:"reason,omitempty"`

    public FilterSearchResult(int status, String reason, List<Long> id, List<Long> boost, List<Long> superliked, List<Long> liked) {
        this.status = status;
        this.reason = reason;
        this.id = id;
        this.boost = boost;
        this.superliked = superliked;
        this.liked = liked;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }

    public List<Long> getBoost() {
        return boost;
    }

    public void setBoost(List<Long> boost) {
        this.boost = boost;
    }

    public List<Long> getSuperliked() {
        return superliked;
    }

    public void setSuperliked(List<Long> superliked) {
        this.superliked = superliked;
    }

    public List<Long> getLiked() {
        return liked;
    }

    public void setLiked(List<Long> liked) {
        this.liked = liked;
    }

    @JsonProperty("id")
    private List<Long> id; // `protobuf:"varint,3,rep,packed,name=Id" json:"id,omitempty"`
    @JsonProperty("boost")
    private List<Long> boost; // `protobuf:"varint,4,rep,packed,name=Boost" json:"boost,omitempty"`
    @JsonProperty("superliked")
    private List<Long> superliked; // `protobuf:"varint,5,rep,packed,name=Superliked" json:"superboost,omitempty"`

    @JsonProperty("liked")
    private List<Long> liked; // `protobuf:"varint,6,rep,packed,name=Liked" json:"liked,omitempty"`


}
