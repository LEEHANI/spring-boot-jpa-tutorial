package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * JPA�� ����ϴ� ���Ͻ� ��ü�� jackson�� ������(null). 
 */
@Configuration
public class HibernateConfiguration {
	@Bean
	Hibernate5Module hibernate5Module()
	{
		return new Hibernate5Module();
	}
}
