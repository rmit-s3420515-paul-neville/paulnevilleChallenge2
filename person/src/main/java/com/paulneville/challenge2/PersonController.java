package com.paulneville.challenge2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PersonController {
    private final PersonRepository repository;

    PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person newPerson) {
        log.info("New Person Created {}", newPerson);
        return repository.save(newPerson);
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        List<Person> allPersons = repository.findAll();
        log.info("Get all persons {}", allPersons.size());
        return allPersons;
    }

    @GetMapping(path = "/persons/{personId}")
    public Person getPersonById(@PathVariable("personId") Long personId) {
        log.info("Get person by id {}", personId);
        return repository.findById(personId)
                .orElseThrow();
    }

    @PutMapping("/persons/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long personId) {
        log.info("Replace person by id {}", personId);
        return repository.findById(personId)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setAddress(newPerson.getAddress());
                    person.setPostcode(newPerson.getPostcode());
                    person.setAge(newPerson.getAge());
                    person.setJob(newPerson.getJob());
                    person.setEmail(newPerson.getEmail());
                    person.setPhoneNumber(newPerson.getPhoneNumber());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(personId);
                    return repository.save(newPerson);
                });
    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Long personId) {
        log.info("Delete person by id {}", personId);
        repository.deleteById(personId);
    }
}