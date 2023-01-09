package com.mert.xamplejava.model.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DefinitionResponse {
    @SerializedName("word")
    private final String word;

    @SerializedName("meanings")
    private Meanings[] meanings;

    public DefinitionResponse(String word, Meanings[] meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public Meanings[] getMeanings() {
        return meanings;
    }

    public void setMeanings(Meanings[] meanings) {
        this.meanings = meanings;
    }
}
