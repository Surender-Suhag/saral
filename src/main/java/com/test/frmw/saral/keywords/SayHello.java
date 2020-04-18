package com.test.frmw.saral.keywords;

import com.test.frmw.saral.kw.AbstractSeleniumKeyword;
import com.test.frmw.saral.kw.KeywordAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KeywordAnnotation(name="")
public class SayHello extends AbstractSeleniumKeyword {

    private static final Logger logger = LoggerFactory.getLogger(SayHello.class);


    @Override
    public void run() {
        logger.info("Execution run from SayHello in com.test.frmw.saral.keywords");
    }
}
