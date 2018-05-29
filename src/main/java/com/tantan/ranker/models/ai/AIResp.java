package com.tantan.ranker.models.ai;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tantan.ranker.models.Extra;
import com.tantan.ranker.models.Meta;

public class AIResp {
    @JsonProperty("meta")
    private Meta meta; //`json:"meta"`
    @JsonProperty("error")
    private String error; //`json:"error,omitempty"`
    @JsonProperty("data")
    private AIData data; //   `json:"data"`
    @JsonProperty("extra")
    private Extra extra; //   `json:"extra"`

    public Meta getMeta() {
        return meta;
    }

    public AIResp setMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AIData getData() {
        return data;
    }

    public AIResp setData(AIData data) {
        this.data = data;
        return this;
    }

    public Extra getExtra() {
        return extra;
    }

    public AIResp setExtra(Extra extra) {
        this.extra = extra;
        return this;
    }

    public AIResp() {
    }

    public AIResp(Meta meta, String error, AIData data, Extra extra) {
        this.meta = meta;
        this.error = error;
        this.data = data;
        this.extra = extra;
    }
}
