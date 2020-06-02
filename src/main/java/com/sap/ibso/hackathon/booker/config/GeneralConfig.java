package com.sap.ibso.hackathon.booker.config;

import com.sap.ibso.hackathon.booker.service.ExecutionContextHolderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class GeneralConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public ExecutionContextHolderService executionContextHolderService() {
        return ExecutionContextHolderService.getInstance();
    }
}
