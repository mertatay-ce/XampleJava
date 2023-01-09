package com.mert.xamplejava.model.data;

import com.google.gson.annotations.SerializedName;

public class DefinitionModel {
    private String definition;
    private String definition_example;
    private String id;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinition_example() {
        return definition_example;
    }

    public void setDefinition_example(String definition_example) {
        this.definition_example = definition_example;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
