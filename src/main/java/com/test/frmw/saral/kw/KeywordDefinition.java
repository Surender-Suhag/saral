package com.test.frmw.saral.kw;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.frmw.saral.kw.parameters.ParameterDefinition;

import java.util.HashSet;
import java.util.Set;

public class KeywordDefinition {

    private Long id;
    private String name;
    private String description;
    private Set<ParameterDefinition> parameterDetails;

    @JsonIgnore
    private Class<? extends AutomationKeyword> implementingClass;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void addParameterDetails(ParameterDefinition parameter){
        if(this.parameterDetails == null)
            parameterDetails = new HashSet<>();

        this.parameterDetails.add(parameter);
    }

    public Set<ParameterDefinition> getParameterDetails() {
        return parameterDetails;
    }

    public void setParameterDetails(Set<ParameterDefinition> parameterDetails) {
        this.parameterDetails = parameterDetails;
    }

    public Class<? extends AutomationKeyword> getImplementingClass() {
        return implementingClass;
    }

    public void setImplementingClass(Class<? extends AutomationKeyword> implementingClass) {
        this.implementingClass = implementingClass;
    }
}
