package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * JPA가 사용하는 프록시 객체를 jackson이 무시함(null). 
 */
@Configuration
public class HibernateConfiguration {
	@Bean
	Hibernate5Module hibernate5Module()
	{
		return new Hibernate5Module();
	}
}
