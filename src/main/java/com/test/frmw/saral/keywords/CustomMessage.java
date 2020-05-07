package com.test.frmw.saral.keywords;

import com.test.frmw.saral.annotations.Param;
import com.test.frmw.saral.kw.AutomationKeyword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMessage implements AutomationKeyword {

    private static final Logger logger = LoggerFactory.getLogger(CustomMessage.class);

    @Param
    private String name;

    @Override
    public void run() {

    }
}
