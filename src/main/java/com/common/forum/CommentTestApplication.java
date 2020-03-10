package com.common.forum;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.thymeleaf.dialect.springdata.SpringDataDialect;


@SpringBootApplication
@EntityScan(basePackageClasses = {CommentTestApplication.class, Jsr310JpaConverters.class})
public class CommentTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentTestApplication.class, args);
	}

	
	@Bean
	public SpringDataDialect springDataDialect() {
	  return new SpringDataDialect();
	}
}
