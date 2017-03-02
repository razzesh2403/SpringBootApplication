package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.mvc")
@EnableJpaRepositories(basePackages={"com.mvc"})

public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);
	}
}
