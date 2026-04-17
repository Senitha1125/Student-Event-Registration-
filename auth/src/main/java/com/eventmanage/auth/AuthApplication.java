package com.eventmanage.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }


    @Value("${spring.data.mongodb.uri:NOT_FOUND}")
    private String mongoUri;

    @Bean
    public CommandLineRunner testMongoUri() {
        return args -> {
            System.out.println("🔥 Mongo URI loaded: " + mongoUri);
        };
    }
}
