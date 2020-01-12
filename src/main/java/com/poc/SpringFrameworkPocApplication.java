package com.poc;

import com.poc.constants.ProfileConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * <p>Bootstrap Spring Boot Application</p>
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author Rahul Rao Gonda
 */
@SpringBootApplication
@EnableSwagger2
@CrossOrigin(origins = "*")
public class SpringFrameworkPocApplication
implements InitializingBean{

	private static final Logger log = LoggerFactory.getLogger(SpringFrameworkPocApplication.class);

	private final Environment environment;

	public SpringFrameworkPocApplication(Environment environment) {
		this.environment=environment;
	}

	/**
	 * <p>Main Method</p>
	 * @param args {@link String} Array
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringFrameworkPocApplication.class);
		Environment environment = app.run(args).getEnvironment();
		logApplicationStartup(environment);
	}

	/**
	 * <p>Load Application Start-Up</p>
	 * @since 1.0.0
	 * @param environment {@link Environment}
	 */
	private static void logApplicationStartup(Environment environment) {
		String protocol = "http";
		if (environment.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		String serverPort = environment.getProperty("server.port");
		String contextPath = environment.getProperty("server.servlet.context-path");
		if (StringUtils.isBlank(contextPath)) {
			contextPath = "/";
		}
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("\n------------------------------------------------------------------------------\n\t" +
				"Application: '{}' is running! Access URLs:\n\t" +
				"Local: \t\t{}://localhost:{}{}\n\t" +
				"External: \t{}://{}:{}{}\n\t" +
				"Profile(s): \t{}\n------------------------------------------------------------------------------",
				environment.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				environment.getActiveProfiles());
	}

	/**
	 * Initializes SpringFrameworkPocApplication.
	 * <p>
	 * Spring profiles can be configured with a program argument
	 * --spring.profiles.active=your-active-profile
	 * <p>
	 */
	@Override
	public void afterPropertiesSet(){
		Collection<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
		if (activeProfiles.contains(ProfileConstants.SPRING_PROFILE_DEVELOPMENT) &&
				activeProfiles.contains(ProfileConstants.SPRING_PROFILE_PRODUCTION)) {
			log.error("You have mis-configured your application! It should not run " +
					"with both the '"+ProfileConstants.SPRING_PROFILE_DEVELOPMENT+"' " +
					"and '"+ProfileConstants.SPRING_PROFILE_PRODUCTION+"' profiles at the same time.");
		}
		if (activeProfiles.contains(ProfileConstants.SPRING_PROFILE_DEVELOPMENT) &&
				activeProfiles.contains(ProfileConstants.SPRING_PROFILE_CLOUD)) {
			log.error("You have mis-configured your application! It should not " +
					"run with both the '"+ProfileConstants.SPRING_PROFILE_DEVELOPMENT+"' " +
					"and '"+ProfileConstants.SPRING_PROFILE_CLOUD+"' profiles at the same time.");
		}
		if (activeProfiles.contains(ProfileConstants.SPRING_PROFILE_PRODUCTION) &&
				activeProfiles.contains(ProfileConstants.SPRING_PROFILE_SWAGGER)) {
			log.error("You have mis-configured your application! It should not " +
					"run with both the '"+ProfileConstants.SPRING_PROFILE_PRODUCTION+"' " +
					"and '"+ProfileConstants.SPRING_PROFILE_SWAGGER+"' profiles at the same time.");
		}
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*/**"))
				.apis(RequestHandlerSelectors.basePackage("com.poc"))
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
						"https://rahulraogrr.github.io/spring-framework-poc/",
						"rahulrao.grr@gmail.com"
						),
				"MIT License",
				"https://github.com/rahulraogrr/spring-framework-poc/blob/master/LICENSE",
				Collections.emptyList()
				);
	}
}