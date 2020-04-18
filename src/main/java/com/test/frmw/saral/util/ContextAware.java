package com.test.frmw.saral.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextAware implements ApplicationContextAware {

    Logger logger = LoggerFactory.getLogger(ContextAware.class);

    ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }

    public String getBasePackage(){

        logger.info("*********************************************************");
        logger.info(appContext.getClass().getName());
        logger.info("*********************************************************");

        return null;
    }
}
