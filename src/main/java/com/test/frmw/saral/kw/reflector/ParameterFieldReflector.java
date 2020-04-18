package com.test.frmw.saral.kw.reflector;

import com.test.frmw.saral.kw.parameters.Param;
import com.test.frmw.saral.kw.parameters.ParameterDefinition;

import java.lang.reflect.Field;

public class ParameterFieldReflector {

    private Field parameterField;
    public ParameterFieldReflector(Field field){
        this.parameterField = field;
    }

    public ParameterDefinition getParameterDefinition(){
        Param parameterAnnotation = parameterField.getAnnotation(Param.class);
        ParameterDefinition parameterDefinition = new ParameterDefinition();

        parameterDefinition.setParamName(parameterField.getName());
        parameterDefinition.setParameterType(parameterField.getType());
        parameterDefinition.setFriendlyName(getDefaultOrAnnotatedValue(parameterAnnotation.name(), parameterField.getName()));
        parameterDefinition.setDescription(getDefaultOrAnnotatedValue(parameterAnnotation.description(), parameterField.getName()));
        return parameterDefinition;
    }

    private String getDefaultOrAnnotatedValue(String annotatedValue, String defaultValue) {
        return (annotatedValue == null || annotatedValue.isEmpty()) ? defaultValue : annotatedValue;
    }
}
