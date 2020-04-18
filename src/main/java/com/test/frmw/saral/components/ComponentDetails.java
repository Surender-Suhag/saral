package com.test.frmw.saral.components;

import java.util.List;

public class ComponentDetails {

    private String name;
    private String description;
    private List<ComponentKeyword> componentKeywords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ComponentKeyword> getComponentKeywords() {
        return componentKeywords;
    }

    public void setComponentKeywords(List<ComponentKeyword> componentKeywords) {
        this.componentKeywords = componentKeywords;
    }
}
