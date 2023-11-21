package com.demo.person.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<String> RegisterNewPerson(@RequestBody Person person) {
        return personService.addNewPerson(person);
    }

    @GetMapping(path = "hobby")
    public ResponseEntity<?> getAllPersonWithHobby(@RequestParam String hobby) {
        return personService.getAllPersonWithHobby(hobby);
    }

    @GetMapping(path = "{personId}")
    public ResponseEntity<String> getPerson(@PathVariable("personId") long personId) {
        return personService.getPerson(personId);
    }

    @PutMapping(path = "{personId}")
    public ResponseEntity<String> updatePerson(@PathVariable("personId") long personId,
                                @RequestParam(required = false) String hobbies,
                               @RequestParam(required = false) String address) {

        return personService.updatePerson(personId, hobbies, address);
    }
}
