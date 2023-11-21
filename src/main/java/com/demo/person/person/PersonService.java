package com.demo.person.person;

import com.demo.person.hobby.Hobby;
import com.demo.person.hobby.HobbyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final HobbyRepository hobbyRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, HobbyRepository hobbyRepository) {
        this.personRepository = personRepository;
        this.hobbyRepository = hobbyRepository;
    }

    public ResponseEntity<String> addNewPerson(Person p) {
        Optional<Person> person =
                personRepository.findPersonBy(p.getPhoneNumber());
        if (person.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("phone number taken");
        }
        personRepository.save(p);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("person added");
    }

    public ResponseEntity<String> getPerson(long personId) {
        Optional<Person> person = personRepository.findById(personId);

        if(person.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("person with id " + personId + " does not exist");
        }
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(person.toString());
    }

    public ResponseEntity<?> getAllPersonWithHobby(String h) {
        Optional<Hobby> hobby = hobbyRepository.findHobbyBy(h);

        if(hobby.isEmpty()) {
            ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("no hobbies in database");
        }

        List<Person> persons = personRepository.findAll();
        List<String> personsWithHobby = new ArrayList<>();

        for (Person p: persons) {
            String temp = p.getHobbies();
            List<String> myList = new ArrayList<>(Arrays.asList(temp.split(",")));
            if (myList.contains(hobby.get().IdToString())) {
                personsWithHobby.add(p.getName());
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(personsWithHobby);
    }

    @Transactional
    public ResponseEntity<?>  updatePerson(Long personId, String hobbies, String address) {
        Optional<Person> person = personRepository.findById(personId);

        if (person.isEmpty()) {
            ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("person with id " + personId + " not found");
        }

        if (hobbies != null &&
                hobbies.length() > 0 &&
                !Objects.equals(person.get().getHobbies(), hobbies)) {
            person.get().setHobbies(hobbies);
        }

        if (address != null &&
                address.length() > 0 &&
                !Objects.equals(person.get().getAddress(),address)) {
            person.get().setAddress(address);
        };
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(person);
    }
}
