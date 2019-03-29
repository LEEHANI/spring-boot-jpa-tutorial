package com.test.web.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.test.web"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder()
				.title("JPA Tutorial")
				.description("API document")
				.contact(new Contact("HaniLee", "https://github.com/LEEHANI", "rorean@naver.com"))
				.version("1.0.0")
				.build();
	}
}
