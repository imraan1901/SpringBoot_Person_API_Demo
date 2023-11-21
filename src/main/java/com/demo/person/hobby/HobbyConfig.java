package com.demo.person.hobby;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HobbyConfig {

    @Bean
    CommandLineRunner commandLineRunnerHobby(
            HobbyRepository repository) {
        return args -> {
            // Load initial data for demo
            if(repository.count() == 0 ) {
                repository.saveAll(
                        List.of(new Hobby(
                                "running"
                        ), new Hobby(
                                "woodworking"
                        ), new Hobby(
                                "pottery"
                        ), new Hobby(
                                "stargazing"
                        ), new Hobby(
                                "cooking"
                        ), new Hobby(
                                "gardening"
                        ), new Hobby(
                                "backpacking"
                        ))
                );
            }
        };

    }
}