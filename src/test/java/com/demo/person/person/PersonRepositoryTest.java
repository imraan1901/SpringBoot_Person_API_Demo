package com.demo.person.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void TestCheckPersonByPhoneNumber() {
        // given
        Person person = new Person(
                "Sam",
                "2,4,5",
                "460 sandy mountain dr.",
                "510-189-4051"
        );
        underTest.save(person);

        // when
        Optional<Person> p = underTest.findPersonBy(person.getPhoneNumber());

        // then
        assert(p.isPresent() && p.get().getPhoneNumber().equals("510-189-4051"));
    }
}