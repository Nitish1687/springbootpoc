package com.nitish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableAutoConfiguration
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setShowBanner(false);
        springApplication.setHeadless(false);
        springApplication.setWebEnvironment(false);
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplication.class, args);
    }
}
