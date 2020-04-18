package com.test.frmw.saral.kw.mapper;

import com.test.frmw.saral.exceptions.KeywordNotFoundException;
import com.test.frmw.saral.exceptions.ParameterDoesNotExistInDbException;
import com.test.frmw.saral.kw.KeywordDefinition;
import com.test.frmw.saral.kw.parameters.ParameterDefinition;
import com.test.frmw.saral.kw.registry.DatabaseKeywordRegistry;
import com.test.frmw.saral.model.KeywordDetails;
import com.test.frmw.saral.model.ParameterDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class KeywordDefinitionDetailMapper {

    @Autowired
    private DatabaseKeywordRegistry dbKwRegistry;

    @Autowired
    ParameterDefinitionDetailMapper paramDefinitionDetailMapper;

    public KeywordDefinition addKwDetailsToKwDefinition(KeywordDefinition kwDefinition) throws ParameterDoesNotExistInDbException {
        KeywordDetails kwDetail;

        try {
            kwDetail = dbKwRegistry.getDetailsByKeywordNameAndImplementingClassName(
                    kwDefinition.getName(), kwDefinition.getImplementingClass().getName());


        } catch (KeywordNotFoundException e) {

            //New keyword. Add kw to database.
            kwDetail = getKwDetailsFromKwDefinition(kwDefinition);
            kwDetail = dbKwRegistry.addKeywordToDb(kwDetail);

        }


        return addKwDetailsToKwDefinition(kwDefinition, kwDetail);
    }

    private KeywordDefinition addKwDetailsToKwDefinition(KeywordDefinition kwDefinition, KeywordDetails kwDetail) throws ParameterDoesNotExistInDbException {

        kwDefinition.setId(kwDetail.getId());

        for (ParameterDefinition param : kwDefinition.getParameterDetails()) {
            param.setKeywordDefinition(kwDefinition);
            Optional<ParameterDetails> matchingParam = kwDetail.getParameterDetails().stream().
                    filter(pd -> pd.getName().equals(param.getParamName())).
                    findFirst();

            if (!matchingParam.isPresent()) {
                throw new ParameterDoesNotExistInDbException(String.format(
                        "Parameter -- {%s} does not exist in keyword with id {%d}",
                        param.getParamName(), kwDetail.getId()));
            }
//
//

            param.setId(matchingParam.get().getId());
        }
        return kwDefinition;
    }

    public KeywordDetails getKwDetailsFromKwDefinition(KeywordDefinition kwDefinition) {

        KeywordDetails kwDetails = new KeywordDetails();

        kwDetails.setImplementingClass(kwDefinition.getImplementingClass().getName());
        kwDetails.setName(kwDefinition.getName());

        kwDetails.setParameterDetails(kwDefinition.getParameterDetails().stream().map(param -> {
            ParameterDetails pd = paramDefinitionDetailMapper.convertParamDetailFromDefinition(param);
            pd.setKeyword(kwDetails);
            return pd;
        }).collect(Collectors.toList()));

        return kwDetails;
    }


}
