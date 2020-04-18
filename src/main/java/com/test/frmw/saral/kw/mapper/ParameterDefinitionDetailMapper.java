package com.test.frmw.saral.kw.mapper;

import com.test.frmw.saral.kw.parameters.ParameterDefinition;
import com.test.frmw.saral.model.ParameterDetails;
import org.springframework.stereotype.Component;

@Component
public class ParameterDefinitionDetailMapper {
    public ParameterDetails convertParamDetailFromDefinition(ParameterDefinition pDefinition) {
        ParameterDetails pDetails = new ParameterDetails();

        pDetails.setName(pDefinition.getParamName());

        return pDetails;
    }
}
