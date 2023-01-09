package com.mert.xamplejava.model.data.body;

import com.google.gson.annotations.SerializedName;

public class WordBody {
    @SerializedName("word")
    private String word;

    public WordBody(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
