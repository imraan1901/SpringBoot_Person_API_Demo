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
            repository.saveAll(
                    List.of(new Hobby(
                            "Running"
                    ), new Hobby(
                            "Woodworking"
                    ), new Hobby(
                            "Pottery"
                    ), new Hobby(
                            "Stargazing"
                    ), new Hobby(
                            "Cooking"
                    ), new Hobby(
                            "Gardening"
                    ), new Hobby(
                            "Backpacking"
                    ))
            );
        };

    }
}