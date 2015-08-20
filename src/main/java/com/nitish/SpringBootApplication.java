package com.nitish;

import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableWebMvc
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setShowBanner(false);
        springApplication.setHeadless(false);
        springApplication.setWebEnvironment(false);
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
