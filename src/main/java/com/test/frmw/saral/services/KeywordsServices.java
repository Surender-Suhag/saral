package com.test.frmw.saral.services;


import com.test.frmw.saral.kw.KeywordDefinition;
import com.test.frmw.saral.kw.registry.LoadedKeywordsRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordsServices {

    private static Logger logger = LoggerFactory.getLogger(KeywordsServices.class);

    @Autowired
    private LoadedKeywordsRegistry kwRegistry;

    public List<KeywordDefinition> getAllKeywords() {
        logger.info("Keyword Service - Get keyword definitions");
        return kwRegistry.getKeywordDefinitions();
    }
}
