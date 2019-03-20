package com.test.web.configurations;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
@EnableJpaRepositories( basePackages = "com.test.web.repositories")
public class JpaConfiguration
{
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf)
	{
		return new JpaTransactionManager(emf); 
	}
}
