package com.test.frmw.saral.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
    public static String getNonEmptyValue(String source,String defaultValue){
        return (source == null || source.isEmpty()) ? defaultValue : source;
    }
}
