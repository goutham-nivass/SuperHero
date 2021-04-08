package com.nv.superheroapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Navneet Krishna on 17/12/18.
 */
public class HeroResponse {
    @SerializedName("response")
    @Expose
    private String resp;
    @SerializedName("results-for")
    @Expose
    private String resultsfor;
    @SerializedName("results")
    @Expose
    private List<HerosArray> results = null;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getResultsfor() {
        return resultsfor;
    }

    public void setResultsfor(String resultsfor) {
        this.resultsfor = resultsfor;
    }

    public List<HerosArray> getResults() {
        return results;
    }

    public void setResults(List<HerosArray> results) {
        this.results = results;
    }
}
