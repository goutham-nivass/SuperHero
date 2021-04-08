package com.nv.superheroapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Navneet Krishna on 17/12/18.
 */
public class Powerstats {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("intelligence")
    @Expose
    private String intelligence;
    @SerializedName("strength")
    @Expose
    private String strength;
    @SerializedName("speed")
    @Expose
    private String speed;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
