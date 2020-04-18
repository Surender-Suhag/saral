package com.test.frmw.saral.kw.registry;

import com.test.frmw.saral.exceptions.DuplicateParameterException;
import com.test.frmw.saral.exceptions.ParameterDoesNotExistInDbException;
import com.test.frmw.saral.kw.AutomationKeyword;
import com.test.frmw.saral.kw.KeywordDefinition;
import com.test.frmw.saral.kw.reflector.KeywordClassReflector;
import com.test.frmw.saral.kw.scanner.ClassPathScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component("loadedKeywords")
public class LoadedKeywordsRegistry implements KeywordRegistry {

    private static final Logger logger = LoggerFactory.getLogger(LoadedKeywordsRegistry.class);

    private static final Class baseAutomationKeywordClass = AutomationKeyword.class;
    private static final ClassPathScanner cpScanner = new ClassPathScanner(baseAutomationKeywordClass);

    private Map<String, KeywordDefinition> keywords = new HashMap<>();

    @Autowired
    private DatabaseKeywordRegistry dbKwRegistry;

    @Autowired
    private SetMoreKwDefinitionValues setMoreKwDefinitionValues;

    //Todo  change list to map
    private List<KeywordDefinition> loadedKeywordDefinitions;

    /**
     * Scan the classpath for classes implementing AutomationKeyword interface.
     * Process the classes to read the keyword parameter details
     */

    @PostConstruct
    private void loadKeywords() {

        //Get  classes implementing AutomationKeyword interface
        Set<Class> loadedKeywords = cpScanner.getClasses();

        logger.info("Parsing classes for keyword definitions and parameters");

        loadedKeywordDefinitions = loadedKeywords.stream().filter(
                kwClass -> !(Modifier.isAbstract(kwClass.getModifiers()) || Modifier.isInterface(kwClass.getModifiers()))).
                //Create keyword definition for all implementing classes
                        map(kwClass -> {
                    try {
                        return new KeywordClassReflector(kwClass).getKeywordDefinition();
                    } catch (DuplicateParameterException e) {
                        logger.error(e.getMessage(), e);
                    }
                    return null;
                }).
                        filter(kw -> kw != null).
                        //add ID and parameter details
                        map(keywordDefinition -> {
                            try {
                                return setMoreKwDefinitionValues.addDetailsToKeywordDefinition(keywordDefinition);
                            } catch (ParameterDoesNotExistInDbException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }).
                        filter(kw -> kw != null).
                        collect(Collectors.toList());


    }


    public List<KeywordDefinition> getKeywordDefinitions() {
        return loadedKeywordDefinitions;
    }


}
