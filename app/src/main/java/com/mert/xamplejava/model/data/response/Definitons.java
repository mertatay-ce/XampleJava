package com.mert.xamplejava.model.data.response;

import com.google.gson.annotations.SerializedName;

public class Definitons {
    @SerializedName("definition")
    private String definition;

    @SerializedName("example")
    private String example;

    public Definitons(String definition, String example) {
        this.definition = definition;
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
