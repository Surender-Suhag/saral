package com.test.frmw.saral.controllers;

import com.google.common.collect.Lists;
import com.test.frmw.saral.kw.KeywordDefinition;
import com.test.frmw.saral.services.KeywordsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class KeywordController {

    private static final Logger logger = LoggerFactory.getLogger(KeywordController.class);

    @Autowired
    private KeywordsServices keywordsServices;

    @GetMapping("/keywords")
    public List<KeywordDefinition> getKeywords(){
        return Lists.newArrayList(keywordsServices.getAllKeywords());
    }
}
