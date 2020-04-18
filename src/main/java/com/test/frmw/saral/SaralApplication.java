package com.test.frmw.saral;

import com.test.frmw.saral.kw.AutomationKeyword;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = AutomationKeyword.class))
public class SaralApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaralApplication.class, args);

	}

}
