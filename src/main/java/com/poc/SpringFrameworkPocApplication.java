package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@CrossOrigin(origins = "*")
public class SpringFrameworkPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkPocApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/roles/**"))
				.apis(RequestHandlerSelectors.basePackage("com.rahul.demo"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Demo Project In Spring Boot",
				"Sample API development in Spring Boot",
				"1.0.0",
				"https://github.com/rahulraogrr/spring-framework-poc/blob/master/CODE_OF_CONDUCT.md",
				new springfox.documentation.service.Contact(
						"Rahul Rao Gonda",
						"https://github.com/rahulraogrr",
						"rahulrao.grr@gmail.com"
						),
				"MIT License",
				"https://github.com/rahulraogrr/spring-framework-poc/blob/master/LICENSE",
				Collections.emptyList()
				);
	}
}