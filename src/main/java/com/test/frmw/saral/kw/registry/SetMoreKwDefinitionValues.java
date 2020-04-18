package com.test.frmw.saral.kw.registry;

import com.test.frmw.saral.exceptions.ParameterDoesNotExistInDbException;
import com.test.frmw.saral.kw.KeywordDefinition;
import com.test.frmw.saral.kw.mapper.KeywordDefinitionDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class SetMoreKwDefinitionValues {
    private static final Logger logger = LoggerFactory.getLogger(SetMoreKwDefinitionValues.class);

    @Autowired
    private KeywordDefinitionDetailMapper kwDefinitionDetailMapper;

    public KeywordDefinition addDetailsToKeywordDefinition(KeywordDefinition keywordDefinition) throws ParameterDoesNotExistInDbException {
        return kwDefinitionDetailMapper.addKwDetailsToKwDefinition(keywordDefinition);
    }

}