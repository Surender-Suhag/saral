package com.test.frmw.saral;

import com.test.frmw.saral.kw.AutomationKeyword;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({@PropertySource("classpath:frmw.properties")})
public class SaralApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaralApplication.class, args);

	}



}
