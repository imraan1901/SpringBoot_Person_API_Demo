package com.demo.person.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunnerPerson(
            PersonRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Person(
                            "Imraan",
                            "1,3,5",
                            "458 sandy mountain dr.",
                            "510-123-4567"
                    ),
                    new Person(
                            "Robert",
                            "1,4,6",
                            "459 sandy mountain dr.",
                            "510-178-4127"
                    ),
                    new Person(
                            "Sam",
                            "2,4,5",
                            "460 sandy mountain dr.",
                            "510-189-4051"
                    )
            ));
        };
    };
}
