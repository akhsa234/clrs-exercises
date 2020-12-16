package com.bahar.blog.controller;

import com.bahar.blog.model.Person;
import com.bahar.blog.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK )
    public List<Person> people() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Person getName(@PathVariable Long id) {
        return personRepository.findNameById(id);
    }

    @GetMapping("/fullname/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Person getFullname(@PathVariable Long id) {
        return personRepository.findNameAndLastNameById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED )
    public Person save(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK )
    public void deletePersonByID(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK )
    public Person replacePerson(@Valid @RequestBody Person newPerson, @PathVariable Long id) {

        return personRepository.findById(id)
                .map(Person -> {
                    Person.setCountry(newPerson.getCountry());
                    Person.setDescription(newPerson.getDescription());
                    Person.setEmail(newPerson.getEmail());
                    Person.setFirstName(newPerson.getFirstName());
                    Person.setGender(newPerson.getGender());
                    Person.setLastName(newPerson.getLastName());
                    Person.setNatinalCode(newPerson.getNatinalCode());
                    Person.setPhone(newPerson.getPhone());
                    return personRepository.save(Person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

}
