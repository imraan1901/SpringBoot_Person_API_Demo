package com.demo.person.person;

import com.demo.person.hobby.HobbyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock private PersonRepository personRepository;
    @Mock private HobbyRepository hobbyRepository;
    private PersonService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PersonService(personRepository, hobbyRepository);
    }

    @Test
    void TestCanAddNewPerson() {
        // given
        Person person = new Person(
                "Imraan",
                "1,3,5",
                "458 sandy mountain dr.",
                "510-123-4567"
        );
        // when
        underTest.addNewPerson(person);

        // then
        ArgumentCaptor<Person> personArgumentCaptor =
                ArgumentCaptor.forClass(Person.class);

        verify(personRepository)
                .save(personArgumentCaptor.capture());

        Person capturedPerson = personArgumentCaptor.getValue();

        assertThat(capturedPerson).isEqualTo(person);
    }
}