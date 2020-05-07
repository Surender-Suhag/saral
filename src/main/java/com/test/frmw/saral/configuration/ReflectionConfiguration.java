package com.test.frmw.saral.configuration;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReflectionConfiguration {

    @Value("${saral.keywords.package}")
    private String keywordsPackage;

    @Bean
    public Reflections reflections(){

        Reflections ref = new Reflections(packagesToScan());

        return ref;
    }

    private String packagesToScan(){
        return keywordsPackage;
    }
}
