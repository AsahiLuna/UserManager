package com.asahi.usermanager.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan({"com.asahi.usermanager.user.service", "com.asahi.usermanager.user.controller"})
@EntityScan("com.asahi.usermanager.user.model")
@EnableMongoRepositories("com.asahi.usermanager.user.dao")
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
