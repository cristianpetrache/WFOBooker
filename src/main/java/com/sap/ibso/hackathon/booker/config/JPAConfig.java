package com.sap.ibso.hackathon.booker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.sap.ibso.hackathon.booker.jpa.repo")
@EnableTransactionManagement
public class JPAConfig {
}
