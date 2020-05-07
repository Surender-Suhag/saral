package com.test.frmw.saral.kw.reflector;

import com.test.frmw.saral.annotations.Param;
import com.test.frmw.saral.kw.parameters.ParameterDefinition;
import com.test.frmw.saral.util.StringUtil;

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
        parameterDefinition.setFriendlyName(StringUtil.getNonEmptyValue(parameterAnnotation.name(), parameterField.getName()));
        parameterDefinition.setDescription(StringUtil.getNonEmptyValue(parameterAnnotation.description(), parameterField.getName()));
        return parameterDefinition;
    }


}
