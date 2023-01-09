package com.mert.xamplejava.model.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Meanings {
    @SerializedName("partOfSpeech")
    private String part_of_speech;

    @SerializedName("definitions")
    private Definitons[] definitons;

    public Meanings(String part_of_speech, Definitons[] definitons) {
        this.part_of_speech = part_of_speech;
        this.definitons = definitons;
    }

    public String getPart_of_speech() {
        return part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }

    public Definitons[]getDefinitons() {
        return definitons;
    }

    public void setDefinitons(Definitons[] definitons) {
        this.definitons = definitons;
    }
}
