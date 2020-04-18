package com.test.frmw.saral.kw.parameters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.frmw.saral.kw.KeywordDefinition;

public class ParameterDefinition {


    private String friendlyName;
    private String description;
    private long id;

    @JsonIgnore
    private KeywordDefinition keywordDefinition;
//    @JsonIgnore
    private Class parameterType;
    @JsonIgnore
    private String paramName;


    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class getParameterType() {
        return parameterType;
    }

    public void setParameterType(Class parameterType) {
        this.parameterType = parameterType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public KeywordDefinition getKeywordDefinition() {
        return keywordDefinition;
    }

    public void setKeywordDefinition(KeywordDefinition keywordDefinition) {
        this.keywordDefinition = keywordDefinition;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        ParameterDefinition o = (ParameterDefinition) obj;
        return this.paramName.equals(o.paramName)
                &&
                this.friendlyName.equals(o.friendlyName);
    }
}
